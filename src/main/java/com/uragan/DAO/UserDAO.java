package com.uragan.DAO;

import com.uragan.model.User;

public interface UserDAO {
  
  User findByUsername(String username);
  
  void save(User user);

}
