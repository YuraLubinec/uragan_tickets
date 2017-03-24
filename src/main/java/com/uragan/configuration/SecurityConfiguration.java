package com.uragan.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

import com.uragan.sevice.facebookOAuth.FacebookSignInAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private RestUnauthorizedEntryPoint entryPoint;

  @Autowired
  private RestAuthenticationSuccessHandler successHandler;

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Autowired
  private ConnectionFactoryLocator connectionFactoryLocator;

  @Autowired
  private UsersConnectionRepository usersConnectionRepository;
  
  @Autowired
  private ConnectionSignUp facebookConnectionSignup;
  
  @Autowired
  private FacebookSignInAdapter facebookSignInAdapter; 

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/","/signin/**","/signup/**", "/resources/static/templates/login-page.template.html",
            "/resources/static/templates/navbar.template.html")
        .permitAll().anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint).and()
        .formLogin().loginPage("/login").successHandler(successHandler)
        .failureHandler(new SimpleUrlAuthenticationFailureHandler()).loginProcessingUrl("/loginCheck")
        .usernameParameter("username").passwordParameter("password").and().logout().logoutUrl("/logout")
        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).deleteCookies("JSESSIONID").and().csrf()
        .disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {

    web.ignoring().antMatchers("/resources/css/**");
    web.ignoring().antMatchers("/resources/dist/**");
    web.ignoring().antMatchers("/resources/images/**");
    web.ignoring().antMatchers("/resources/modules/**");
    web.ignoring().antMatchers("/resources/app.config.js");
    web.ignoring().antMatchers("/resources/app.module.js");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(userDetailsService);
  }
  
  @Bean
  public ProviderSignInController providerSignInController() {
      ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp(facebookConnectionSignup);
      return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, facebookSignInAdapter);
  }
  


}