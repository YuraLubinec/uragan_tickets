package com.uragan.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "season")
public class Season {

  private int id;
  private String years;
  private Set<Game> games;
  private Set<Subscription> subscription;

  // getters and setters

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "years")
  public String getYears() {
    return years;
  }

  public void setYears(String years) {
    this.years = years;
  }

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
  public Set<Game> getGames() {
    return games;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
  public Set<Subscription> getSubscription() {
    return subscription;
  }

  public void setSubscription(Set<Subscription> subscription) {
    this.subscription = subscription;
  }

}
