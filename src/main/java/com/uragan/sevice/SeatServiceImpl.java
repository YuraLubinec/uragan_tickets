package com.uragan.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.SeatDAO;
import com.uragan.model.Seat;
import com.uragan.model.Ticket;

@Service
public class SeatServiceImpl implements SeatService {

  @Autowired
  SeatDAO dao;

  @Transactional
  @Override
  public Seat findById(int id) {
    return dao.findById(id);
  }

  @Transactional
  @Override
  public List<Seat> findAllSeats() {
    return dao.findAllSeats();
  }

  @Transactional
  @Override
  public void save(Seat seat) {
    dao.save(seat);
  }

  @Transactional
  @Override
  public List<Seat> findSeatsByTicketId(List<Ticket> listTickets) {
    List<Seat> listSeats = new ArrayList<>();
    for (int i = 0; i < listTickets.size(); i++) {
      listSeats.add(dao.findById(listTickets.get(i).getSeat_id()));
    }
    return listSeats;
  }

}
