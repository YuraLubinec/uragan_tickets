package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.uragan.model.Ticket;

@Repository
public class TicketDAOImpl extends AbstractDAO<Integer, Ticket> implements TicketDAO {

  @SuppressWarnings("unchecked")
  @Override
  public List<Ticket> findAllTickets() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Ticket>) crit.list();
  }

  @Override
  public Ticket findById(int id) {
    return getById(id);
  }

  @Override
  public void save(Ticket ticket) {
    persist(ticket);
  }
}
