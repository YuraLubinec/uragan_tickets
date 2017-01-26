angular.module('ticketApp').config(
    [ '$locationProvider', '$routeProvider',
        function config($locationProvider, $routeProvider) {
          $locationProvider.hashPrefix('!');

          $routeProvider.when('/', {
            template : '<main-page></main-page>'
          }).when('/game', {
            template : '<game-list></game-list>'
          }).when('/subscription', {
            template : '<subsription-list></subsription-list>'
          }).when('/sector', {
            template : '<sector-list></sector-list>'
          }).otherwise('/');


        } ]);