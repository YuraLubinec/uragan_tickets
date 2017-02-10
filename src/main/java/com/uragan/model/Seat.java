package com.uragan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "seat")
public class Seat {
  private int id;
  private int row;
  private int place;
  private int sector_id;

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

  @Column(name = "sector_id")
  public int getSector_id() {
    return sector_id;
  }

  public void setSector_id(int sector_id) {
    this.sector_id = sector_id;
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
