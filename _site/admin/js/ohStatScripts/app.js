'use strict';

var statsApp = angular.module('statsApp', [ 'ui.bootstrap', 'ngRoute', 'ngQuickDate', 'ngMorris', 'angularCharts' ]);

    
statsApp.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: '../admin/ohStatViews/ohstatsdashboard.html',
      controller: 'DashboardCtrl'
    })
    .when('/search', {
      templateUrl: '../admin/ohStatViews/search.html',
      controller: 'SearchCtrl'
    })
    .otherwise({
      redirectTo: '/'
    });
});
