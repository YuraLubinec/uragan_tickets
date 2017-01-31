package com.uragan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "game")
public class Game {

  private int id;
  private String firstTeam;
  private String secondTeam;
  private String date;
  private String time;
  private int season_id;
  private List<Ticket> tickets;

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
  public String getSecondTeam() {
    return secondTeam;
  }

  public void setSecondTeam(String secondTeam) {
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

  @Column(name = "season_id")
  public int getSeason_id() {
    return season_id;
  }

  public void setSeason_id(int season_id) {
    this.season_id = season_id;
  }

  @OneToMany
  @JoinColumn(name = "game_id")
  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, true);

  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, true);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
