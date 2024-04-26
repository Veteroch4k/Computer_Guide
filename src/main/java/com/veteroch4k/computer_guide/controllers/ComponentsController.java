package com.veteroch4k.computer_guide.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/technoknyaz/components")
public class ComponentsController {


    @GetMapping("/gpu")
    ModelAndView gpu(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Видекарта");

        modelAndView.setViewName("components/gpu");
        return modelAndView;
    }

    @GetMapping("/cpu")
    ModelAndView cpu(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Процессор");

        modelAndView.setViewName("components/cpu");
        return modelAndView;
    }

    @GetMapping("/motherboard")
    ModelAndView motherboard(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Материнская плата");

        modelAndView.setViewName("components/motherboard");
        return modelAndView;
    }

    @GetMapping("/power")
    ModelAndView power(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Блок питания");

        modelAndView.setViewName("components/power");
        return modelAndView;
    }

    @GetMapping("/ram")
    ModelAndView ram(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Оперативная память");

        modelAndView.setViewName("components/ram");
        return modelAndView;
    }

    @GetMapping("/storage-devices")
    ModelAndView storage_devices(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Накопители");

        modelAndView.setViewName("components/storage_devices");
        return modelAndView;
    }

    @GetMapping("/сooling-system")
    ModelAndView сooling_system(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Охлаждение");

        modelAndView.setViewName("components/сooling_system");
        return modelAndView;
    }

    @GetMapping("/system-unit")
    ModelAndView system_unit(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Корпус");

        modelAndView.setViewName("components/system_unit");
        return modelAndView;
    }




}
