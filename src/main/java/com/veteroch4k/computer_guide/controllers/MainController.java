package com.veteroch4k.computer_guide.controllers;

import jakarta.jws.WebParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz")
public class MainController {

  @GetMapping("")
  public ModelAndView index(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Техно сайт");
    modelAndView.setViewName("index");
    return modelAndView;

  }

}
