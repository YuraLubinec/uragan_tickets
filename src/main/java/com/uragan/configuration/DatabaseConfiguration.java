package com.uragan.configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.uragan.DAO")
@PropertySource("classpath:datasource.properties")
public class DatabaseConfiguration {
  
  @Autowired
  Environment environment;

  @Bean
  public BasicDataSource dataSource() {

    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
    dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
    dataSource.setUsername(environment.getRequiredProperty("jdbc.password"));
    dataSource.setPassword(environment.getRequiredProperty("jdbc.username"));
    dataSource.setDefaultAutoCommit(false);
    return dataSource;
  }

  private Properties hibernateProperties() {

    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
    return properties;
  }

  @Bean
  public SessionFactory sessionFactory(BasicDataSource dataSource) {

    LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionFactoryBuilder.scanPackages("com.uragan.model").addProperties(hibernateProperties());
    return sessionFactoryBuilder.buildSessionFactory();
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {

    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactory);
    return hibernateTransactionManager;
  }
}
