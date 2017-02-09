angular.module('subscriptionPage').factory('SubscriptionPageService',['$http', '$q', function($http,$q){
  var REST_SERVICE_URI = 'http://localhost:8080/uragan/main/subscription/';
  
  var factory = {
      fetchAllSubBySeasonId : fetchAllSubBySeasonId,
      fetchAllSubscription: fetchAllSubscription,
      fetchAllSeasons: fetchAllSeasons,
      createSubscription: createSubscription,
      updateSubscription: updateSubscription,
      deleteSubscription: deleteSubscription,
  };

  return factory;
 
  function fetchAllSubBySeasonId(id) {
    var deferred = $q.defer();
    $http.get(REST_SERVICE_URI + "seasonSub/" + id)
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

  function fetchAllSubscription() {
      var deferred = $q.defer();
      $http.get(REST_SERVICE_URI)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){

              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
  
  function createSubscription(subscription) {
      var deferred = $q.defer();
      $http.post(REST_SERVICE_URI, subscription)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
  
  function updateSubscription(subscription, id) {
      var deferred = $q.defer();
      $http.put(REST_SERVICE_URI+id, subscription)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
  
  function deleteSubscription(id) {
      var deferred = $q.defer();
      $http.delete(REST_SERVICE_URI+id)
          .then(
          function (response) {
              deferred.resolve(response.data);
          },
          function(errResponse){
              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
  
}]);