package com.uragan.DAO;

import java.util.List;

import com.uragan.model.Ticket;

public interface TicketDAO {

  List<Ticket> findAllTickets();

  Ticket findById(int id);

  void save(Ticket ticket);

  void delete(int id);

  List<Ticket> findTicketsByIdGame(int id);

}
