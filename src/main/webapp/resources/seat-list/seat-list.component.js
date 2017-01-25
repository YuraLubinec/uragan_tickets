angular.module('seatList').component('seatList', {
  templateUrl: 'template/seats/',
  controller: ['SeatListService', function SeatListController(SeatListService){
    var main = this;
    main.seatList = [];
    
    fetchAllUsers();

    function fetchAllUsers(){
      SeatListService.fetchAllUsers()
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