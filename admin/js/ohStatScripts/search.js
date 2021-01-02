'use strict';

angular.module('statsApp')
  .controller('SearchCtrl', function ($scope, $http, $compile) {

    var cgi = '../../cgi-bin/15fa/ohadmin.cgi';

    $scope.ohData = [];
    $scope.chartData = {};
    $scope.queryPennkey   = null;
    $scope.queryStart     = null;
    $scope.queryEnd       = null;
    $scope.queryTAPennkey = null;
    $scope.chartType = 'line';
    $scope.chartConfig = {
	  title: 'Average Help Time',
	  tooltips: false,
	  labels: false,
	  legend: {
	    display: true,
	    //could be 'left, right'
	    position: 'left'
	  },
	  innerRadius: 0, // applicable on pieCharts, can be a percentage like '50%'
	  lineLegend: 'lineEnd' // can be also 'traditional'
	}
   
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

 //   $scope.getData = function() {
 //     var start = ($scope.queryStart !== null) ? toSQLDate($scope.queryStart) : null;
 //     var end = ($scope.queryEnd !== null) ? toSQLDate($scope.queryEnd) : null;
        
 //     $http.post(cgi, [ [ 'oh_data', { pennkey: $scope.queryPennkey, ta: $scope.queryTAPennkey, start: start, end: end } ] ])
 //       .success(function(data, status, headers, config) {
 //           console.log(data);
 //           $scope.updateData(data);
             
  //      });
  //  };

    $scope.getChartData = function() {
      var start = ($scope.queryStart !== null) ? toSQLDate($scope.queryStart) : null;
      var end = ($scope.queryEnd !== null) ? toSQLDate($scope.queryEnd) : null;
      console.log(start)
      $http.post(cgi, [ [ 'oh_data', { ta: $scope.queryTAPennkey, start: start, end: end } ] ])
        .success(function(data, status, headers, config) {
            console.log(data);
            //$scope.averageHelpTime(data['ohData']);
        });
    };

    $scope.averageHelpTime = function(data) {
      var TAs = {};
      for (var i = 0; i < data.length; i++) {
        if (Object.keys(TAs).indexOf(data[i].HelpedBy) != -1) {
          TAs[data[i].HelpedBy].time += (new Date(data[i].ResolvedAt) - new Date(data[i].HelpedAt));
          TAs[data[i].HelpedBy].students += 1;
        } else {
          TAs[data[i].HelpedBy] = { 
                         time: new Date(data[i].ResolvedAt) - new Date(data[i].HelpedAt),
                         students: 1 
                       };
        }
      }
      console.log(TAs);
      var pks = Object.keys(TAs);
      var series = [];
      for (var i = 0; i < pks.length; i++) {
        var TAobj = TAs[pks[i]];
        series.push(pks[i]);
        pks[i] = { "x": pks[i], "y": [(TAobj.time / TAobj.students) / 60000] };
      }

      console.log(series);
      console.log(pks);

      $scope.chartData.series = series;
      $scope.chartData.data   = pks;
    };
  });
