angular.module('loginPage').component('loginPage', {
  templateUrl: 'template/login',
  controller: ['LoginPageService', function LoginPageController(LoginPageService){
    var main = this;
    main.credentials = {
        username : null,
        password : null,
    };
    main.login =  function () {
      
    };
  }]
})