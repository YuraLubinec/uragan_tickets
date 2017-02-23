angular.module('loginPage').factory('LoginPageService', [ '$http', '$q', function($http, $q) {
  var REST_SERVICE_URI = '';

  var factory = {

    login : login

  };
  return factory;
  
  function login(username, password){
    var deferred = $q.defer();
    var data = {
        params: {
          username : username,
          password : password
        }
    }     
    $http.post('loginCheck','',data).then(function(response) {
      deferred.resolve(response.data);
    }, function(errResponse) {
      console.error('Error');
      deferred.reject(errResponse);
    });
    return deferred.promise;
  };
  
 
} ])