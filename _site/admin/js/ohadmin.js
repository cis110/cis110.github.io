var ohApp = angular.module('ohApp', [ 'ui.bootstrap', 'ngAudio' ]).directive('ngJqxsettings', ngJqxsettings);

// figure out which semester this is based on the URL
var sem = /~[^\/]*\/([^\/]*)\//.exec(window.location.href)[1];

var cgi = '../../cgi-bin/' + sem + '/ohadmin.cgi';

// Dirty rotten hack to force JSON to serialize dates in the local time zone
// Relies on the date formatting library pasted at the bottom of this script
Date.prototype.toJSON = function() {
  return this.format('isoDateTime');
};

function newQueueVals() {
  var vals = { Name: null, StudentVisible: true, Notes: null };

  vals.StartTime = new Date();
  vals.StartTime.setHours(14, 0, 0, 0); // default to starting at 2:00pm

  if (vals.StartTime.getDay() == 3)
    vals.StartTime.setHours(16, 0, 0, 0); // ... except on Wednesday we start at 4:00pm

  if (vals.StartTime.getDay() == 4)
    vals.StartTime.setHours(12, 0, 0, 0); // ... and Thursday we start at noon

  vals.EndTime = new Date(vals.StartTime.toDateString());
  vals.EndTime.setHours(21);            // default to ending at 9:00pm

  vals.LastCall = new Date(vals.StartTime.toDateString());
  vals.LastCall.setHours(20, 30);       // default to last call at 8:30pm

  return vals;
}

