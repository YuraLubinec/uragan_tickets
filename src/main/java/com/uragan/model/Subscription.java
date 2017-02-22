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
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "subscription")
public class Subscription {
  private int id;
  private String fullName;
  private int season_id;
  private int seat_id;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @NotBlank
  @Column(name = "fullname")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Column(name = "season_id")
  public int getSeason_id() {
    return season_id;
  }

  public void setSeason_id(int season_id) {
    this.season_id = season_id;
  }

  @Column(name = "seat_id")
  public int getSeat_id() {
    return seat_id;
  }

  public void setSeat_id(int seat_id) {
    this.seat_id = seat_id;
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
