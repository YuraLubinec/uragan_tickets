package com.uragan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class MainTemplateController {
  
  @GetMapping("/seats")
  public String getAllSeat(){
   
    return "seat-list.template";   
  }

}
