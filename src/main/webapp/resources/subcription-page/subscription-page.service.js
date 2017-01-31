angular.module('subscriptionPage').factory('SubscriptionPageService',['$http', '$q', function($http,$q){
  
	console.log('Service .....')
  var REST_SERVICE_URI = 'http://localhost:8080/uragan/main/subscription/';
  
  var factory = {
      fetchAllSubscription: fetchAllSubscription,
      createSubscription: createSubscription,
      updateSubscription: updateSubscription,
      deleteSubscription: deleteSubscription,
  };

  return factory;

  function fetchAllSubscription() {
	  console.log("fetchAllSubscription service 1");
      var deferred = $q.defer();
      console.log("fetchAllSubscription service 2");
      $http.get(REST_SERVICE_URI)
          .then(
          function (response) {
        	  console.log("fetchAllSubscription service 3");
              deferred.resolve(response.data);
              console.log("fetchAllSubscription service 4");
          },
          function(errResponse){

              deferred.reject(errResponse);
          }
      );
      return deferred.promise;
  }
  
  function createSubscription(subscription) {
	  console.log("SAVING SUB IN SERVICE" + subscription);
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
	  console.log("updateSubscription : " + id);
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
	  console.log('id to be deleted', id);
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