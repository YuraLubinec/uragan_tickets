package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.uragan.model.Seat;

@Repository
public class SeatDAOImpl extends AbstractDAO<Integer, Seat> implements SeatDAO {

  @SuppressWarnings("unchecked")
  public List<Seat> findAllSeats() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Seat>) createEntityCriteria().list();
  }

  @Override
  public Seat findById(int id) {
    return getById(id);
  }

  @Override
  public void save(Seat seat) {
    persist(seat);
  }

}
