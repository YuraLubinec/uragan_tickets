angular.module('loginPage').factory('LoginPageService', [ '$http', '$q', function($http, $q) {

  var factory = {
    login : login,
  };
  return factory;

  function login(username, password) {
    var deferred = $q.defer();
    $http({
      method : 'POST',
      url : 'loginCheck',
      headers : {
        'Content-Type' : 'application/x-www-form-urlencoded'
      },
      data : 'username=' + username + '&password=' + password,
    }).then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      deferred.reject(errResponse);
    });
    return deferred.promise;
  };

} ])