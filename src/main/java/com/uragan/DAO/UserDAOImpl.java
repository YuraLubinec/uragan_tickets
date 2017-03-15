package com.uragan.DAO;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.uragan.model.User;

@Repository
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO {

  @Override
  public User findByUsername(String username) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("username", username));
    return (User) crit.uniqueResult();
  }

  @Override
  public void save(User user) {
    persist(user);
  }

}
