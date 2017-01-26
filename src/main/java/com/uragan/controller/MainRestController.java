package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.model.Season;
import com.uragan.model.Seat;
import com.uragan.model.Sector;
import com.uragan.sevice.SeasonService;
import com.uragan.sevice.SeatService;
import com.uragan.sevice.SectorService;

@RestController
@RequestMapping(value="/main")
public class MainRestController {

  @Autowired
  private SeatService serviceSeat;
  
  @Autowired
  private SectorService serviceSector;
  
  @Autowired
  private SeasonService serviceSeason;
  
  @GetMapping
  public ResponseEntity<List<Sector>> listAllSeats() {
    
    List<Sector> sectors = serviceSector.findAllSector();
    if (sectors.isEmpty()) {
      return new ResponseEntity<List<Sector>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Sector>>(sectors, HttpStatus.OK);
  }

}
