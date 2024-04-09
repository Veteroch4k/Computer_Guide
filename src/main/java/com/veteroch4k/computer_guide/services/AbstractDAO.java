package com.veteroch4k.computer_guide.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractDAO<T> {

  private Class<T> clazz;

  @Autowired
  private SessionFactory sessionFactory;

  public AbstractDAO(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Long checkAnswers(List<String> ans) {
    return (Long) (sessionFactory.openSession().createQuery(
        "select count(*) from " + clazz.getSimpleName() + " u where u.answer in (:answers)", clazz))
        .setParameterList("answers", ans)
        .uniqueResult();
  }

  public List<T> getQuestions() {
    return sessionFactory.openSession()
        .createQuery("select u.question from " + clazz.getSimpleName() + " u ", clazz).list();
  }

  public List getVariants(int id) {

    List<String> texts = (List<String>) sessionFactory.openSession()
        .createQuery("SELECT JSON_UNQUOTE(JSON_EXTRACT(JSON_UNQUOTE(t.jsonVariants), '$[*].text')) AS text FROM " + clazz.getSimpleName() + " t WHERE t.id = :id", clazz)
        .setParameter("id", id)
        .list();

    List<String> cleanedTexts = new ArrayList<>();
    for (String text : texts) {
      String[] sentences = text.split(", ");
      cleanedTexts.addAll(Arrays.asList(sentences));
    }

    return cleanedTexts;

  }
}

