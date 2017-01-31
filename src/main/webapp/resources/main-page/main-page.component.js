angular.module('mainPage').component('mainPage', {
  templateUrl : 'template/main/',
  controller : [ 'MainPageService', function MainPageController(MainPageService) {
    var main = this;
    main.gameId = null;
    main.seatList = [];
    main.gameList = [];
    main.currentGame = null;
    main.seat_obj = null;
    main.ticket = {
      id : null,
      seat_id : null,
      game_id : null
    };
    main.submit = submit;
    main.pointAllOccupiedSeats = pointAllOccupiedSeats;
    main.classChecker = classChecker;

    fetchAllSectors();
    fetchAllGames();

    function fetchAllSectors() {
      MainPageService.fetchAllSectors().then(function(response) {
        main.seatList = response;
      }, function(errResponse) {
        console.error('Error while fetching Sectors');
      });
    }

    function fetchAllGames() {
      MainPageService.fetchAllGames().then(function(response) {
        main.gameList = response;
        pointAllOccupiedSeats();
      }, function(errResponse) {
        console.error('Error while fetching Games');
      });
    }

    function pointAllOccupiedSeats() {

      if (main.ticket.game_id != null) {
        refreshCurrentGameById();
      }
      if (main.currentGame != null) {
        angular.element('button').removeClass('buttonStyle');
        for (var i = 0; i < main.currentGame.tickets.length; i++) {
          var occupiedSeat = angular.element('#' + main.currentGame.tickets[i].seat_id);
          occupiedSeat.addClass('buttonStyle');
        }
      }
    }

    function createTicket(ticket) {
      MainPageService.createTicket(ticket).then(fetchAllGames, function(errResponse) {
        console.error('Error while saving ticket');
      });
    }

    function refreshCurrentGameById() {
      for (var i = 0; i < main.gameList.length; i++) {
        if (main.gameList[i].id === main.ticket.game_id) {
          main.currentGame = main.gameList[i];
        }
      }
      main.ticket = {
        id : null,
        seat_id : null,
        game_id : null
      };
    }
    
    function classChecker(){
      if(main.seat_obj != null){
        return angular.element('#' + main.seat_obj.id).hasClass('buttonStyle');
      }      
    }

    function submit() {
      main.ticket.seat_id = main.seat_obj.id;
      main.ticket.game_id = main.currentGame.id;
      createTicket(main.ticket);
      angular.element('#myModal').modal('hide');
    }

  } ]
});