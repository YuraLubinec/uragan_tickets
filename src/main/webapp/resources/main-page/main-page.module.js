var mainPage = angular.module('mainPage', []);

mainPage.directive('sectorAsc', function() {  
  return {
    templateUrl : 'resources/static/sectorASC.html'
  };
});

mainPage.directive('sectorDesc', function() {  
  return {
    templateUrl : 'resources/static/sectorDESC.html'
  };
});
