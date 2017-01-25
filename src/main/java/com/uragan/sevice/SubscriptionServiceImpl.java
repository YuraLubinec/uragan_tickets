package com.uragan.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.SubscriptionDAO;
import com.uragan.model.Subscription;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

  @Autowired
  SubscriptionDAO dao;

  @Transactional
  @Override
  public List<Subscription> findAllSubscription() {
    return dao.findAll();
  }

  @Transactional
  @Override
  public void save(Subscription subscription) {
    dao.save(subscription);
  }

  @Transactional
  @Override
  public Subscription findById(int id) {
    return dao.findById(id);
  }

  @Override
  public void delete(int id) {
    dao.delete(id);
  }
}
