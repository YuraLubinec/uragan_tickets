'use strict'
angular.module('navbar').component('navbar', {
  templateUrl: 'template/navbar',
  controller: ['NavbarService','$rootScope', function NavbarController(NavbarService,$rootScope){
    var main = this;
    $rootScope.access=null;
    this.userLogout = userLogout;
    checkAuthority();

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
  }]
});