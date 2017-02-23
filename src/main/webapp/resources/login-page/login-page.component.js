angular.module('loginPage').component('loginPage', {
  templateUrl : 'template/login',
  controller : [ 'LoginPageService', function LoginPageController(LoginPageService, $location, $rootScope) {
   var main = this;
   main.login = login;
   main.username = 'username';
   main.password = 'password';
    
    function login(){
      LoginPageService.login(main.username,main.password).then(function(){
        console.log('success');
      }, function(){
        console.error('error!');
      })
    }
  } ]
})