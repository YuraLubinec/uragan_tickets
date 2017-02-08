package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.uragan.model.Subscription;

@Repository
public class SubscriptionDAOImpl extends AbstractDAO<Integer, Subscription> implements SubscriptionDAO {

  @Override
  public Subscription findById(int id) {
    return getById(id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Subscription> findAll() {

    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Subscription>) crit.list();
  }

  @Override
  public void save(Subscription subscription) {
    persist(subscription);

  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    Subscription sub = (Subscription) crit.uniqueResult();
    delete(sub);

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Subscription> findAllBySeasonId(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("season_id", id));
    return (List<Subscription>) crit.list();
  }

}
