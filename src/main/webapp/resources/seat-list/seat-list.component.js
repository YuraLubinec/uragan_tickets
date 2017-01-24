angular.module('phoneList').component('phoneList', {
  templateUrl: 'seat-list/seat-list.template/html',
  controller: ['SeatListService', function SeatListController(SeatListService){
    var main = this;
    main.seatList = [];
    
    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
              main.seatList = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
  }]
});