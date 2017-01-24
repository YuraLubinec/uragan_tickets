package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.uragan.model.Game;

public class GameDAOImpl extends AbstractDAO<Integer, Game> implements GameDAO {

  @SuppressWarnings("unchecked")
  @Override
  public List<Game> findAllGames() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Game>) crit.list();
  }

}
