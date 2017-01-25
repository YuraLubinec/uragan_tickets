package com.uragan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ticket")
public class Ticket {
  private int id;
  private String fullName;
  private Game game;
  private Seat seat;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "fullname")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @ManyToOne
  @JoinColumn(name = "game_id", referencedColumnName = "id")
  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  @OneToOne(cascade = CascadeType.ALL)
  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
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
