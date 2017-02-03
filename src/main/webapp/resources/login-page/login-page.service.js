//angular.module('loginPage').factory('LoginPageService', [ '$http', '$q', function($http, $q) {
//  var REST_SERVICE_URI = 'user';
//
//  var factory = {
//      
//      fetchSingleUser : fetchSingleUser
//
//  };
//
//  function fetchSingleUser(headers) {
//    var deferred = $q.defer();
//    $http.get(REST_SERVICE_URI, {
//      headers : headers
//    }).then(function(response) {
//      deferred.resolve(response.data);
//    }, function(errResponse) {
//      console.error('Error while saving ticket');
//      deferred.resolve(errResponse)
//    });
//    return deferred.promise;
//  }
//
//
//  return factory;
//} ])