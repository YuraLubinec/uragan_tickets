angular.module('loginPage').component('loginPage', {
  templateUrl : 'resources/static/templates/login-page.template.html',
  controller : [ 'LoginPageService', '$rootScope', function LoginPageController(LoginPageService, $rootScope) {
    var main = this;
    main.login = login;
    main.authenticationError = false;
    main.username = null;
    main.password = null;

    function login() {
      LoginPageService.login(main.username, main.password).then(function() {
        $rootScope.access = true;
        main.authenticationError = false;
      }, function() {
        main.authenticationError = true;
      })
    }

  } ]
});