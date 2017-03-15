package com.uragan.sevice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uragan.DAO.UserDAO;
import com.uragan.model.User;

@Service
public class MyUserDatailsService implements UserDetailsService {

  @Autowired
  private UserDAO userDAOImpl;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    final User user = userDAOImpl.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true,
        Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
  }

}
