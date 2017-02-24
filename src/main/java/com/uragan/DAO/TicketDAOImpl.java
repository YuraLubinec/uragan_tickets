package com.uragan.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

  @Override
  public void delete(int id) {
    Ticket ticket = getById(id);
    delete(ticket);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Ticket> findTicketsByIdGame(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("game_id", id));
    crit.addOrder(Order.desc("id"));
    return (List<Ticket>) crit.list();
  }
}
