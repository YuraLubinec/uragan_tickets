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
import com.uragan.model.Subscription;
import com.uragan.sevice.SeasonService;
import com.uragan.sevice.SubscriptionService;

@RestController
public class SubscriptionRestController {

  @Autowired
  SubscriptionService subService;
  @Autowired
  SeasonService seasonService;

  // -------------Retrieve All Subscription by id of season--------
  @GetMapping("/main/subscription/seasonSub/{id}")
  public ResponseEntity<List<Subscription>> listAllSubBySeasonId(@PathVariable("id") int id) {
    System.out.println("Controller ..........");
    List<Subscription> sub = subService.findAllBySeasonId(id);
    System.out.println("Subscriptions ..........");
    for (Subscription subs : sub) {
      System.out.print("Name : " + subs.getFullName());
      System.out.println(" " + subs.getSeason_id());
    }

    if (sub.isEmpty()) {

      return new ResponseEntity<List<Subscription>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Subscription>>(sub, HttpStatus.OK);
  }

  // -------------Retrieve All Subscription--------
  @GetMapping("/main/subscription")
  public ResponseEntity<List<Subscription>> listAllSubscriptions() {

    List<Subscription> subs = subService.findAllSubscription();

    if (subs.isEmpty()) {

      return new ResponseEntity<List<Subscription>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Subscription>>(subs, HttpStatus.OK);
  }

  // -------------Retrieve All Seasons--------
  @GetMapping("/main/subscription/season")
  public ResponseEntity<List<Season>> listAllSeasons() {
    List<Season> seasons = seasonService.findAllSeason();
    if (seasons.isEmpty()) {
      return new ResponseEntity<List<Season>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Season>>(seasons, HttpStatus.OK);
  }

  // ------Retrieve Single User--------------------------
  @GetMapping(value = "/main/subscription/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Subscription> getSubscription(@PathVariable("id") int id) {

    Subscription sub = subService.findById(id);
    if (sub == null) {
      return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Subscription>(sub, HttpStatus.OK);
  }

  // --Create a Subscription-----------
  @PostMapping("/main/subscription")
  public ResponseEntity<Void> createSubscription(@RequestBody Subscription subscription,
      UriComponentsBuilder ucBuilder) {

    subService.save(subscription);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/game/{id}").buildAndExpand(subscription.getId()).toUri());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  // --Delete a Subscription-----------
  @DeleteMapping("/main/subscription/{id}")
  public ResponseEntity<Subscription> deleteSubsription(@PathVariable("id") int id) {
    Subscription sub = subService.findById(id);
    if (sub == null) {
      return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
    }
    subService.delete(id);
    return new ResponseEntity<Subscription>(HttpStatus.NO_CONTENT);
  }

  // ------------------- Update a Subscription----------------------------------

  @PutMapping("/main/subscription/{id}")
  public ResponseEntity<Subscription> updateSub(@PathVariable("id") int id, @RequestBody Subscription subscription) {
    System.out.println("Updating Game " + id);

    Subscription currentSubscription = subService.findById(id);

    if (currentSubscription == null) {
      return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
    }

    subService.update(subscription);
    return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
  }
}
