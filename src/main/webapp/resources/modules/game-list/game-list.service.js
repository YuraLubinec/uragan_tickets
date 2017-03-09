  angular.module('gameList').factory('GameListService', ['$http', '$q', function($http, $q) {

  var REST_SERVICE_URI = 'main/game/';

  var factory = {

    
    fetchSeatsIdTicket:    fetchSeatsIdTicket,
    fetchTicketsByIdGame:  fetchTicketsByIdGame,
    fetchAllSeasons:       fetchAllSeasons,
    fetchAllSectors: fetchAllSectors,
    fetchAllGamesBySeason: fetchAllGamesBySeason,
    createGame:            createGame,
    updateGame:            updateGame,
    deleteGame:            deleteGame,
  };

  return factory;

  
  
  
  function fetchSeatsIdTicket(arr) {
    var deferred = $q.defer();
    $http({
      method: 'POST',
      url: REST_SERVICE_URI + "getSeatsIdTicket",
      data: arr }).then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {

          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

  function fetchTicketsByIdGame(id) {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "ticketsGame/" + id)
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {

          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }
  
  function fetchAllGamesBySeason(id) {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "seasonGames/" + id)
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {

          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

  function fetchAllSeasons() {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "season")
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {

          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }
  
  function fetchAllSectors() {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "sectors")
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {

          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

  function fetchAllGames() {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI)
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {

          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

  function createGame(game) {
    var deferred = $q.defer();
    $http.post(REST_SERVICE_URI, game)
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {
          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

  function updateGame(game, id) {
    var deferred = $q.defer();
    $http.put(REST_SERVICE_URI + id, game)
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {
          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

  function deleteGame(id) {
    var deferred = $q.defer();
    $http.delete(REST_SERVICE_URI + id)
      .then(
        function(response) {
          deferred.resolve(response.data);
        },
        function(errResponse) {
          deferred.reject(errResponse);
        }
      );
    return deferred.promise;
  }

}]);