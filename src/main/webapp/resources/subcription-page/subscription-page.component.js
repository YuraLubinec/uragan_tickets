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

      main.submit = submit;
      main.edit = edit;
      main.remove = remove;
      main.reset = reset;

      fetchAllSubscription();

      function fetchAllSubscription() {
        console.log("Controller ........");
        SubscriptionPageService.fetchAllSubscription().then(function(d) {
          console.log("Controller 1 ........");
          main.subscriptionList = d;
          console.log("Controller 2 ........");
        }, function(errResponse) {});
      }

      function createSubscription(subscription) {
        console.log("create in controller" + subscription)

        SubscriptionPageService.createSubscription(subscription).then(
          fetchAllSubscription,
          function(errResponse) {});
      }

      function deleteSubscription(id) {
        console.log(" in deleteSubscription ");
        SubscriptionPageService.deleteSubscription(id).then(
          fetchAllSubscription,
          function(errResponse) {
            console.error('Error while deleting Sub');
          });
      }

      function updateSubscription(subscription, id) {
        console.log("updateSubscription " + id);
        SubscriptionPageService.updateSubscription(subscription, id).then(
          fetchAllSubscription,
          function(errResponse) {});
      }

      function submit() {
        console.log("submit ............");
        if (main.subscription.id === null) {
          console.log('Saving New Sub', main.subscription);
          createSubscription(main.subscription);
        } else {
          console.log('updating SUB', main.subscription);
          updateSubscription(main.subscription, main.subscription.id);
        }
        reset();
      }

      function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < main.subscriptionList.length; i++) {
          if (main.subscriptionList[i].id === id) {
            console.log("Length: " + main.subscriptionList.length);
            main.subscription = angular.copy(main.subscriptionList[i]);
            console.log(main.subscriptionList);
            break;
          }
          console.log("after edit in loop")
        }
        console.log("after edit")
      }

      function remove(id) {
        console.log('id to be deleted', id);
        if (main.subscription.id === id) { // clean form if the user to be
          // deleted is shown there.
          console.log("before reset : " + id);
          reset();
          console.log("after reset : " + id);
        }
        console.log(" deleteSubscription(id);");
        deleteSubscription(id);
        console.log(" after deleteSubscription(id);");
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

    }
  ]
});