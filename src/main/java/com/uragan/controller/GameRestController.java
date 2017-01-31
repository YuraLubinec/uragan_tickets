package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.uragan.model.Game;
import com.uragan.sevice.GameService;

@RestController
public class GameRestController {

  @Autowired
  GameService gameService;

  @GetMapping("/main/game")
  // -------------Retrieve All Games--------
  public ResponseEntity<List<Game>> listAllSeats() {
    List<Game> games = gameService.findAllGames();
    if (games.isEmpty()) {
      return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
  }

  // ------Retrieve Single User--------------------------
  @GetMapping(value = "/main/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Game> getGame(@PathVariable("id") int id) {
    System.out.println("Fetching Game with id " + id);
    Game game = gameService.findById(id);
    if (game == null) {
      System.out.println("User with id " + id + " not found");
      return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Game>(game, HttpStatus.OK);
  }

  // --Create a User-----------
  @PostMapping("/main/game")
  public ResponseEntity<Void> createGame(@RequestBody Game game, UriComponentsBuilder ucBuilder) {
    gameService.save(game);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/game/{id}").buildAndExpand(game.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  // --Delete a User-----------
  @DeleteMapping("/main/game/{id}")
  public ResponseEntity<Game> deleteUser(@PathVariable("id") int id) {
    System.out.println("Fetching & Deleting Game with id " + id);
    Game game = gameService.findById(id);
    if (game == null) {
      System.out.println("Unable to delete. User with id " + id + " not found");
      return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
    }
    gameService.delete(id);
    return new ResponseEntity<Game>(HttpStatus.NO_CONTENT);
  }

  // ------------------- Update a User----------------------------------

  @PutMapping("/main/game/{id}")
  public ResponseEntity<Game> updateGame(@PathVariable("id") int id, @RequestBody Game game) {
    System.out.println("Updating Game " + id);

    Game currentGame = gameService.findById(id);

    if (currentGame == null) {
      System.out.println("User with id " + id + " not found");
      return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
    }
    gameService.update(game);
    return new ResponseEntity<Game>(game, HttpStatus.OK);
  }

}
