package com.uragan.DAO;

import java.util.List;

import com.uragan.model.Game;

public interface GameDAO {

  List<Game> findAllGames();

  Game findById(int id);

  void save(Game game);

  void delete(int id);

}
