package com.uragan.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
@PropertySource("classpath:application.properties")
public class SocialConfiguration {

  @Autowired
  private Environment environment;

  @Bean
  public ConnectionFactoryLocator connectionFactoryLocator() {

    ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
    registry.addConnectionFactory(new FacebookConnectionFactory(environment.getProperty("spring.social.facebook.appId"),
        environment.getProperty("spring.social.facebook.appSecret")));
    return registry;
  }

  @Bean
  public UsersConnectionRepository usersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {

    return new InMemoryUsersConnectionRepository(connectionFactoryLocator);
  }


}
