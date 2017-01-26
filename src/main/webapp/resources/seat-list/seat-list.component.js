angular.module('seatList').component('seatList', {
  templateUrl: 'template/seats/',
  controller: ['SeatListService', function SeatListController(SeatListService){
    var main = this;
    main.seatList = [];
    
    fetchAllSectors();

    function  fetchAllSectors(){
      SeatListService.fetchAllSectors()
            .then(
            function(d) {
              main.seatList = d;
              for (var i = 0; i < d.length; i++){
                console.log(d[i].name);
                var seatsArr = [];
                seatsArr = d[i].seats;
                for(var j = 0; j < seatsArr.length; j++){
                  console.log(' id= '+seatsArr[j].id+' place= '+seatsArr[j].place+' row= '+seatsArr[j].row);
                } 
              }
              
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
  }]
});