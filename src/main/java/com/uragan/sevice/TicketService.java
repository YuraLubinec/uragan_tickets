package com.uragan.sevice;

import java.util.List;

import com.uragan.model.Ticket;

public interface TicketService {

  List<Ticket> findAllTicket();

  void save(Ticket ticket);

  Ticket findById(int id);

}
