package com.veteroch4k.computer_guide.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional // Управляемая Spring транзакция
public abstract class AbstractDAO<T> {

  private Class<T> clazz;

  @Autowired
  private SessionFactory sessionFactory;

  @PersistenceContext
  private EntityManager entityManager;

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

  public List<String> getVariants(int id) {
    String sql = "SELECT jt.text FROM cpu_questions AS t, JSON_TABLE(t.variants, '$[*]' COLUMNS (text VARCHAR(255) PATH '$.text')) AS jt where t.id = 1";
    Query query = entityManager.createNativeQuery(sql);
    return query.getResultList();
  }
}