ohApp.controller('ohController', function ($scope, $http, $compile, ngAudio) {
  $scope.theme = 'energyblue';
  $scope.dateFormat = 'ddd, d MMM h:mm tt';
  $scope.queues = [];
  $scope.futureQueues = [];
  $scope.waitlists = {};
  $scope.ohUQ = newQueueVals();
  $scope.currentStudent = [];
  $scope.escQueue = [];
  $scope.isOpen = true;
  $scope.audio = ngAudio.load('../admin/audio/chime.wav');
  console.log($scope.ohUQ);

  $scope.updateData = function(data) {
    // console.log('received:');
    // console.log(data);

    var wasEmpty = true;
    var  isEmpty = true;
    for (q in data.queues) {
      if (q._LoggedIn == 'yes') {
        if (data[waitlists][q.QueueID].length > 0)
           wasEmpty = false;
        if ($scope[waitlists][q.QueueID].length > 0)
           isEmpty = false;
      }
    }
    
    if (wasEmpty && !isEmpty) {
      $scope.audio.play();
    }
     

    var copyFields = [ 'user', 'queues', 'futureQueues', 'waitlists', 'currentStudent', 'escQueue' ];
    for (var i = 0; i < copyFields.length; i++) {
      if (data.hasOwnProperty(copyFields[i]))
        $scope[copyFields[i]] = data[copyFields[i]];
    }

    if (data.hasOwnProperty('waitlists')) {
      //*
      // update the tabs to match the active queues
      var tabs = $('#waitlist_tabs');
      var numTabs = tabs.jqxTabs('length');
      var numQueues = $scope.queues.length;

      // make sure we don't have to many tabs...
      if (numTabs > numQueues)
        for (var i = 0; i < numTabs - numQueues; i++)
          tabs.jqxTabs('removeLast');

      // ...or too few
      if (numTabs < numQueues)
        for (var i = 0; i < numQueues - numTabs; i++)
          tabs.jqxTabs('addLast');

      // now set the content
      for (var i = 0; i < $scope.queues.length; i++) {
        var q = $scope.queues[i];
        var qid = $scope.queues[i].QueueID;

        tabs.jqxTabs('setTitleAt', i, q.Name);
        var t = tabs.jqxTabs('getContentAt', i);
        var tqid = $(t).find('input');
        // console.log(tqid);
        if (tqid.length > 0) tqid = tqid[0].value;
        else tqid = null;
        if (tqid == qid) continue; // this tab is already set up for this queue

        // fill in this tab's content appropriately
        // console.log('qid = ' + qid);
        tabHtml  = '<input type="hidden" value="' + qid + '">\n';
        tabHtml += '<table class="table table-responsive table-striped"><tr><th>Time</th><th>PennKey</th><th>Name</th><th>Helper</th><th>Question</th><th>Comments</th></tr>\n';
        tabHtml += '<tr ng-repeat="row in waitlists.q' + qid +'"><td>{{row.TStamp}}<td>{{row.PennKey}}</td><td>{{row.Name}}</td>' +
          '<td>{{row.TAPennKey}}</td><td>{{row.Question}}</td><td>{{row.Comments}}</td></tr>\n';
        tabHtml += '</table>'
        tabs.jqxTabs('setContentAt', i, $compile(tabHtml)($scope));
        $compile(tabs.jqxTabs('getContentAt', i))($scope);
      }
      // */
    }
  };

  $scope.queueLogin = function(queue) {
    // console.log(queue);
    $http.post(cgi, [ [ 'set_queue_login', queue.QueueID, queue._LoggedIn ] ]).success($scope.updateData);
  };

  $scope.deleteFutureQueue = function(queue) {
    console.log(queue.QueueID);
    $http.post(cgi, [ [ 'delete_queue', queue.QueueID ] ]).success($scope.updateData);
  };

  $scope.openOHQueueUpdateWindow = function(queue, reset) {
    var q = queue ? queue : newQueueVals();
    $scope.ohUQ = $.extend(true, {}, q);
    $scope.ohUQ._orig = q;

    // convert date values to objects if they are strings
    // the real problem is that the JS date constructor is terrible at parsing date strings
    [ 'StartTime', 'EndTime', 'LastCall' ].forEach(function(prop) {
      if (typeof($scope.ohUQ[prop]) == 'string') {
        // console.log($scope.ohUQ[prop].replace(' ', 'T'));
        $scope.ohUQ[prop] = new Date($scope.ohUQ[prop].replace(' ', 'T'));
        // console.log($scope.ohUQ[prop]);
      }
    });
    // console.log($scope.ohUQ);
    if (!reset) $('#ohQueueUpdateButton').text(queue ? 'Update' : 'Add');
    $('#ohQueueUpdate').jqxWindow('open');
  };

  $scope.updateQueue = function() {
    // console.log($scope.ohUQ.StartTime.toJSON());
    // console.log($scope.ohUQ.LastCall.toJSON());
    // console.log($scope.ohUQ.EndTime.toJSON());
    console.log(JSON.stringify($scope.ohUQ));
    $http.post(cgi, [ [ 'queue', $scope.ohUQ ] ]).success(function (data, status, headers, config) {
      console.log(data);
      $scope.updateData(data);
      $('#ohQueueUpdate').jqxWindow('close');
    });
  }

  $scope.getCurrentStudent = function() {
    $http.post(cgi, [ [ 'helpStudent' ] ]).success(function(data, status, headers, config) {
      $scope.updateData(data);
    });
  }

  $scope.resolveStudent = function(outcome) {
    var req = [ [ 'resolve_student', { queue_id: $scope.currentStudent[0].QueueID, pennkey: $scope.currentStudent[0].PennKey, outcome: outcome } ] ];
    // console.log(JSON.stringify(req));
    $http.post(cgi, req).success(function(data, status, headers, config) {
      $scope.updateData(data);
    });
  }

  $scope.helpEscalated = function(student, outcome) {
    var req = [ [ 'help_escalated', { pennkey: student.StudentPennKey, tstamp: student.SeenAt } ] ]
    $http.post(cgi, req).success(function(data, status, headers, config) {
      $scope.updateData(data);
    });
  }

  $scope.resolveEscalated = function(student, outcome) {
    var req = [ [ 'resolve_escalated', { pennkey: student.StudentPennKey, tstamp: student.SeenAt, outcome: outcome } ] ]
    $http.post(cgi, req).success(function(data, status, headers, config) {
      $scope.updateData(data);
    });
  }

  // trying to fix the cancel button (silly I know)
  $scope.closeQueueUpdateWindow = function() {
    $('#ohQueueUpdate').jqxWindow('close');
  } 

  angular.element(document).ready(function() {
    $scope.refresh();
  });

  $scope.refresh = function() {
    $http.get(cgi).success(
      function(data, status, headers, config) {
        $scope.updateData(data);
      }
    );
    // console.log('refreshing');
    setTimeout($scope.refresh, 5000);
  }

  $http.get(cgi).success(
    function(data, status, headers, config) {
      $scope.updateData(data);
    }
  );
});


