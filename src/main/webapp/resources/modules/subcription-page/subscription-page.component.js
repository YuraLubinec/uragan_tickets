angular.module('subscriptionPage').component('subscriptionPage', {
  templateUrl: 'resources/static/templates/subscription-page.template.html',
  controller: [
    '$scope',
    'SubscriptionPageService',
    function SubscriptionPageController($scope, SubscriptionPageService) {
      var main = this;
      main.subscription = {
        id: null,
        fullName: '',
        seat_id: '',
        season_id: ''
      };
      main.subscriptionList = [];

      main.subscriptionALLList = [];
      main.seasonList = [];
      main.sectorList = [];
      main.seatList = [];
      main.seatListBySector = [];
      main.placeList = [];

      main.paginList = [];

      main.currentSelectSector = null;
      main.currentSelectRow = null;
      main.currentSelectPlace = null;

      main.currentSeason = null;

      main.submit = submit;
      main.edit = edit;
      main.remove = remove;
      main.reset = reset;

      $scope.propertyName = 'place';
      $scope.reverse = true;
      
      $scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 5;

      
      fetchAllSubscription();
      fetchAllSeasons();
      fetchAllSectors();
      fetchAllSeats();

      function fetchAllSubBySeasonId(id) {
        SubscriptionPageService.fetchAllSubBySeasonId(id)
          .then(
            function(d) {
              main.subscriptionList = d;
              main.paginList = d;
            },
            function(errResponse) {}
          );
      }

      function fetchAllSeasons() {
        SubscriptionPageService.fetchAllSeasons()
          .then(
            function(d) {
              main.seasonList = d;
            },
            function(errResponse) {}
          );
      }

      function fetchAllSectors() {
        SubscriptionPageService.fetchAllSectors()
          .then(
            function(d) {
              main.sectorList = d;
            },
            function(errResponse) {}
          );
      }

      function fetchAllSeats() {
        SubscriptionPageService.fetchAllSeats()
          .then(
            function(d) {
              main.seatList = d;
            },
            function(errResponse) {}
          );
      }

      function fetchAllSubscription() {
        SubscriptionPageService.fetchAllSubscription().then(function(d) {
          main.subscriptionALLList = d;
        }, function(errResponse) {});
      }

      function createSubscription(subscription) {
        SubscriptionPageService.createSubscription(subscription).then(
          getSubsAfterChange,
          function(errResponse) {});
      }

      function deleteSubscription(id) {
        SubscriptionPageService.deleteSubscription(id).then(
          getSubsAfterChange,
          function(errResponse) {
            console.error('Error while deleting Sub');
          });
      }

      function updateSubscription(subscription, id) {
        SubscriptionPageService.updateSubscription(subscription, id).then(
          getSubsAfterChange,
          function(errResponse) {});
      }

      function submit() {
        appropriationId();
        if (main.subscription.id === null) {
          createSubscription(main.subscription);
        } else {
          updateSubscription(main.subscription, main.subscription.id);
        }
        angular.element('#myModal').modal('hide');
        reset();
      }

      function edit(id) {
        for (var i = 0; i < main.subscriptionList.length; i++) {
          if (main.subscriptionList[i].id === id) {
            main.subscription = angular.copy(main.subscriptionList[i]);
            break;
          }
        }
      }

      function remove(id) {
        if (main.subscription.id === id) {
          reset();
        }
        deleteSubscription(id);
      }

      function reset() {
        main.subscription = {
          id: null,
          fullName: '',
          seat_id: '',
          season_id: ''
        };
        main.currentSelectSector = null;
        main.currentSelectRow = null;
        main.currentSelectPlace = null;

        $scope.subForm.$setPristine();
      }

      function appropriationId(){
          main.subscription.seat_id = main.currentSelectPlace.id;
      }

      $scope.getSubOfSeason = function() {
        if (main.currentSeason != null) {
          fetchAllSubBySeasonId(main.currentSeason.id);
        }
      }

      $scope.getRowBySector = function() {
        main.seatListBySector = [];
        if (main.currentSelectSector != null && main.seatList.length != 0) {
          main.seatListBySector = [];
          for (var i = 0; i < main.seatList.length; i++) {
            if (main.currentSelectSector.id === main.seatList[i].sector_id) {
              var row = main.seatList[i].row;
              var equalRow = 0;
              if (main.seatListBySector.length != 0) {
                for (var j = 0; j < main.seatListBySector.length; j++) {
                  if (main.seatListBySector[j].row == row) {
                    equalRow++;
                  }
                }
              }
              if (equalRow == 0) main.seatListBySector.push(main.seatList[i]);
            }
          }
        }
      }

      $scope.getAvailablePlace = function() {
        main.placeList = [];
        for (var i = 0; i < main.seatList.length; i++) {
          if (main.seatList[i].sector_id == main.subscription.season_id && main.seatList[i].row === main.currentSelectRow
            .row) {
            var isHaveId = 0;
            for (var j = 0; j < main.subscriptionALLList.length; j++) {
              if (main.subscriptionALLList[j].season_id === main.subscription.season_id) {
                if (main.subscriptionALLList[j].seat_id === main.seatList[i].id) {
                  isHaveId++;
                }
              }
            }
            if (isHaveId == 0) main.placeList.push(main.seatList[i]);
          }
        }
      }

      function getSubsAfterChange() {
        if (main.currentSeason != null) {
          fetchAllSubBySeasonId(main.currentSeason.id);
          fetchAllSubscription();
        }
      }

      $scope.numPages = function() {
        return Math.ceil(main.subscriptionList.length / $scope.numPerPage);
      };

      $scope.$watch('currentPage + numPerPage', function() {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage),
          end = begin + $scope.numPerPage;

        main.paginList = main.subscriptionList.slice(begin, end);
      });
      
      $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
      };
    }
  ]
});