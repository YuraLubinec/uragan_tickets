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

    function appropriationSeason_Id() {
      if (main.currentSelectSeason != null) {
        main.game.season_id = main.currentSelectSeason.id;
      }
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
      appropriationSeason_Id();
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

    function reset() {
      main.game = {
        id: null,
        firstTeam: '',
        secondTeam: '',
        date: '',
        time: '',
        season_id: ''
      };
      $scope.myForm.$setPristine();
    }

    $scope.numPages = function() {
      return Math.ceil(main.gameList.length / $scope.numPerPage);
    };

    $scope.$watch('currentPage + numPerPage', function() {
      var begin = (($scope.currentPage - 1) * $scope.numPerPage),
        end = begin + $scope.numPerPage;

      main.paginList = main.gameList.slice(begin, end);
    });

  }]
});