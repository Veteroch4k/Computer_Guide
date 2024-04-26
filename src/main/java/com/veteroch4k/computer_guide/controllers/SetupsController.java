package com.veteroch4k.computer_guide.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz/setups")
public class SetupsController {

    @GetMapping("/gaming-setup")
    public ModelAndView gaming_setup(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Игровой сетап");

        modelAndView.setViewName("setups/gaming_setup");
        return modelAndView;
    }


    @GetMapping("/streaming-setup")
    public ModelAndView streaming_setup(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Стриминговый сетап");

        modelAndView.setViewName("setups/streaming_setup");
        return modelAndView;
    }

    @GetMapping("/cheap-setup")
    public ModelAndView cheap_setup(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Бюджетный сетап");

        modelAndView.setViewName("setups/cheap_setup");
        return modelAndView;
    }

    @GetMapping("/mini-setup")
    public ModelAndView mini_setup(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Мини-ПК");

        modelAndView.setViewName("setups/mini_setup");
        return modelAndView;
    }

}
