package com.veteroch4k.computer_guide.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz/testing-system")
public class TestingSystemController {

  @GetMapping("/cpu")
  public ModelAndView cpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Центральный процессор");
    modelAndView.setViewName("testing-units/central_processor");
    return modelAndView;

  }

  @GetMapping("/gpu")
  public ModelAndView gpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Графический процессор");
    modelAndView.setViewName("testing-units/graphic_card");
    return modelAndView;

  }
  @GetMapping("/motherboard")
  public ModelAndView motherboard(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Материнская плата");
    modelAndView.setViewName("testing-units/motherboard");
    return modelAndView;

  }
  @GetMapping("/powerUnit")
  public ModelAndView powerUnit(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Блок питания");
    modelAndView.setViewName("testing-units/power_unit");
    return modelAndView;

  }
  @GetMapping("/ram")
  public ModelAndView ram(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Оперативная память");
    modelAndView.setViewName("testing-units/random_access_memory");
    return modelAndView;

  }
  @GetMapping("/storageDevices")
  public ModelAndView storageDevices(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Накопители");
    modelAndView.setViewName("testing-units/storage_devices");
    return modelAndView;

  }
  @GetMapping("/сoolingSystem")
  public ModelAndView сoolingSystem(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Система охлаждения");
    modelAndView.setViewName("testing-units/сooling_system");
    return modelAndView;

  }

}

