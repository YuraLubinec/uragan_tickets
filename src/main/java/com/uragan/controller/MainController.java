package com.uragan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController {

  @GetMapping("/")
  public String mainMethod() {
    
    return "main";
  }
  
  @GetMapping("/authenticated")
  @ResponseStatus(HttpStatus.OK)
  public void checkAuthentication() {
  }

}
