package com.uragan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {
  private int id;
  private int row;
  private int place;
  private Sector sector;

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

  @Column(name = "row")
  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  @Column(name = "place")
  public int getPlace() {
    return place;
  }

  public void setPlace(int place) {
    this.place = place;
  }

  @ManyToOne
  @JoinColumn(name = "sector_id", referencedColumnName = "id")
  public Sector getSector() {
    return sector;
  }

  public void setSector(Sector sector) {
    this.sector = sector;
  }

}
