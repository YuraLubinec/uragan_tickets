package com.uragan.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.SeatDAOImpl;
import com.uragan.model.Seat;

@Service
public class Servicesss {
  @Autowired
  SeatDAOImpl seatDao;

  @Transactional
  public List<Seat> getAllSeats() {
    return seatDao.findAllSeats();
  }

}
