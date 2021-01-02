var ohApp = angular.module('ohApp', [ 'ui.bootstrap', 'ngAudio' ]).directive('ngJqxsettings', ngJqxsettings);

// figure out which semester this is based on the URL
var sem = /~[^\/]*\/([^\/]*)\//.exec(window.location.href)[1];

var cgi = '../../cgi-bin/' + sem + '/oh_stats.cgi';

function getParameterByName(name) {
    url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

if (getParameterByName('ta_pennkey')) {
    cgi += '?ta_pennkey=' + getParameterByName('ta_pennkey');
}

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
  $scope.ta_pennkey = getParameterByName('ta_pennkey');
  $scope.dateFormat = 'ddd, d MMM h:mm tt';
    $scope.numStudentsHelpedStartDate = "01/01/2017" ;
    $scope.numStudentsHelpedEndDate = "02/01/2017" ;

    $scope.refresh = function() {
    $http.get(cgi).success(
      function(data, status, headers, config) {
        $scope.updateData(data);
      });
};


    $scope.num_students_time_period = "days";


$scope.graphNumberStudentsHelped = function () {
    var cgi_req = cgi;
    cgi_req += cgi.includes("?") ? "&num_students_helped=1" : "?num_students_helped=1";
    cgi_req += "&start_day=" + dateFormat($scope.numStudentsHelpedStartDate, "isoDate");
    cgi_req += "&end_day=" + dateFormat($scope.numStudentsHelpedEndDate, "isoDate");
    console.log(cgi);
    console.log(cgi_req);
    $http.get(cgi_req).success(function(data, status, headers, config) {
      $scope.updateData(data);
        $scope.draw_num_students_helped_graph();
    });
};

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback($scope.graphNumberStudentsHelped);


    $scope.historyHeadings = ['StudentPennKey', 'StudentQuestion', 'Outcome', 'Resolution', 'SeenAt', 'ResolvedAt'];

    $scope.draw_num_students_helped_graph = function () {


        stat_data = $scope['num_students_helped'];

            var options = {
              title: 'Number of students helped',
              legend: { position: 'botttom' },
                vAxis: {title: 'Number of students helped'},
                hAxis: {title: 'Date'}
            };

            stat_data.unshift(["Number of students", "Number of students helped"]);

            var chart_data = google.visualization.arrayToDataTable(stat_data);

            var chart = new google.visualization.ColumnChart(document.getElementById('num_students_chart'));

            chart.draw(chart_data, options);
    };



$scope.updateData = function(data) {
    for (key in data) {
        if (data.hasOwnProperty(key)) {
            $scope[key] = data[key]
        }
    }
    console.log(data);
};
angular.element(document).ready(function() {
    $scope.refresh();
});

    setInterval($scope.refresh, 10000);
    // Insert new function here
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
