package com.uragan.DTO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TicketDTO {
  private int id;
  private int game_id;
  private int seat_id;

  public int getId() {

    return id;
  }

  public void setId(int id) {

    this.id = id;
  }

  public int getGame_id() {

    return game_id;
  }

  public void setGame_id(int game_id) {

    this.game_id = game_id;
  }

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
