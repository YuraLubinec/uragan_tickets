package com.uragan.sevice;

import java.util.List;

import com.uragan.model.Seat;

public interface SeatService {

  Seat findById(int id);

  List<Seat> findAllSeats();

  void save(Seat seat);

}
