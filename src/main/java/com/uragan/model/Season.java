package com.uragan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "season")
public class Season {

  private int id;
  private String years;
  private Set<Game> games = new HashSet<>();
  private Set<Subscription> subscription = new HashSet<>();

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

  @OneToMany
  @JoinColumn(name = "season_id")
  public Set<Game> getGames() {
    return games;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }

  @OneToMany
  @JoinColumn(name = "season_id")
  public Set<Subscription> getSubscription() {
    return subscription;
  }

  public void setSubscription(Set<Subscription> subscription) {
    this.subscription = subscription;
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
