package com.veteroch4k.computer_guide.dao;

import com.veteroch4k.computer_guide.models.Cpu_question;
import com.veteroch4k.computer_guide.services.AbstractDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class Cpu_questionDAO extends AbstractDAO {

  public Cpu_questionDAO() {
    super(Cpu_question.class);
  }

  @Override
  public Long checkAnswers(List ans) {
    return super.checkAnswers(ans);
  }
}
