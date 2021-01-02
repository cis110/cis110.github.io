'use strict';

angular.module('statsApp')
  .controller('DashboardCtrl', function ($scope, $http, $compile) {

  // figure out which semester this is based on the URL
  var sem = /~[^\/]*\/([^\/]*)\//.exec(window.location.href)[1];

  var cgi = '../../cgi-bin/' + sem + '/ohadmin.cgi';


//  $scope.refresh = function() {
//    $http.post(cgi, [ [ 'oh_queue_data'] ])
//        .success(function(data, status, headers, config) {
          // console.log(data);
          //console.log(config);
//	  console.log(data);
          //$scope.updateData(data);
//    });
    // console.log('refreshing');
 //   setTimeout($scope.refresh, 5000);
//  }

//  angular.element(document).ready(function() {
//       $scope.refresh();
//  });



  // Sample data
  $scope.areaData = [
    {period: '2010 Q1', iphone: 2666, ipad: null, itouch: 2647},
    {period: '2010 Q2', iphone: 2778, ipad: 2294, itouch: 2441},
    {period: '2010 Q3', iphone: 4912, ipad: 1969, itouch: 2501},
    {period: '2010 Q4', iphone: 3767, ipad: 3597, itouch: 5689},
    {period: '2011 Q1', iphone: 6810, ipad: 1914, itouch: 2293},
    {period: '2011 Q2', iphone: 5670, ipad: 4293, itouch: 1881},
    {period: '2011 Q3', iphone: 4820, ipad: 3795, itouch: 1588},
    {period: '2011 Q4', iphone: 15073, ipad: 5967, itouch: 5175},
    {period: '2012 Q1', iphone: 10687, ipad: 4460, itouch: 2028},
    {period: '2012 Q2', iphone: 8432, ipad: 5713, itouch: 1791}
  ];

  $scope.areaXkey =  'period';
  $scope.areaYkeys = ['iphone', 'ipad', 'itouch'];
  $scope.areaLabels = ['iPhone', 'iPad', 'iPod Touch'];

  $scope.donutData = [
    {
      label: "Queue 1",
      value: 12
    }, {
      label: "Queue 2",
      value: 30
    }, {
      label: "Queue 3",
      value: 20
  }];
});
