package com.veteroch4k.computer_guide.controllers;

import com.veteroch4k.computer_guide.models.Cpu_question;
import com.veteroch4k.computer_guide.models.Gpu_question;
import com.veteroch4k.computer_guide.models.Motherboard_question;
import com.veteroch4k.computer_guide.models.Ram_question;
import com.veteroch4k.computer_guide.services.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

  private  Long res = 0L;

  @Autowired
  private AbstractDAO dao;

  /** ЦП **/

  @GetMapping("/cpu")
  public ModelAndView cpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Центральный процессор");

    dao.setClazzSimpleName(Cpu_question.class.getSimpleName());
    modelAndView.addObject("questions", dao.getQuestions());
    modelAndView.addObject("variants", dao.getVariants());

    modelAndView.addObject("type", dao.getType());
    modelAndView.setViewName("testing-units/questions/central_processor");
    return modelAndView;

  }

  @PostMapping("/cpu/process-answers")
  public ResponseEntity<String> cpuAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    dao.setClazzSimpleName(Cpu_question.class.getSimpleName());

    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);
    res = dao.checkAnswers(answerValues);
    return ResponseEntity.ok("Ответы успешно обработаны");

  }

  @GetMapping("/cpu/results")
  public ModelAndView cpuResult(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Результаты");
    modelAndView.addObject("result", res);
    modelAndView.setViewName("testing-units/results/cpu_answers");
    return modelAndView;
  }

  /** Видеокарта **/

  @GetMapping("/gpu")
  public ModelAndView gpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Графический процессор");

    dao.setClazzSimpleName(Gpu_question.class.getSimpleName());


    modelAndView.addObject("questions", dao.getQuestions());
    modelAndView.addObject("variants", dao.getVariants());

    modelAndView.addObject("type", dao.getType());
    modelAndView.setViewName("testing-units/questions/graphic_card");
    return modelAndView;

  }

  @PostMapping("/gpu/process-answers")
  public ResponseEntity<String> gpuAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);
    dao.setClazzSimpleName(Gpu_question.class.getSimpleName());

    res = dao.checkAnswers(answerValues);
    return ResponseEntity.ok("Ответы успешно обработаны");

  }

  @GetMapping("/gpu/results")
  public ModelAndView gpuResult(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Результаты");
    modelAndView.addObject("result", res);
    modelAndView.setViewName("testing-units/results/gpu_answers");
    return modelAndView;
  }

  /** Материнская плата **/

  @GetMapping("/motherboard")
  public ModelAndView motherboard(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Материнская плата");
    dao.setClazzSimpleName(Motherboard_question.class.getSimpleName());



    modelAndView.addObject("questions", dao.getQuestions());
    modelAndView.addObject("variants", dao.getVariants());

    modelAndView.addObject("type", dao.getType());
    modelAndView.setViewName("testing-units/questions/motherboard");
    return modelAndView;

  }

  @PostMapping("/motherboard/process-answers")
  public ResponseEntity<String> motherboardAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);
    dao.setClazzSimpleName(Motherboard_question.class.getSimpleName());


    res = dao.checkAnswers(answerValues);
    return ResponseEntity.ok("Ответы успешно обработаны");

  }

  @GetMapping("/motherboard/results")
  public ModelAndView motherboardResult(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Результаты");
    modelAndView.addObject("result", res);
    modelAndView.setViewName("testing-units/results/motherboard_answers");
    return modelAndView;
  }

  /** Оперативная память **/

  @GetMapping("/ram")
  public ModelAndView ram(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Оперативная память");
    dao.setClazzSimpleName(Ram_question.class.getSimpleName());


    modelAndView.addObject("questions", dao.getQuestions());
    modelAndView.addObject("variants", dao.getVariants());

    modelAndView.addObject("type", dao.getType());
    modelAndView.setViewName("testing-units/questions/ram");
    return modelAndView;

  }

  @PostMapping("/ram/process-answers")
  public ResponseEntity<String> ramAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);
    dao.setClazzSimpleName(Ram_question.class.getSimpleName());

    res = dao.checkAnswers(answerValues);
    return ResponseEntity.ok("Ответы успешно обработаны");

  }

  @GetMapping("/ram/results")
  public ModelAndView ramResult(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Результаты");
    modelAndView.addObject("result", res);
    modelAndView.setViewName("testing-units/results/ram_answers");
    return modelAndView;
  }

  /**   **/

  @GetMapping("/powerUnit")
  public ModelAndView powerUnit(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Блок питания");
    modelAndView.setViewName("testing-units/questions/power_unit");
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

