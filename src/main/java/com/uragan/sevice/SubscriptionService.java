package com.uragan.sevice;

import java.util.List;

import com.uragan.model.Subscription;

public interface SubscriptionService {

  List<Subscription> findAllSubscription();

  void save(Subscription subscription);

  void delete(int id);

  Subscription findById(int id);

  void update(Subscription subscription);

}
