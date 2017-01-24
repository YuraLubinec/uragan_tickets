package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.uragan.model.Seat;

@Repository
public class SeatDAOImpl extends AbstractDAO<Integer, Seat> {

  @SuppressWarnings("unchecked")

  public List<Seat> findAllSeats() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Seat>) crit.list();
  }

}
