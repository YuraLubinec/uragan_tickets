package com.uragan.sevice.facebookOAuth;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.UserDAO;
import com.uragan.model.User;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {
  
  @Autowired
  private UserDAO userDAO;

  @Transactional
  @Override
  public String execute(Connection<?> connection) {
    String username = connection.getDisplayName();
    User user = userDAO.findByUsername(username);
    if(user==null){
      user = new User();
      user.setUsername(connection.getDisplayName());
      user.setRole("facebook_user");
      user.setPassword(randomAlphabetic(8));
      userDAO.save(user);
    }
    return user.getUsername();
  }

}
