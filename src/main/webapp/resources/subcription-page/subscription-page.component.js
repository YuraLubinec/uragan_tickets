angular.module('subscriptionPage').component('subscriptionPage', {
  templateUrl: 'template/subscriptions/',
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
      main.currentSelectSeason = null;
      main.currentSeason = null;

      main.submit = submit;
      main.edit = edit;
      main.remove = remove;
      main.reset = reset;
      main.seasonList = [];

      fetchAllSeasons();
      
      function fetchAllSubBySeasonId(id) {
        SubscriptionPageService.fetchAllSubBySeasonId(id)
          .then(
            function(d) {
              main.subscriptionList = d;
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

      function fetchAllSubscription() {

        SubscriptionPageService.fetchAllSubscription().then(function(d) {
          main.subscriptionList = d;
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
        appropriationSeason_Id();
        if (main.subscription.id === null) {
          createSubscription(main.subscription);
        } else {
          updateSubscription(main.subscription, main.subscription.id);
        }
        reset();
      }

      function edit(id) {
        for (var i = 0; i < main.subscriptionList.length; i++) {
          if (main.subscriptionList[i].id === id) {
            main.subscription = angular.copy(main.subscriptionList[i]);
            console.log(main.subscriptionList);
            break;
          }
        }
      }

      function remove(id) {
        console.log('id to be deleted', id);
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
        $scope.subForm.$setPristine(); // reset Form
      }
      
      function appropriationSeason_Id() {
        if (main.currentSelectSeason != null) {
          main.subscription.season_id = main.currentSelectSeason.id;
        }
      }
      
      $scope.getSubOfSeason = function() {
        if (main.currentSeason != null) {
          fetchAllSubBySeasonId(main.currentSeason.id);
        }
      }
      function getSubsAfterChange() {
        if (main.currentSeason != null) {
          fetchAllSubBySeasonId(main.currentSeason.id);
        }
      }
    }
  ]
});