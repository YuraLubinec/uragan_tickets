package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.uragan.model.Game;
import com.uragan.model.Season;

@Repository
public class SeasonDAOImpl extends AbstractDAO<Integer, Season> implements SeasonDAO {

  @Override
  public Season findById(int id) {
    Season season = getById(id);
    if (season != null) {
      Hibernate.initialize(season.getGames());
      for (Game games : season.getGames()) {
        Hibernate.initialize(games.getTickets());
      }
      Hibernate.initialize(season.getSubscription());
    }
    return getById(id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Season> findAllSeason() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    List<Season> seasons = (List<Season>) crit.list();
    for (Season season : seasons) {
      Hibernate.initialize(season.getGames());

      for (Game games : season.getGames()) {
        Hibernate.initialize(games.getTickets());
      }
      Hibernate.initialize(season.getSubscription());
    }
    return seasons;
  }

  @Override
  public void save(Season season) {
    persist(season);

  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    Season season = (Season) crit.uniqueResult();
    delete(season);
  }

}
