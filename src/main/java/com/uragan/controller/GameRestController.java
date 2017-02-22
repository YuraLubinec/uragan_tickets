package com.uragan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.model.Game;
import com.uragan.model.Season;
import com.uragan.sevice.GameService;
import com.uragan.sevice.SeasonService;
import com.uragan.sevice.SubscriptionService;
import com.uragan.sevice.TicketService;

@RestController
public class GameRestController {

  @Autowired
  GameService gameService;
  @Autowired
  SeasonService seasonService;
  @Autowired
  SubscriptionService subscriptionService;
  @Autowired
  TicketService ticketService;

  @GetMapping("/main/game")
  public ResponseEntity<List<Game>> listAllGames() {
    List<Game> games = gameService.findAllGames();
    if (games.isEmpty()) {

      return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
  }

  @GetMapping("/main/game/season")
  public ResponseEntity<List<Season>> listAllSeasons() {
    List<Season> seasons = seasonService.findAllSeason();

    if (seasons.isEmpty()) {

      return new ResponseEntity<List<Season>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Season>>(seasons, HttpStatus.OK);
  }

  @GetMapping("/main/game/seasonGames/{id}")
  public ResponseEntity<List<Game>> listAllGamesBySeasonId(@PathVariable("id") int id) {

    List<Game> games = gameService.findGamesBySeasonId(id);

    if (games.isEmpty()) {

      return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
  }

  @PostMapping("/main/game")
  public ResponseEntity<Game> createGame(@Valid @RequestBody Game game, BindingResult bindingResults) {
    if (bindingResults.hasErrors()) {
      return new ResponseEntity<Game>(game, HttpStatus.BAD_REQUEST);
    } else {
      gameService.save(game);
      return new ResponseEntity<Game>(game, HttpStatus.CREATED);
    }
  }

  @GetMapping(value = "/main/game/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Game> getGame(@PathVariable("id") int id) {
    Game game = gameService.findById(id);
    if (game == null) {
      return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Game>(game, HttpStatus.OK);
  }

  @DeleteMapping("/main/game/{id}")
  public ResponseEntity<Game> deleteUser(@PathVariable("id") int id) {

    Game game = gameService.findById(id);
    if (game == null) {

      return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
    }
    gameService.delete(id);
    return new ResponseEntity<Game>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/main/game/{id}")
  public ResponseEntity<Game> updateGame(@PathVariable("id") int id, @RequestBody Game game) {

    Game currentGame = gameService.findById(id);

    if (currentGame == null) {
      return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
    }
    gameService.update(game);
    return new ResponseEntity<Game>(game, HttpStatus.OK);
  }

}
