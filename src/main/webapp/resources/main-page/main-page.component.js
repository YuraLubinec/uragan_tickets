angular.module('mainPage').component('mainPage', {
  templateUrl: 'template/main/',
  controller: ['MainPageService', function MainPageController(MainPageService){
    var main = this;
    main.seatList = [];
    
    fetchAllSectors();

    function  fetchAllSectors(){
      MainPageService.fetchAllSectors()
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