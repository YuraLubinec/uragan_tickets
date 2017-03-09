var mainPage = angular.module('mainPage', []);

mainPage.directive('sectorAsc', function() {  
  return {
    templateUrl : 'resources/static/directives.templates/sectorASC.html'
  };
});

mainPage.directive('sectorDesc', function() {  
  return {
    templateUrl : 'resources/static/directives.templates/sectorDESC.html'
  };
});
