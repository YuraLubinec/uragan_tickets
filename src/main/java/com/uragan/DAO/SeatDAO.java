package com.uragan.DAO;

import java.util.List;

import com.uragan.model.Seat;

public interface SeatDAO {

  Seat findById(int id);

  List<Seat> findAllSeats();

  void save(Seat seat);

}
