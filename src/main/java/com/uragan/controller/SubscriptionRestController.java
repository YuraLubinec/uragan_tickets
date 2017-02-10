package com.uragan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.uragan.model.Season;
import com.uragan.model.Seat;
import com.uragan.model.Sector;
import com.uragan.model.Subscription;
import com.uragan.sevice.SeasonService;
import com.uragan.sevice.SeatService;
import com.uragan.sevice.SectorService;
import com.uragan.sevice.SubscriptionService;

@RestController
public class SubscriptionRestController {

  @Autowired
  SubscriptionService subService;
  @Autowired
  SeasonService seasonService;
  @Autowired
  SectorService sectorService;
  @Autowired
  SeatService seatService;

  @GetMapping("/main/subscription/seasonSub/{id}")
  public ResponseEntity<List<Subscription>> listAllSubBySeasonId(@PathVariable("id") int id) {
    List<Subscription> sub = subService.findAllBySeasonId(id);
    if (sub.isEmpty()) {

      return new ResponseEntity<List<Subscription>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Subscription>>(sub, HttpStatus.OK);
  }

  @GetMapping("/main/subscription")
  public ResponseEntity<List<Subscription>> listAllSubscriptions() {

    List<Subscription> subs = subService.findAllSubscription();

    if (subs.isEmpty()) {

      return new ResponseEntity<List<Subscription>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Subscription>>(subs, HttpStatus.OK);
  }

  @GetMapping("/main/subscription/seats")
  public ResponseEntity<List<Seat>> listAllSeats() {
    List<Seat> seats = seatService.findAllSeats();
    if (seats.isEmpty()) {
      return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
  }

  @GetMapping("/main/subscription/sectors")
  public ResponseEntity<List<Sector>> listAllSectors() {
    List<Sector> sectors = sectorService.findAllSector();
    if (sectors.isEmpty()) {
      return new ResponseEntity<List<Sector>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Sector>>(sectors, HttpStatus.OK);
  }

  @GetMapping("/main/subscription/season")
  public ResponseEntity<List<Season>> listAllSeasons() {
    List<Season> seasons = seasonService.findAllSeason();
    if (seasons.isEmpty()) {
      return new ResponseEntity<List<Season>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Season>>(seasons, HttpStatus.OK);
  }

  @GetMapping(value = "/main/subscription/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Subscription> getSubscription(@PathVariable("id") int id) {

    Subscription sub = subService.findById(id);
    if (sub == null) {
      return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Subscription>(sub, HttpStatus.OK);
  }

  @PostMapping("/main/subscription")
  public ResponseEntity<Void> createSubscription(@RequestBody Subscription subscription,
      UriComponentsBuilder ucBuilder) {

    subService.save(subscription);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/game/{id}").buildAndExpand(subscription.getId()).toUri());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  @DeleteMapping("/main/subscription/{id}")
  public ResponseEntity<Subscription> deleteSubsription(@PathVariable("id") int id) {
    Subscription sub = subService.findById(id);
    if (sub == null) {
      return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
    }
    subService.delete(id);
    return new ResponseEntity<Subscription>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/main/subscription/{id}")
  public ResponseEntity<Subscription> updateSub(@PathVariable("id") int id, @RequestBody Subscription subscription) {
    Subscription currentSubscription = subService.findById(id);

    if (currentSubscription == null) {
      return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
    }

    subService.update(subscription);
    return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
  }
}
