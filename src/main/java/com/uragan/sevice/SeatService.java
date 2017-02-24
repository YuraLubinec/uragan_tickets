package com.uragan.sevice;

import java.util.List;

import com.uragan.model.Seat;
import com.uragan.model.Ticket;

public interface SeatService {

  Seat findById(int id);

  List<Seat> findAllSeats();

  List<Seat> findSeatsByTicketId(List<Ticket> listTickets);

  void save(Seat seat);

}
