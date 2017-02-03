package com.uragan.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .authorizeRequests()
//        .antMatchers("/login").permitAll()
//        .antMatchers("/**").access("isAuthenticated()")
        .antMatchers("/**").permitAll()
        .and()
        .formLogin().loginPage("/login").loginProcessingUrl("/loginCheck").usernameParameter("username")
        .defaultSuccessUrl("/", true).passwordParameter("password").failureUrl("/login?error=true")
        .and()
        .csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {

    web.ignoring().antMatchers("/resources/**");

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("user").password("user").roles("admin");
  }

}