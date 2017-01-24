package com.uragan.DAO;

import java.util.List;

import com.uragan.model.Ticket;

public interface TicketDAO {

  List<Ticket> findAllTickets();

}
