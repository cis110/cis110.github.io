var ohApp = angular.module('ohApp', [ /* 'ui.bootstrap' */ ]).directive('ngJqxsettings', ngJqxsettings);

// figure out which semester this is based on the URL
var sem = /~[^\/]*\/([^\/]*)\//.exec(window.location.href)[1];

var cgi = '../../cgi-bin/' + sem + '/ohsignup.cgi';

// Dirty rotten hack to force JSON to serialize dates in the local time zone
// Relies on the date formatting library pasted at the bottom of this script
Date.prototype.toJSON = function() {
  return this.format('isoDateTime');
};

function newQueueVals() {
  var vals = { Name: null, StudentVisible: true, Notes: null };

  vals.StartTime = new Date();
  vals.StartTime.setHours(15, 0, 0, 0); // default to starting at 3:00pm

  vals.EndTime = new Date(vals.StartTime.toDateString());
  vals.EndTime.setHours(21);            // default to ending at 9:00pm

  vals.LastCall = new Date(vals.StartTime.toDateString());
  vals.LastCall.setHours(20, 30);       // default to last call at 8:30pm

  return vals;
}

ohApp.controller('ohController', function ($scope, $http, $compile) {
  $scope.theme = 'energyblue';
  $scope.dateFormat = 'ddd, d MMM h:mm tt';
  $scope.queues = [];
  $scope.user   = null;
  $scope.status = null;
  $scope.history = undefined;

  $scope.helplog = { Source: '', Question: '', Resolution: '' };

  $scope.signUpQueue = { QueueID: null, Name: null,
                         Question: null, Comments: null,
                         Outcome: null,
                         lastUpdate: Date.now() };

  $scope.updateData = function(data) {
    // console.log('received:');
    // console.log(data);

    var vars = [ 'user', 'status', 'queues', 'lastUpdate', 'history', 'history_headings' ];
    for (i in vars)
      if (data.hasOwnProperty(vars[i]))
        $scope[vars[i]] = data[vars[i]];

    // console.log($scope);
  };

  $scope.submitHelpLogEntry = function() {
    cmd = [ 'add_help_log_entry', $scope.helplog ];
    $http.post(cgi, [ cmd ] ).success(function(data, status, headers, config) {
      $scope.updateData(data);
      $scope.clearHelpLogForm();
    });
  };

  $scope.clearHelpLogForm = function() {
    $scope.helplog.Source     = '';
    $scope.helplog.Question   = '';
    $scope.helplog.Resolution = '';
  };

  $scope.showSignUpDialog = function(q) {
    $scope.signUpQueue.QueueID    = q.QueueID;
    $scope.signUpQueue.Name       = q.Name;
    $scope.signUpQueue.Question   = '';
    $scope.signUpQueue.Comments   = '';
    $scope.signUpQueue.Resolution = '';

    $('#ohSignUpDialog').jqxWindow('open');
  };

  $scope.showUpdateDialog = function() {
    $scope.signUpQueue.QueueID  = $scope.status[0].QueueID;
    $scope.signUpQueue.Name     = $scope.status[0].Name;
    $scope.signUpQueue.Question = $scope.status[0].Question;
    $scope.signUpQueue.Comments = $scope.status[0].Comments;
    $scope.signUpQueue.Resolution = $scope.status[0].Resolution;

    $('#ohUpdateDialog').jqxWindow('open');
  };

  $scope.showRemoveDialog = function() {
    if (!confirm('Are you sure you want to remove yourself from this queue?\n\n' +
                 'If you just need to change your question but stay in the same queue, ' +
                 'click Cancel and use the Update Question/Comments button instead so ' +
                 'you don\'t lose your place in line.'))
      return;

    cmd = [ 'remove_student', $scope.status[0].QueueID ];
    console.log(cmd);
    $http.post(cgi, [ cmd ] ).success(function(data, status, headers, config) {
      $scope.updateData(data);
    });
  };

  $scope.submitSignUp = function() {
    var cmd = [ 'add_student', $scope.signUpQueue.QueueID,
                $scope.signUpQueue.Question, $scope.signUpQueue.Comments ];
    $http.post(cgi, [ cmd ]).success(function(data, status, headers, config) {
      $scope.updateData(data);
      $('#ohSignUpDialog').jqxWindow('close');
    });
  };

    $scope.showResolutionUpdateDialog = function(row) {
      $scope.resolutionUpdate = {};
      $scope.resolutionUpdate.SeenAt = row['Helped At'];
      $('#ohResolutionDialog').jqxWindow('open');
  };

  $scope.submitResolutionUpdate = function() {
      var params = {};
      params.Resolution = $scope.resolutionUpdate.update;
      params.SeenAt = $scope.resolutionUpdate.SeenAt;
      var command = ['update_past_resolution', params];
      $http.post(cgi, [ command ]).success(function(data, status, headers, config) {
          console.log(data['test']);
          console.log(data);
        $scope.updateData(data);
        $('#ohResolutionDialog').jqxWindow('close');
    });
  };


  $scope.submitUpdate = function() {
    var params = {};

    if ($scope.signUpQueue.Question != $scope.status[0].Question)
      params.Question = $scope.signUpQueue.Question;

    if ($scope.signUpQueue.Comments != $scope.status[0].Comments)
      params.Comments = $scope.signUpQueue.Comments;

    if ($scope.signUpQueue.Resolution != $scope.status[0].Resolution)
      params.Resolution = $scope.signUpQueue.Resolution;

    var cmd = [ 'update_student', $scope.signUpQueue.QueueID, params ];

    $http.post(cgi, [ cmd ]).success(function(data, status, headers, config) {
      $scope.updateData(data);
      $('#ohUpdateDialog').jqxWindow('close');
    });
  };

  $scope.refresh = function() {
    $http.get(cgi).success(
      function(data, status, headers, config) {
        $scope.updateData(data);
        setTimeout($scope.refresh, 10000);
      });
  };

  angular.element(document).ready(function() {
    $scope.refresh();
  });
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
