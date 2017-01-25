package com.uragan.DAO;

import java.util.List;

import com.uragan.model.Subscription;

public interface SubscriptionDAO {

  Subscription findById(int id);

  List<Subscription> findAll();

  void save(Subscription subscription);

  void delete(int id);

}