/*
 * Date Format 1.2.3
 * (c) 2007-2009 Steven Levithan <stevenlevithan.com>
 * MIT license
 *
 * Includes enhancements by Scott Trenda <scott.trenda.net>
 * and Kris Kowal <cixar.com/~kris.kowal/>
 *
 * Accepts a date, a mask, or a date and a mask.
 * Returns a formatted version of the given date.
 * The date defaults to the current date/time.
 * The mask defaults to dateFormat.masks.default.
 */

var dateFormat = function () {
	var	token = /d{1,4}|m{1,4}|yy(?:yy)?|([HhMsTt])\1?|[LloSZ]|"[^"]*"|'[^']*'/g,
	timezone = /\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g,
	timezoneClip = /[^-+\dA-Z]/g,
	pad = function (val, len) {
		val = String(val);
		len = len || 2;
		while (val.length < len) val = "0" + val;
		return val;
	};

	// Regexes and supporting functions are cached through closure
	return function (date, mask, utc) {
		var dF = dateFormat;

		// You can't provide utc if you skip other args (use the "UTC:" mask prefix)
		if (arguments.length == 1 && Object.prototype.toString.call(date) == "[object String]" && !/\d/.test(date)) {
			mask = date;
			date = undefined;
		}

		// Passing date through Date applies Date.parse, if necessary
		date = date ? new Date(date) : new Date;
		if (isNaN(date)) throw SyntaxError("invalid date");

		mask = String(dF.masks[mask] || mask || dF.masks["default"]);

		// Allow setting the utc argument via the mask
		if (mask.slice(0, 4) == "UTC:") {
			mask = mask.slice(4);
			utc = true;
		}

		var	_ = utc ? "getUTC" : "get",
		d = date[_ + "Date"](),
		D = date[_ + "Day"](),
		m = date[_ + "Month"](),
		y = date[_ + "FullYear"](),
		H = date[_ + "Hours"](),
		M = date[_ + "Minutes"](),
		s = date[_ + "Seconds"](),
		L = date[_ + "Milliseconds"](),
		o = utc ? 0 : date.getTimezoneOffset(),
		flags = {
			d:    d,
			dd:   pad(d),
			ddd:  dF.i18n.dayNames[D],
			dddd: dF.i18n.dayNames[D + 7],
			m:    m + 1,
			mm:   pad(m + 1),
			mmm:  dF.i18n.monthNames[m],
			mmmm: dF.i18n.monthNames[m + 12],
			yy:   String(y).slice(2),
			yyyy: y,
			h:    H % 12 || 12,
			hh:   pad(H % 12 || 12),
			H:    H,
			HH:   pad(H),
			M:    M,
			MM:   pad(M),
			s:    s,
			ss:   pad(s),
			l:    pad(L, 3),
			L:    pad(L > 99 ? Math.round(L / 10) : L),
			t:    H < 12 ? "a"  : "p",
			tt:   H < 12 ? "am" : "pm",
			T:    H < 12 ? "A"  : "P",
			TT:   H < 12 ? "AM" : "PM",
			Z:    utc ? "UTC" : (String(date).match(timezone) || [""]).pop().replace(timezoneClip, ""),
			o:    (o > 0 ? "-" : "+") + pad(Math.floor(Math.abs(o) / 60) * 100 + Math.abs(o) % 60, 4),
			S:    ["th", "st", "nd", "rd"][d % 10 > 3 ? 0 : (d % 100 - d % 10 != 10) * d % 10]
		};

		return mask.replace(token, function ($0) {
			return $0 in flags ? flags[$0] : $0.slice(1, $0.length - 1);
		});
	};
}();

// Some common format strings
dateFormat.masks = {
	"default":      "ddd mmm dd yyyy HH:MM:ss",
	shortDate:      "m/d/yy",
	mediumDate:     "mmm d, yyyy",
	longDate:       "mmmm d, yyyy",
	fullDate:       "dddd, mmmm d, yyyy",
	shortTime:      "h:MM TT",
	mediumTime:     "h:MM:ss TT",
	longTime:       "h:MM:ss TT Z",
	isoDate:        "yyyy-mm-dd",
	isoTime:        "HH:MM:ss",
	isoDateTime:    "yyyy-mm-dd'T'HH:MM:ss",
	isoUtcDateTime: "UTC:yyyy-mm-dd'T'HH:MM:ss'Z'"
};

// Internationalization strings
dateFormat.i18n = {
	dayNames: [
		"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
		"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
	],
	monthNames: [
		"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
		"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
	]
};

// For convenience...
Date.prototype.format = function (mask, utc) {
	return dateFormat(this, mask, utc);
};
