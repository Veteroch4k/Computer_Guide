package com.veteroch4k.computer_guide.controllers;

import com.veteroch4k.computer_guide.dao.Cpu_questionDAO;
import com.veteroch4k.computer_guide.dao.Gpu_questionDAO;
import com.veteroch4k.computer_guide.dao.Motherboard_questionDAO;
import com.veteroch4k.computer_guide.dao.Ram_questionDAO;
import com.veteroch4k.computer_guide.models.Ram_question;
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
  private Cpu_questionDAO cpu_questionDAO;

  @Autowired
  private Gpu_questionDAO gpu_questionDAO;

  @Autowired
  private Motherboard_questionDAO motherboard_questionDAO;

  @Autowired
  private Ram_questionDAO ram_questionDAO;


  /** ЦП **/

  @GetMapping("/cpu")
  public ModelAndView cpu(ModelAndView modelAndView) {
    modelAndView.addObject("title", "Центральный процессор");

    modelAndView.addObject("questions", cpu_questionDAO.getQuestions());
    modelAndView.addObject("variants", cpu_questionDAO.getVariants());

    modelAndView.addObject("type", cpu_questionDAO.getType());
    modelAndView.setViewName("testing-units/questions/central_processor");
    return modelAndView;

  }

  @PostMapping("/cpu/process-answers")
  public ResponseEntity<String> cpuAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);
    res = cpu_questionDAO.checkAnswers(answerValues);
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

    modelAndView.addObject("questions", gpu_questionDAO.getQuestions());
    modelAndView.addObject("variants", gpu_questionDAO.getVariants());

    modelAndView.addObject("type", gpu_questionDAO.getType());
    modelAndView.setViewName("testing-units/questions/graphic_card");
    return modelAndView;

  }

  @PostMapping("/gpu/process-answers")
  public ResponseEntity<String> gpuAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);
    res = gpu_questionDAO.checkAnswers(answerValues);
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

    modelAndView.addObject("questions", motherboard_questionDAO.getQuestions());
    modelAndView.addObject("variants", motherboard_questionDAO.getVariants());

    modelAndView.addObject("type", motherboard_questionDAO.getType());
    modelAndView.setViewName("testing-units/questions/motherboard");
    return modelAndView;

  }

  @PostMapping("/motherboard/process-answers")
  public ResponseEntity<String> motherboardAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);

    res = motherboard_questionDAO.checkAnswers(answerValues);
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

    modelAndView.addObject("questions", ram_questionDAO.getQuestions());
    modelAndView.addObject("variants", ram_questionDAO.getVariants());

    modelAndView.addObject("type", ram_questionDAO.getType());
    modelAndView.setViewName("testing-units/questions/ram");
    return modelAndView;

  }

  @PostMapping("/ram/process-answers")
  public ResponseEntity<String> ramAns(@RequestBody Map<Integer, String> answers, ModelAndView modelAndView) {
    List<String> answerValues = new ArrayList<>(answers.values());
    answerValues.remove(0);

    res = ram_questionDAO.checkAnswers(answerValues);
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

