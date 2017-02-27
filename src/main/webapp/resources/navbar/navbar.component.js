'use strict'
angular.module('navbar').component('navbar', {
  templateUrl : 'template/navbar',
  controller : [ 'NavbarService', '$rootScope', '$interval', function NavbarController(NavbarService, $rootScope, $interval) {
    var main = this;
    $rootScope.access = null;
    this.userLogout = userLogout;
    this.checkAuthority = checkAuthority;
    checkAuthority();

    $interval(function() {
      if ($rootScope.access) {
        checkAuthority();
      }
    }, 1810000);

    function checkAuthority() {
      NavbarService.checkAuthority().then(function(response) {
        $rootScope.access = true;
      }, function() {
        $rootScope.access = false;
        console.log('Authentication is needed!');
      })
    }

    function userLogout() {
      NavbarService.userLogout().then(function() {
        $rootScope.access = false;
      }, function() {
        console.error('error in logout');
      })
    }
  } ]
});