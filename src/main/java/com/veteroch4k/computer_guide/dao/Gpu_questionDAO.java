package com.veteroch4k.computer_guide.dao;

import com.veteroch4k.computer_guide.models.Cpu_question;
import com.veteroch4k.computer_guide.models.Gpu_question;
import com.veteroch4k.computer_guide.services.AbstractDAO;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class Gpu_questionDAO extends AbstractDAO {

  public Gpu_questionDAO() {
    super(Gpu_question.class);
  }

  @Override
  public Long checkAnswers(List ans) {
    return super.checkAnswers(ans);
  }

  @Override
  public List getQuestions() {
    return super.getQuestions();
  }

  @Override
  public Map<String, List<String>> getVariants() {
    return super.getVariants();
  }
}
