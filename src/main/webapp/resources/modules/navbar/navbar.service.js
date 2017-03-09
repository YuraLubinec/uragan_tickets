'use strict'
angular.module('navbar').factory('NavbarService', [ '$http', '$q', function($http, $q) {

  return {
    checkAuthority : checkAuthority,
    userLogout : userLogout
  };

  function checkAuthority() {
    var deferred = $q.defer();
    $http.get('authenticated').then(function(response) {
      deferred.resolve(response.data);
    }, function(error) {
      deferred.reject(error.data);
    });
    return deferred.promise;
  }
  
  function userLogout() {
    var deferred = $q.defer();
    $http.post('logout').then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      deferred.reject(errResponse);
    });
    return deferred.promise;  
  };

} ]);