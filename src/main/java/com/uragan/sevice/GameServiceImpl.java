package com.uragan.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.GameDAO;
import com.uragan.model.Game;

@Service
public class GameServiceImpl implements GameService {
  @Autowired
  GameDAO dao;

  @Transactional
  @Override
  public List<Game> findAllGame() {
    return dao.findAllGames();
  }

  @Transactional
  @Override
  public void save(Game game) {
    dao.save(game);
  }

  @Transactional
  @Override
  public void delete(int id) {
    dao.delete(id);
  }

  @Transactional
  @Override
  public Game findById(int id) {
    return dao.findById(id);
  }
}
