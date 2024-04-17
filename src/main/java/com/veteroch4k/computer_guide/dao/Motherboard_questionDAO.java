package com.veteroch4k.computer_guide.dao;

import com.veteroch4k.computer_guide.models.Cpu_question;
import com.veteroch4k.computer_guide.models.Motherboard_question;
import com.veteroch4k.computer_guide.services.AbstractDAO;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class Motherboard_questionDAO extends AbstractDAO {

  public Motherboard_questionDAO() {
    super(Motherboard_question.class);
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
