angular.module('gameList').component('gameList', {
  templateUrl: 'template/games/',
  controller: ['GameListService', function GameListController(GameListService){
    var main = this;
    main.gameList = [];
    
    fetchAllGames();

    function fetchAllGames(){
    	GameListService.fetchAllGames()
            .then(
            function(d) {
              main.gameList = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
  }]
});