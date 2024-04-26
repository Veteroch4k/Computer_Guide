package com.veteroch4k.computer_guide.controllers;

import org.hibernate.annotations.CollectionTypeRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz/periphery")
public class PeripheryController {

    @GetMapping("/keyboard")
    ModelAndView keyboard(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Клавиатура");

        modelAndView.setViewName("periphery/keyboard_page");
        return modelAndView;
    }

    @GetMapping("/mouse")
    ModelAndView mouse(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Мышь");

        modelAndView.setViewName("periphery/mouse_page");
        return modelAndView;
    }

    @GetMapping("/headphones")
    ModelAndView headphones(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Наушники");

        modelAndView.setViewName("periphery/headphones_page");
        return modelAndView;
    }

    @GetMapping("/monitor")
    ModelAndView monitor(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Монитор");

        modelAndView.setViewName("periphery/monitor_page");
        return modelAndView;
    }

    @GetMapping("/gamepad")
    ModelAndView gamepad(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Геймпад");

        modelAndView.setViewName("periphery/gamepad_page");
        return modelAndView;
    }

    @GetMapping("/camera")
    ModelAndView camera(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Камера");

        modelAndView.setViewName("periphery/camera_page");
        return modelAndView;
    }
}
