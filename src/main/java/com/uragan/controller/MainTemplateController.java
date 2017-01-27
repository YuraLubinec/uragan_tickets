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

  @GetMapping("/games")
  public String getAllGame() {
    System.out.println("bla bla games".toUpperCase());
    return "game-list.template";
  }

}
