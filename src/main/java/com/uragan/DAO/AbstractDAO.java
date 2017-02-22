package com.uragan.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<ID extends Serializable, T> {

  private final Class<T> persClass;

  @Autowired
  private SessionFactory sessionFactory;

  @SuppressWarnings("unchecked")
  public AbstractDAO() {
   
    this.persClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[1];
  }

  protected Session getSesssion() {
    
    return sessionFactory.getCurrentSession();
  }

  public T getById(ID id) {
    
    return (T) getSesssion().get(persClass, id);
  }

  public void persist(T entity) {
    
    getSesssion().persist(entity);
  }

  public void delete(T entity) {
    
    getSesssion().delete(entity);
  }

  protected Criteria createEntityCriteria() {
   
    return getSesssion().createCriteria(persClass);
  }

}
