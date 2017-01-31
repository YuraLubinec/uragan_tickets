package com.uragan.sevice;

import java.util.List;

import org.hibernate.Hibernate;
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
  public List<Game> findAllGames() {
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
    Game game = dao.findById(id);
    Hibernate.initialize(game.getTickets());
    return dao.findById(id);
  }

  @Transactional
  @Override
  public void update(Game game) {
    Game entity = null;

    entity = dao.findById(game.getId());
    entity.setFirstTeam(game.getFirstTeam());
    entity.setSecondTeam(game.getSecondTeam());
    entity.setDate(game.getDate());
    entity.setTime(game.getTime());
    entity.setSeason_id(game.getSeason_id());

  }
}
