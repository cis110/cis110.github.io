var globalvars = {
  "CGI": "https://fling.seas.upenn.edu/~cis110/cgi-bin/19fa", 
  "COURSE": "cis110", 
  "SEMESTER": "19fa", 
  "ADMIN": "https://fling.seas.upenn.edu/~cis110/19fa/admin", 
  "URL": "http://www.cis.upenn.edu/~cis110/19fa", 
  "FULL_COURSE": "CIS 110", 
  "SUBMIT": "https://fling.seas.upenn.edu/~cis110/19fa/admin/dashboard.html", 
  "FULL_TERM": "Fall 2019", 
  "RELURL": "/~cis110/19fa", 
  "PIAZZA": "http://piazza.com/upenn/fall2019/cis110"
};

var courseApp = angular.module('courseApp', [ 'ui.bootstrap' ]);

// Dirty rotten hack to force JSON to serialize dates in the local time zone
// Relies on the date formatting library pasted at the bottom of this script
Date.prototype.toJSON = function() {
  return this.format('isoDateTime');
};

courseApp.controller('courseController', function($scope) {
  $scope.isopen = true;
  // copy the global variables into the $scope if they are defined
  if (typeof globalvars != undefined) {
    for (key in globalvars) $scope[key] = globalvars[key];
  }
}).directive('cisHeader', function() {
  var headerurl = globalvars.RELURL + '/header.html';
  var footerurl = globalvars.RELURL + '/footer.html';
  return {
    restrict: 'A',
    transclude: true,
    template: '<header><div ng-include="\'' + headerurl + '\'"></div></header>' +
      '<div id="outer-content"><span id="inner-content" ng-transclude></span></div>' +
      '<footer><div ng-include="\'' + footerurl + '\'"</div></footer>'
  };
}).directive('cisEmail', function() {
  return {
    restrict: 'E',
    transclude: true,
    scope: { user: '@', dom: '@' },
    template: '<a ng-href="mailto:{{user}}@{{dom}}" ng-transclude></a>'
  };
}).directive('youtube', function() {
  return {
    restrict: 'EA',
    scope: { code:'@code' },
    template: '<div style="height:400px;"><iframe style="overflow:hidden;height:100%;width:100%" width="100%" height="100%" src="http://www.youtube.com/embed/{{code}}" frameborder="0" allowfullscreen></iframe></div>'
  };
}).directive('anew', function() {
  return {
    restrict: 'E',
    transclude: true,
    template: function (tElement, tAttrs) {
      console.log(tAttrs);

      var html = '<a target="_blank"';
      for (var key in tAttrs['$attr']) {
        console.log(key);
        console.log(JSON.stringify(tAttrs[key]));
        html += ' ' + tAttrs['$attr'][key] + '=' + JSON.stringify(tAttrs[key]);
      }
      html += '><span ng-transclude></span>&nbsp;<span class="glyphicon glyphicon-new-window"></span></a>';
      return html;
    }
  };
}).directive('announce', function() {
  return {
    restrict: 'E',
    transclude: true,
    template: function (tElement, tAttrs) {
      return '<table class="posts">' +
        '<tr><td class="date"><date><month>' + tAttrs['month'] +
        '</month><day>' + tAttrs['day'] + '</day></date></td>' +
        '<td><p class="post" ng-transclude></p></td></tr></table>';
    }
  };
});
