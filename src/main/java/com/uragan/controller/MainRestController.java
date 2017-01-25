package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.model.Seat;
import com.uragan.sevice.Servicesss;

@RestController
public class MainRestController {

  @Autowired
  private Servicesss serv;

  @GetMapping(value = "/main")
  public ResponseEntity<List<Seat>> listAllSeats() {
   
    List<Seat> seats = serv.getAllSeats();
    if (seats.isEmpty()) {
      return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
  }

}
