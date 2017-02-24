package com.uragan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController {
  
  private static final String SUCCES = "succes";

  @GetMapping("/")
  public String mainMethod() {
    
    return "main";
  }
  
  @GetMapping("/authenticated")
  @ResponseStatus(HttpStatus.OK)
  public void checkAuthentication() {
  }
  
  /**
   * Retrieves login page.
   * 
   * @return name of view
   */
  @GetMapping("/login")
  public String getLoginPage(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth instanceof AnonymousAuthenticationToken) {
      return "login";
    }
    model.addAttribute(SUCCES, auth.isAuthenticated());
    return "login";
  }
  
  /**
   * Handles logout process.
   * 
   * @param request {@link HttpServletRequest} instance
   * @param response {@link HttpServletResponse} instance
   * @return redirect to login page
   */
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("ssasas");

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login";
  }
  
  
  

}
