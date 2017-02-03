//angular.module('loginPage').component('loginPage', {
//  templateUrl : 'template/login',
//  controller : [ 'LoginPageService', function LoginPageController(LoginPageService, $location, $rootScope) {
//    var main = this;
//    main.credentials = {};
//    main.login = login;
//
//    var authenticate = function(credentials, callback) {
//
//      var headers = credentials ? {
//        authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
//      } : {};
//
//      LoginPageService.fetchSingleUser(headers).then(function(response) {
//        if (response.data.name) {
//          $rootScope.authenticated = true;
//        } else {
//          $rootScope.authenticated = false;
//        }
//        callback && callback();
//      }, function() {
//        $rootScope.authenticated = false;
//        callback && callback();
//      });
//    };
//
//    authenticate();
//    function login() {
//      authenticate(self.credentials, function() {
//        if ($rootScope.authenticated) {
//          $location.path("/");
//          self.error = false;
//        } else {
//          $location.path("/login");
//          self.error = true;
//        }
//      });
//    }
//    ;
//
//  } ]
//})