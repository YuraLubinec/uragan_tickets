package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.model.Game;
import com.uragan.sevice.GameService;

@RestController
public class GameRestController {

  @Autowired
  GameService gameService;

  @GetMapping("/main/game")
  public ResponseEntity<List<Game>> listAllSeats() {

    List<Game> games = gameService.findAllGame();
    if (games.isEmpty()) {
      return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
  }

}
