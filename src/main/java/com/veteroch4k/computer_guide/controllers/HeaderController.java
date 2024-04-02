package com.veteroch4k.computer_guide.controllers;

import jakarta.jws.WebParam.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz")
public class HeaderController {

    @GetMapping("/aboutUs")
    public ModelAndView aboutUs(ModelAndView modelAndView) {
        modelAndView.addObject("title", "О нашем сайте");
        modelAndView.setViewName("header-pages/aboutUs");
        return modelAndView;
    }

    @GetMapping("/periphery")
    public ModelAndView periphery(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Периферия");
        modelAndView.setViewName("header-pages/periphery");
        return modelAndView;
    }

    @GetMapping("/system-unit")
    public ModelAndView system_unit(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Системный блок");
        modelAndView.setViewName("header-pages/system-unit");
        return modelAndView;
    }

    @GetMapping("/testing-system")
    public ModelAndView testing(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Система тестирования");
        modelAndView.setViewName("header-pages/testing-system");
        return modelAndView;
    }
}
