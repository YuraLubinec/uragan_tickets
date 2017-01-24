package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.model.Seat;
import com.uragan.sevice.Servicesss;

@RestController
public class MainRestController {

  @Autowired
  private Servicesss serv;

  @RequestMapping(value = "/main", method = RequestMethod.GET)
  public ResponseEntity<List<Seat>> listAllSeats() {
    System.out.println("here");
    List<Seat> seats = serv.getAllSeats();
    System.out.println(seats);
    if (seats.isEmpty()) {
      return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);// You many decide to
                                                                   // return
                                                                   // HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
  }

}
