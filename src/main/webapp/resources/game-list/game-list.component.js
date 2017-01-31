angular.module('gameList').component('gameList', {
  templateUrl: 'template/games/',
  controller: ['$scope','GameListService', function GameListController($scope,GameListService){
    var main = this;
    main.game = {id:null,firstTeam:'',secondTeam:'',date:'',time:'', season_id:''}
    main.gameList = [];
    
    main.submit = submit;
    main.edit = edit;
    main.remove = remove;
    main.reset = reset;
    
    fetchAllGames();

    function fetchAllGames(){
    	GameListService.fetchAllGames()
            .then(
            function(d) {
              main.gameList = d;
            },
            function(errResponse){
            }
        );
    }
    function createGame(game){
    	GameListService.createGame(game)
            .then(
            fetchAllGames,
            function(errResponse){
            }
        );
    }
    
    function deleteGame(id){
    	GameListService.deleteGame(id)
            .then(
            fetchAllGames,
            function(errResponse){
                console.error('Error while deleting Game');
            }
        );
    }
    
    function updateGame(game, id){
    	console.log("GameListService.updateGame");
    	GameListService.updateGame(game, id)
            .then(
            fetchAllGames,
            function(errResponse){
            }
        );
    }
    
    function submit() {
        if(main.game.id===null){
            console.log('Saving New Game', main.game);
            createGame(main.game);
        }else{
        	console.log('updating game', main.game);
            updateGame(main.game, main.game.id);
        }
        reset();
    }
    
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < main.gameList.length; i++){
            if(main.gameList[i].id === id) {
            	main.game = angular.copy(main.gameList[i]);
                break;
            }
        }
        console.log("after edit")
    }
    
    function remove(id){
        console.log('id to be deleted', id);
        if(main.game.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteGame(id);
    }
    
    function reset(){
        main.game={id:null,firstTeam:'',secondTeam:'',date:'',time:'', season_id:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
  }]
});