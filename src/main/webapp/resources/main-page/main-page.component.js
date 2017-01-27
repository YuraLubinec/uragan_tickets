angular.module('mainPage').component('mainPage', {
  templateUrl: 'template/main/',
  controller: ['MainPageService', function MainPageController(MainPageService) {
    var main = this;
    main.seatList = [];
    main.sector_name = "";
    main.seat_obj = null;
    main.ticket = {id:null,fullName:'',seat_id:'',game_id:''};
    main.submit = submit;
    
    fetchAllSectors();

    function fetchAllSectors() {
      MainPageService.fetchAllSectors()
        .then(
          function(d) {
            main.seatList = d;
          },
          function(errResponse) {
            console.error('Error while fetching Sectors');
          }
        );
    }

    function createTicket(ticket) {
      MainPageService.createTicket(ticket)
        .then(fetchAllSectors(),
          function(errResponse) {
            console.error('Error while saving ticket');
          });
    }

    function submit() {
      main.ticket.seat_id = main.seat_obj.id;
      main.ticket.game_id = 3;
      createTicket(main.ticket);
      main.ticket={id:null,fullName:'',seat_id:'',game_id:''};
      angular.element('#myModal').modal('hide');
    }

  }]
});