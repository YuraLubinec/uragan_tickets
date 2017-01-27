angular.module('mainPage').factory('MainPageService',['$http', '$q', function($http,$q){
  
  var REST_SERVICE_URI = 'http://localhost:8080/uragan/main/';
  
  var factory = {
      fetchAllSectors:  fetchAllSectors
  };

  return factory;

  function fetchAllSectors() {
      var deferred = $q.defer();
      $http.get(REST_SERVICE_URI)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              console.error('Error while fetching Seats');
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
  
}]);