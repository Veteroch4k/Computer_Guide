package com.veteroch4k.computer_guide.controllers;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz/testing-system")
public class TestingSystemController {

  @GetMapping("/cpu")
  public ModelAndView cpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Центральный процессор");
    modelAndView.setViewName("testing-units/questions/central_processor");
    return modelAndView;

  }
  @PostMapping("/cpu/process-answers")
  public ResponseEntity<String> cpuAns(@RequestBody Map<String, String> answers) {

    return ResponseEntity.ok("Ответы успешно обработаны");

  }
  @GetMapping("/cpu/results")
  public ModelAndView cpuResult(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Результаты");
    modelAndView.setViewName("testing-units/results/cpu_answers");
    return modelAndView;
  }

  @GetMapping("/gpu")
  public ModelAndView gpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Графический процессор");
    modelAndView.setViewName("testing-units/questions/graphic_card");
    return modelAndView;

  }
  @GetMapping("/motherboard")
  public ModelAndView motherboard(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Материнская плата");
    modelAndView.setViewName("testing-units/questions/motherboard");
    return modelAndView;

  }
  @GetMapping("/powerUnit")
  public ModelAndView powerUnit(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Блок питания");
    modelAndView.setViewName("testing-units/questions/power_unit");
    return modelAndView;

  }
  @GetMapping("/ram")
  public ModelAndView ram(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Оперативная память");
    modelAndView.setViewName("testing-units/questions/random_access_memory");
    return modelAndView;

  }
  @GetMapping("/storageDevices")
  public ModelAndView storageDevices(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Накопители");
    modelAndView.setViewName("testing-units/questions/storage_devices");
    return modelAndView;

  }
  @GetMapping("/сoolingSystem")
  public ModelAndView сoolingSystem(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Система охлаждения");
    modelAndView.setViewName("testing-units/questions/сooling_system");
    return modelAndView;

  }

}

