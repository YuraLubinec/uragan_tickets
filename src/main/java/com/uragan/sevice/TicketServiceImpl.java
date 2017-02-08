package com.uragan.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.TicketDAO;
import com.uragan.model.Subscription;
import com.uragan.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  TicketDAO dao;

  @Transactional
  @Override
  public List<Ticket> findAllTicket() {

    return dao.findAllTickets();
  }

  @Transactional
  @Override
  public void save(Ticket ticket) {

    dao.save(ticket);
  }

  @Transactional
  @Override
  public Ticket findById(int id) {

    return dao.findById(id);
  }

  @Transactional
  @Override
  public void delete(int id) {

    dao.delete(id);
  }

  @Transactional
  @Override
  public void saveTicketsForSubscriptions(int idGame, List<Subscription> list) {
    for (int i = 0; i < list.size(); i++) {
      Ticket ticket = createTicket(idGame, list.get(i).getSeat_id());
      dao.save(ticket);
    }
  }

  private Ticket createTicket(int idGame, int idSeat) {
    Ticket ticket = new Ticket();
    ticket.setGame_id(idGame);
    ticket.setSeat_id(idSeat);
    return ticket;
  }
}
