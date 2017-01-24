package com.uragan.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

  private int id;
  private String firstTeam;
  private String secondTeam;
  private String date;
  private String time;
  private Season season;
  private Set<Ticket> tickets;

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

  @Column(name = "first_team")
  public String getFirstTeam() {
    return firstTeam;
  }

  public void setFirstTeam(String firstTeam) {
    this.firstTeam = firstTeam;
  }

  @Column(name = "second_team")
  public String getSecongTeam() {
    return secondTeam;
  }

  public void setSecongTeam(String secondTeam) {
    this.secondTeam = secondTeam;
  }

  @Column(name = "date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Column(name = "time")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @ManyToOne
  @JoinColumn(name = "season_id", referencedColumnName = "id")
  public Season getSeason() {
    return season;
  }

  public void setSeason(Season season) {
    this.season = season;
  }

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }

}
