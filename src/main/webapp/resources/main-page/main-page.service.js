angular.module('mainPage').factory('MainPageService', [ '$http', '$q', function($http, $q) {

  var REST_SERVICE_URI = 'main';

  var factory = {
    fetchAllSectors : fetchAllSectors,
    createTicket : createTicket,
    fetchAllGames : fetchAllGames,
    getGameById : getGameById
  };

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

  function createTicket(ticket) {
    var deferred = $q.defer();
    $http.post(REST_SERVICE_URI, ticket).then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      console.error('Error while saving ticket');
      deferred.reject(errResponse);
    });
    return deferred.promise;
  }

  function fetchAllGames() {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "/games").then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      console.error('Error while fetching games');
      deferred.reject(errResponse);
    });
    return deferred.promise;       
  }
  
  function getGameById(id){
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "/current/"+id).then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      console.error('Error while fetching games');
      deferred.reject(errResponse);
    });
    return deferred.promise;
    
  }

} ]);