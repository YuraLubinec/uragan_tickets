package com.uragan.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uragan.model.Seat;

@Repository
public class SeatDAOImpl extends AbstractDAO<Integer, Seat> implements SeasonDAO {

  @SuppressWarnings("unchecked")
  public List<Seat> findAllSeats() {

    return (List<Seat>) createEntityCriteria().list();
  }

}
