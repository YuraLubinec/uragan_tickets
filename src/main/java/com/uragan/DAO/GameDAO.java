package com.uragan.DAO;

import java.util.List;

import com.uragan.model.Game;

public interface GameDAO {

  List<Game> findAllGames();

}
