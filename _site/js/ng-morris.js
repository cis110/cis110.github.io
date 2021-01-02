angular.module('ngMorris', [])
  .directive('areachart', function() {
    return {

      restrict: 'E',
      template: '<div></div>',
      replace: true,

      link: function ($scope, element, attrs){
        // console.log($scope);

        var data = $scope[attrs.data],
            xkey = $scope[attrs.xkey],
            ykeys= $scope[attrs.ykeys],
            labels= $scope[attrs.labels];

        Morris.Area({
            element: element,
            data: data,
            xkey: xkey,
            ykeys: ykeys,
            labels: labels
        });
      }
    };
  })

  .directive('donutchart', function() {
    return {

      restrict: 'E',
      template: '<div></div>',
      replace: true,

      link: function ($scope, element, attrs) {

        var data = $scope[attrs.data],
            xkey = $scope[attrs.xkey],
            ykeys= $scope[attrs.ykeys],
            labels= $scope[attrs.labels];

        Morris.Donut({
          element: element,
          data: data,
          resize: true
        });
      }
    };
  });