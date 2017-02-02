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
      season_id : '',
    }   
    main.currentSeason = null;
    
    main.gameList = [];  
    main.seasonList = [];

    main.submit = submit;
    main.edit = edit;
    main.remove = remove;
    main.reset = reset;
    
    
    fetchAllGames();
    fetchAllSeasons();
    
    
    function fetchAllSeasons() {
      GameListService.fetchAllSeasons()
        .then(
          function(d) {
            main.seasonList = d;
          },
          function(errResponse) {}
        );
    }
    function fetchAllGames() {
      GameListService.fetchAllGames()
        .then(
          function(d) {
            main.gameList = d;
          },
          function(errResponse) {}
        );
    }

    function createGame(game) {
      GameListService.createGame(game)
        .then(
          fetchAllGames,
          function(errResponse) {}
        );
    }
    
    function appropriationSeason_Id(){
      if(main.currentSeason != null){
        main.game.season_id = main.currentSeason.id;
      }
    }

    function deleteGame(id) {
      console.log("delete game : " + id);
      GameListService.deleteGame(id)
        .then(
          fetchAllGames,
          function(errResponse) {
          }
        );
    }

    function updateGame(game, id) {
      GameListService.updateGame(game, id)
        .then(
          fetchAllGames,
          function(errResponse) {}
        );
    }

    function submit() {
      appropriationSeason_Id();
      if (main.game.id === null) {
        createGame(main.game)
      } else {
        updateGame(main.game, main.game.id);
        
      }
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
  }]
});