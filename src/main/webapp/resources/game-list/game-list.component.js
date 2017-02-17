angular.module('gameList').component('gameList', {
    templateUrl: 'template/games/',
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

      main.dateGame = new Date();
      main.timeGame = new Date();
      main.minDate = new Date(
        this.dateGame.getFullYear(),
        this.dateGame.getMonth(),
        this.dateGame.getDate()
      );

      main.currentSelectSeason = null;
      main.currentSeason = null;
      main.seasonName = '';
      main.gameList = [];
      main.seasonList = [];

      main.submit = submit;
      main.edit = edit;
      main.remove = remove;
      main.reset = reset;

      main.paginList = [];

      $scope.currentPage = 1, $scope.numPerPage = 10, $scope.maxSize = 5;

      fetchAllSeasons();

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

      function fetchAllSeasons() {
        GameListService.fetchAllSeasons()
          .then(
            function(d) {
              main.seasonList = d;
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
        if (main.currentSelectSeason != null) {
          main.game.season_id = main.currentSelectSeason.id;
        }
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
      }

      $scope.getGamesOfSeason = function() {
        if (main.currentSeason != null) {
          fetchAllGamesBySeason(main.currentSeason.id);
        }
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
        var formatDate = date;
        formatDate = new Date(date.getFullYear(), date.getMonth(), date.getDate(), 1, 0, 0);
        return formatDate.toLocaleDateString()
      }

      function defoultFormateTime(date) {
        return date.getHours() + ":" + date.getMinutes();
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
    $mdDateLocaleProvider.months = ['Cічень', 'Лютий', 'Березень', 'Квітень', 'Траваень', 'Червень', 'Липень',
      'Серпень', 'Вересень', 'Жовтень', 'Листопад', 'Грудень'
    ];
    $mdDateLocaleProvider.shortMonths = ['січ', 'лют', 'бер', 'квіт', 'трав', 'черв', 'лип', 'серп', 'верес', 'жовт',
      'лист', 'груд'
    ];
    $mdDateLocaleProvider.days = ['неділя', 'понеділок', 'вівторок', 'середа', 'четвер', 'пятниця', 'субота'];
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