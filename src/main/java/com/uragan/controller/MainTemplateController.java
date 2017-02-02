package com.uragan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class MainTemplateController {

  @GetMapping("/main")
  public String getAllSeat() {

    return "main-page.template";
  }
  
  @GetMapping("/login")
  public String getLoginPage() {

    return "login-page.template";
  }

  @GetMapping("/games")
  public String getAllGame() {
    return "game-list.template";
  }

  @GetMapping("/subscriptions")
  public String getAllSubscription() {
    System.out.println("bla bla SUB".toUpperCase());
    return "subscription-page.template";
  }

}
