package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.uragan.model.Season;

@Repository
public class SeasonDAOImpl extends AbstractDAO<Integer, Season> implements SeasonDAO {

  @Override
  public Season findById(int id) {
    return getById(id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Season> findAllSeason() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Season>) crit.list();
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
