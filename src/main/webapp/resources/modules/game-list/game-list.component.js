angular.module('gameList').component('gameList', {
    templateUrl: 'resources/static/templates/game-list.template.html',
    controller: ['$scope', 'GameListService', function GameListController($scope, GameListService) {
      var main = this;

      main.game = {
        id: null,
        firstTeam: '',
        secondTeam: '',
        date: '',
        time: '',
        season_id: '',
      }

      main.sectorCountTicket = {
        nameSector: '',
        countTickets: '',
        summ: '',
      }

      main.dateGame = new Date;
      main.timeGame = new Date();
      main.minDate = new Date(
        this.dateGame.getFullYear(),
        this.dateGame.getMonth(),
        this.dateGame.getDate()
      );

      main.currentSeason = null;
      main.seasonName = '';
      main.gameList = [];
      main.seasonList = [];

      main.tickets = [];
      main.seats = [];
      main.sectors = [];

      main.sectorsWithCountTickets = [];
      $scope.summByGame = 0;

      main.submit = submit;
      main.edit = edit;
      main.remove = remove;
      main.reset = reset;
      
      main.fetchTicketsByIdGame = fetchTicketsByIdGame;

      main.paginList = [];

      $scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 5;

      fetchAllSeasons();
      fetchAllSectors();

      function fetchAllGamesBySeason(id) {
        GameListService.fetchAllGamesBySeason(id)
          .then(
            function(d) {
              main.gameList = d;
              main.paginList = d;
            },
            function(errResponse) {}
          );
      }

      function fetchSeatsIdTicket(data) {
        GameListService.fetchSeatsIdTicket(data)
          .then(
            function(d) {
              main.seats = d;
              createSectorWithCountTickeet();
            },
            function(errResponse) {}
          );
      }

      function fetchTicketsByIdGame(id) {
        GameListService.fetchTicketsByIdGame(id)
          .then(
            function(d) {
              main.tickets = d;
              fetchSeatsIdTicket(main.tickets);
            },
            function(errResponse) {}
          );
      }

      function fetchAllSeasons() {
        GameListService.fetchAllSeasons()
          .then(
            function(d) {
              main.seasonList = d;
            },
            function(errResponse) {}
          );
      }

      function fetchAllSectors() {
        GameListService.fetchAllSectors()
          .then(
            function(d) {
              main.sectors = d;
            },
            function(errResponse) {}
          );
      }

      function createGame(game) {
        GameListService.createGame(game)
          .then(
            getGamesAfterChange,
            function(errResponse) {}
          );
      }

      function appropriation() {
        main.game.date = defoultFormateDate(main.dateGame);
        main.game.time = defoultFormateTime(main.timeGame);

      }

      function deleteGame(id) {
        GameListService.deleteGame(id)
          .then(
            getGamesAfterChange,
            function(errResponse) {}
          );
      }

      function updateGame(game, id) {
        GameListService.updateGame(game, id)
          .then(
            getGamesAfterChange,
            function(errResponse) {}
          );
      }

      function submit() {
        appropriation();
        if (main.game.id === null) {
          createGame(main.game);
        } else {
          updateGame(main.game, main.game.id);
        }
        angular.element('#myModal').modal('hide');
        reset();
      }

      function edit(id) {
        for (var i = 0; i < main.gameList.length; i++) {
          if (main.gameList[i].id === id) {
            main.game = angular.copy(main.gameList[i]);
            break;
          }
        }
        getDateGame(main.game.date);
        getTimeGame(main.game.date, main.game.time);
      }

      $scope.selectedSeason = function(idGame) {
        if (idGame == null) {
          return "Оберіть сезон"
        } else {
          for (var i = 0; i < main.gameList.length; i++) {
            if (main.gameList[i].id === id) {
              return getSeason(main.gameList[i].season_id);
              break;
            }
          }
        }
      }

      function getSeason(seasonId) {
        for (var i = 0; i < main.seasonList.length; i++) {
          if (main.seasonList[i].id === id) {
            return main.seasonList[i];
            break;
          }
        }
      }

      function getDateGame(dateGame) {
        var date = new Date(dateGame);
        main.dateGame = date;
      }

      function getTimeGame(dateGame, timeGame) {
        var date = new Date(dateGame);
        var time = timeGame.split(":");
        date.setHours(time[0], time[1]);
        main.timeGame = date;
      }

      $scope.getGamesOfSeason = function() {
        if (main.currentSeason != null) {
          fetchAllGamesBySeason(main.currentSeason.id);
        }
      }

      function createSectorWithCountTickeet() {
        main.sectorsWithCountTickets = [];
        $scope.summByGame = 0;
        for (var i = 0; i < main.sectors.length; i++) {
          var countTicket = 0;
          for (var j = 0; j < main.seats.length; j++) {
            if (main.seats[j].sector_id == main.sectors[i].id) {
              countTicket++;
            }
          }
          main.sectorCountTicket.nameSector = main.sectors[i].name;
          main.sectorCountTicket.countTickets = countTicket;
          main.sectorCountTicket.summ = countTicket * main.sectors[i].price;
          main.sectorsWithCountTickets.push(main.sectorCountTicket);

          $scope.summByGame += main.sectorCountTicket.summ
          main.sectorCountTicket = {
            nameSector: '',
            countTickets: '',
            summ: '',
          }
        }
      }

      $scope.getReportForGame = function(id) {
        main.tickets = [];
        main.seats = [];
        main.sectorsWithCountTickets = [];
        $scope.summByGame = 0;

        fetchTicketsByIdGame(id);
      }

      function getGamesAfterChange() {
        if (main.currentSeason != null) {
          fetchAllGamesBySeason(main.currentSeason.id);
        }
      }

      function remove(id) {
        if (main.game.id === id) {
          reset();
        }
        deleteGame(id);
      }

      function defoultFormateDate(date) {
        return moment(date).format("YYYY-MM-DD");
      }

      function defoultFormateTime(date) {
        if (date.getMinutes() < 10){
          return addZero(date.getHours()) + ":" + addZero(date.getMinutes());
        }else{
          return date.getHours() + ":" + date.getMinutes();
        }
      }

      function addZero(i) {
        if (i < 10) {
          i = "0" + i;
        }
        return i;
      }

      function reset() {
        main.game = {
          id: null,
          firstTeam: '',
          secondTeam: '',
          date: '',
          time: '',
          season_id: ''
        };

        main.dateGame = new Date();
        main.timeGame = new Date();

        $scope.myForm.$setPristine();
      }

      $scope.numPages = function() {
        return Math.ceil(main.gameList.length / $scope.numPerPage);
      };

      $scope.$watch('currentPage + numPerPage', function() {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage),
          end = begin + $scope.numPerPage;

        var dateTest = main.gameList.slice(begin, end);
        main.paginList = dateTest;
      });

    }]
  })
  .config(function($mdDateLocaleProvider) {
    // Ukrainian  localization.
    $mdDateLocaleProvider.months = ['Cічень', 'Лютий', 'Березень', 'Квітень', 'Траваень', 'Червень',
      'Липень',
      'Серпень', 'Вересень', 'Жовтень', 'Листопад', 'Грудень'
    ];
    $mdDateLocaleProvider.shortMonths = ['січ', 'лют', 'бер', 'квіт', 'трав', 'черв', 'лип', 'серп',
      'верес', 'жовт',
      'лист', 'груд'
    ];
    $mdDateLocaleProvider.days = ['неділя', 'понеділок', 'вівторок', 'середа', 'четвер', 'пятниця',
      'субота'
    ];
    $mdDateLocaleProvider.shortDays = ['Нд', 'Пн', 'Вів', 'Сер', 'Чет', 'Пн', 'Суб'];

    // Can change week display to start on Monday.
    $mdDateLocaleProvider.firstDayOfWeek = 1;

    $mdDateLocaleProvider.parseDate = function(dateString) {
      var m = moment(dateString, 'L', true);
      return m.isValid() ? m.toDate() : new Date(NaN);
    };

    $mdDateLocaleProvider.formatDate = function(date) {
      var m = moment(date);
      return m.isValid() ? m.format('L') : '';
    };

    $mdDateLocaleProvider.weekNumberFormatter = function(weekNumber) {
      return 'Тиждень ' + weekNumber;
    };

    $mdDateLocaleProvider.msgCalendar = 'Календар';
    $mdDateLocaleProvider.msgOpenCalendar = 'Відкритий календар';

  })
  .config(function($mdThemingProvider) {
    $mdThemingProvider.theme('default')
      .primaryPalette('grey')
      .accentPalette('orange');
  });