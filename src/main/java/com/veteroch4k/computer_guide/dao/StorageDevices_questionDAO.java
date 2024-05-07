package com.veteroch4k.computer_guide.dao;

import com.veteroch4k.computer_guide.models.CoolingSystem_question;
import com.veteroch4k.computer_guide.models.StorageDevices_question;
import com.veteroch4k.computer_guide.services.AbstractDAO;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDevices_questionDAO extends AbstractDAO {

  public StorageDevices_questionDAO() {
    super(StorageDevices_question.class);
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
