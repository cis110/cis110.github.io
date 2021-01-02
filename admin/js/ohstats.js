var statsApp = angular.module('statsApp', [ 'ui.bootstrap', 'ngQuickDate' ]);
var cgi = '../../cgi-bin/15sp/ohadmin.cgi';

// Date.prototype.toJSON = function() {
//   return this.format('isoDateTime');
// };


statsApp.controller('ohStatsController', function ($scope, $http, $compile) {
	$scope.ohData = [];
	$scope.chartData = {};
	$scope.queryPennkey   = null;
	$scope.queryStart     = null;
	$scope.queryEnd       = null;
	$scope.queryTAPennkey = null;

	var toSQLDate = function(date) {
		return date.toISOString().slice(0,19).replace('T', ' ');
	}

	$scope.updateData = function(data) {
	    console.log('received:');
	    console.log(data);

	    var copyFields = [ 'ohData', 'ohHeaders' ];
	    for (var i = 0; i < copyFields.length; i++) {
        $scope[copyFields[i]] = undefined;
	      if (data.hasOwnProperty(copyFields[i]))
	        $scope[copyFields[i]] = data[copyFields[i]];
	    }
	};

	$scope.getData = function() {
	  var start = ($scope.queryStart !== null) ? toSQLDate($scope.queryStart) : null;
	  var end = ($scope.queryEnd !== null) ? toSQLDate($scope.queryEnd) : null;
	  console.log($scope.queryPennkey);
	  console.log($scope.queryTAPennkey);
	  console.log(start);
	  console.log(end);
	  $http.post(cgi, [ [ 'oh_data', { pennkey: $scope.queryPennkey, ta: $scope.queryTAPennkey, start: start, end: end } ] ])
	  	.success(function(data, status, headers, config) {
	  		// console.log(data);
	  		console.log(config);
        $scope.updateData(data);
      });
	};

	$scope.config = {
	    title: 'Products',
	    tooltips: true,
	    labels: false,
	    mouseover: function() {},
	    mouseout: function() {},
	    click: function() {},
	    legend: {
	      display: true,
	      //could be 'left, right'
	      position: 'right'
	    }
	  };


	$scope.averageHelpTime = function(data) {
		var TAs = {};
		for (var i = 0; i < data.length; i++) {
			if (Object.keys(TAs).indexOf(data[i].TaPennKey) != -1) {
				TAs[data[i].TaPennKey].time += (new Date(data[i].ResolvedAt) - new Date(data[i].SeenAt));
				TAs[data[i].TaPennKey].students += 1;
			} else {
				TAs[data[i].TaPennKey] = { 
										   time: new Date(data[i].ResolvedAt) - new Date(data[i].SeenAt),
										   students: 1 
										 };
			}
		}
		var pks = Object.keys(TAs);
		var series = [];
		for (var i = 0; i < pks.length; i++) {
			var TAobj = TAs[pks[i]];
			series.push(pks[i]);
			pks[i] = { x: pks[i], y: (TAobj.time / TAobj.students) / 60000 };
		}
		$scope.chartData.series = series;
		$scope.chartData.data   = pks;
	};


});
