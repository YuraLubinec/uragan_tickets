package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uragan.model.Game;
import com.uragan.model.Sector;
import com.uragan.model.Ticket;
import com.uragan.sevice.GameService;
import com.uragan.sevice.SeasonService;
import com.uragan.sevice.SeatService;
import com.uragan.sevice.SectorService;
import com.uragan.sevice.TicketService;

@RestController
@RequestMapping(value="/main")
public class MainRestController {

  @Autowired
  private SeatService serviceSeat;
  
  @Autowired
  private SectorService serviceSector;
  
  @Autowired
  private SeasonService serviceSeason;
  
  @Autowired
  private TicketService serviceTicket;
  
  @Autowired
  private GameService serviceGame;
  
  @GetMapping
  public ResponseEntity<List<Sector>> getAllSeats() {
    
    List<Sector> sectors = serviceSector.findAllSector();
    if (sectors.isEmpty()) {
      return new ResponseEntity<List<Sector>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Sector>>(sectors, HttpStatus.OK);
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void ticketSave(@RequestBody Ticket ticket) {    
   
    serviceTicket.save(ticket);
  }
  
  @GetMapping("/games")
  public ResponseEntity<List<Game>> getAllGames (){
    
    List <Game> games = serviceGame.findAllGames();
    if (games.isEmpty()) {
      return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
  }
  
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void ticketSave(@PathVariable int id) {    
   
    serviceTicket.delete(id);
  }

}
