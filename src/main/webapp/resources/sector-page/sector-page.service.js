angular.module('sectorPage').factory('SectorPageService', [ '$http', '$q', function($http, $q) {
  
  var REST_SERVICE_URI = 'main/sectors';
  factory = {
      
      fetchAllSectors : fetchAllSectors,
      setPrice : setPrice
      
  }
   return factory;
  
  function fetchAllSectors() {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI).then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      console.error('Error while fetching Seats');
      deferred.reject(errResponse);
    });
    return deferred.promise;
  }
  
  function setPrice(sector){
    var deferred = $q.defer();
    $http.post(REST_SERVICE_URI+"/price", sector).then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      console.error('Error while saving Sector');
      deferred.reject(errResponse);
    });
    return deferred.promise;
    
  }

}]);
