package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.uragan.model.Game;

@Repository
public class GameDAOImpl extends AbstractDAO<Integer, Game> implements GameDAO {

  @SuppressWarnings("unchecked")
  @Override
  public List<Game> findAllGames() {
   
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    List<Game> gameList = (List<Game>) crit.list();
    for (Game game : gameList){
      Hibernate.initialize(game.getTickets());
    }
    return gameList;
  }

  @Override
  public Game findById(int id) {
    
    Game game = getById(id);
    if(game != null){
      Hibernate.initialize(game.getTickets());
    }
    return game;
  }

  @Override
  public void save(Game game) {
    
    persist(game);
  }

  @Override
  public void delete(int id) {
    
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    Game game = (Game) crit.uniqueResult();
    delete(game);
  }

}
