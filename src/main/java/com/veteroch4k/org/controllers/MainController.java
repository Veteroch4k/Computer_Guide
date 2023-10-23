package com.veteroch4k.org.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz")
public class MainController {

  @GetMapping("")
  public String index(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Техно сайт");
    return "index";

  }

}
