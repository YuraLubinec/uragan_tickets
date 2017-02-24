package com.uragan.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private RestUnauthorizedEntryPoint entryPoint;

  @Autowired
  private RestAuthenticationSuccessHandler successHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/template/login","/template/navbar", "/").permitAll().anyRequest().authenticated().and()
        .exceptionHandling().authenticationEntryPoint(entryPoint).and().formLogin().loginPage("/login")
        .successHandler(successHandler).failureHandler(new SimpleUrlAuthenticationFailureHandler())
        .loginProcessingUrl("/loginCheck").usernameParameter("username").passwordParameter("password").and().logout()
        .logoutUrl("/logout").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
        .deleteCookies("JSESSIONID").and().csrf().disable();
  }

  @Bean
  public RestAuthenticationSuccessHandler successHandler() {
    return new RestAuthenticationSuccessHandler();
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