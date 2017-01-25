package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
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
    return (List<Game>) crit.list();
  }

  @Override
  public Game findById(int id) {
    return getById(id);
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
