var dashApp = angular.module('dashApp', [ 'ui.bootstrap', 'jh.calendar', 'ngSanitize' ]);

// figure out which semester this is based on the URL
var sem = /~[^\/]*\/([^\/]*)\//.exec(window.location.href)[1];

// URLs of necessary CGI scripts
var cgi = '../../cgi-bin/' + sem + '/dashboard.cgi';
var submitcgi  = '../../cgi-bin/' + sem + '/submit.cgi';
var clickercgi = '../../cgi-bin/' + sem + '/clicker_id_entry.cgi';

// Dirty rotten hack to force JSON to serialize dates in the local time zone
// Relies on the date formatting library pasted at the bottom of this script
Date.prototype.toJSON = function() {
  return this.format('isoDateTime');
};

dashApp.controller('clickerEntryModalController', function ($scope, $http, $modalInstance, items) {
  $scope.parent = items.parent;
  $scope.clickerid = '';
  $scope.loading = false;

  $scope.cancel = function() { $modalInstance.dismiss('cancel'); };

  $scope.completed = function (data, status, headers, config) {
    $scope.parent.updateDashboard();
    $scope.cancel();
    $scope.loading = false;
  };

  $scope.update = function(cid) {
    $scope.loading = true;
    $http.get(clickercgi, {
      cache: false, /* don't cache this request */
      params: { clickerid: cid }
    }).success($scope.completed).error($scope.completed);
  };
});

dashApp.controller('dashSubmissionModalController', function ($scope, $http, $modalInstance, items) {
  // default to submission form
  $scope.showReceipt = false;
  $scope.loading     = true;

  $scope.group = { members: null, updateable: false };

  var itemFields = [ 'parent', 'task' ];
  for (i in itemFields)
    if (items.hasOwnProperty(itemFields[i]))
      $scope[itemFields[i]] = items[itemFields[i]];

  $scope.needToReload = function(data, status, headers, config) {
    console.log(status);
    console.log(headers);

    var modalInstance = $modal.open({
      templateUrl: 'templates/need_to_reload.html',
      size: 'sm',
    });

    modalInstance.result.then();
  };

  $scope.retrieveTaskForm = function(register) {
    $scope.loading = true;
    console.log($scope.task);
    console.log($scope);
    $http.post(cgi, { cmd: (register ? 'register_group' : 'submit_task'),
                      task: $scope.task,
                      user: $scope.parent.pennkey,
                      members: $scope.group.members })
      .success(function (data, status, headers, config) {
        var fields = [ 'tdata', 'tfiles', 'attempts', 'allowed', 'remaining', 'group', 'submit_options' ];
        for (var field in fields) {
          var f = fields[field];
          $scope[f] = data.hasOwnProperty(f) ? data[f] : undefined;
        }
        $scope.loading = false;
        $scope.remaining = $scope.allowed - $scope.attempts;
        console.log($scope);
      }).error($scope.needToReload);
  }

  $scope.submitTask = function() {
    $scope.loading = true;

    // get the form data for submission
    var form = document.getElementById('submission_form');
    var fd = new FormData(form);

    // we want to submit and receive JSON back
    fd.append('json', true);
    fd.append('do', 'Submit');

    // switch to receipt view
    $scope.showReceipt = true;

    // submit the form
    $http.post(submitcgi, fd, {
      transformRequest: angular.identity,
      headers: { 'Content-Type': undefined }
    }).success(function (data, status, headers, config) {
      var fields = [ 'sdata', 'file_receipt', 'test_receipt' ];
      for (var field in fields) {
        var f = fields[field];
        $scope[f] = data.hasOwnProperty(f) ? data[f] : undefined;
      }

      $scope.parent.updateDashboard();
      $scope.loading = false;
    }).error($scope.needToReload);
  }

  $scope.cancel = function() { $modalInstance.dismiss('cancel'); };

  $scope.retrieveTaskForm(false);
});

dashApp.controller('dashController', function ($scope, $http, $modal, $location) {
  $scope.dateFormat = 'ddd, d MMM h:mm tt';

  // basic student info
  $scope.pennkey     = undefined;
  $scope.name        = undefined;
  $scope.email       = undefined;
  $scope.lecture     = undefined;
  $scope.recitation  = undefined;
  $scope.clickerid   = undefined;

  // task info
  $scope.taskheaders = [];
  $scope.tasks       = [];

  // clicker and recitation info
  $scope.clickerCalOptions = { supershortday: true };
  $scope.clickermonths = [];
  $scope.recitationmonths = [];

  // accordion open/close controls
  $scope.submitAccordion = true;
  $scope.scoresAccordion = true
  $scope.quizzesAccordion = true;
  $scope.clickerAccordion = true;
  $scope.recitationAccordion = true;

  $scope.userParam = undefined;
  if ($location.search().hasOwnProperty('user'))
    $scope.userParam = $location.search().user;

  $scope.needToReload = function(data, status, headers, config) {
    console.log(status);
    console.log(headers);

    var modalInstance = $modal.open({
      templateUrl: 'templates/need_to_reload.html',
      size: 'sm',
    });

    modalInstance.result.then();
  };

  $scope.openSubmitForm = function (task) {
    var modalInstance = $modal.open({
      templateUrl: 'templates/hw_submission_modal.html?14',
      controller:  'dashSubmissionModalController',
      resolve: { items: function () { return { 'parent': $scope, task: task }; } },
      size: 'lg',
    });

    modalInstance.result.then();
  };

  $scope.enterClickerID = function() {
    var modalInstance = $modal.open({
      templateUrl: 'templates/clicker_registration_form.html',
      controller: 'clickerEntryModalController',
      resolve: { items: function() { return { 'parent': $scope }; } },
      size: 'lt',
    });

    modalInstance.result.then();
  };

  $scope.updateData = function(data) {
    // copy data over from the request
    var copyFields = [ 'pennkey', 'name', 'email', 'lecture', 'recitation', 'clickerid', 'tasks',
                       'quizzes', 'score_headers', 'scores', 'clickers', 'recitations' ]
    for (var i = 0; i < copyFields.length; i++) {
      $scope[copyFields[i]] = data.hasOwnProperty(copyFields[i]) ? 
        data[copyFields[i]] : undefined;
    }

    console.log($scope);

    // figure out which months to show in the clicker and recitation calendars
    $scope.clickermonths    = $scope.getCalendarMonths('clickers');
    $scope.recitationmonths = $scope.getCalendarMonths('recitations');
  };

  $scope.getCalendarMonths = function(key) {
    var months = []

    if ($scope.hasOwnProperty(key)) {
      for (var prop in $scope[key])
        months.push(prop);

      months.sort();

      for (var i = 0; i < months.length; i++)
        months[i] = new Date(months[i] + '-01');

      return months;
    }
  };

  $scope.updateDashboard = function() {
    var cmd = { 'cmd': 'dashboard' };
    if ($scope.userParam)
        cmd.user = $scope.userParam;

    $http.post(cgi, cmd).success(function (data, status, headers, config) {
      $scope.updateData(data);
    }).error($scope.needToReload);
  }

  $scope.updateDashboard();
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
