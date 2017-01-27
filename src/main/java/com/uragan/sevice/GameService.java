package com.uragan.sevice;

import java.util.List;

import com.uragan.model.Game;

public interface GameService {

  List<Game> findAllGame();

  void save(Game game);

  void delete(int id);

  Game findById(int id);

  void update(Game game);
}
