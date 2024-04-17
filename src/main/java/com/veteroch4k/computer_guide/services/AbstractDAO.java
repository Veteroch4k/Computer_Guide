package com.veteroch4k.computer_guide.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.hibernate.Session;
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
    Long res = 0L;
    Session session = sessionFactory.openSession();
    try {
      for(int i = 0; i < ans.size(); i++) {
        Query query = session.createQuery(
                "select count(*) from " + clazz.getSimpleName() + " u where u.id = :id and u.answer = :answer")
            .setParameter("id", i + 1)  // Строгое сравнение ответа с соответствующей строкой в таблице
            .setParameter("answer", ans.get(i));  // Ответ из списка
        res += (Long) ((org.hibernate.query.Query<?>) query).uniqueResult();
      }
    } finally {
      session.close();
    }
    return res;
  }

  public List<T> getQuestions() {
    return sessionFactory.openSession()
        .createQuery("select u.question from " + clazz.getSimpleName() + " u ", clazz).list();
  }
  public List<T> getType() {
    return sessionFactory.openSession()
        .createQuery("select t.type from " + clazz.getSimpleName() + " t", clazz)
        .list();
  }

  public Map<Integer, List<String>> getVariants() {
    Map<Integer, List<String>> var = new HashMap<>();
    int n = Math.toIntExact(getRows());
    String tableName = clazz.getSimpleName().toLowerCase() + "s";
    for(int i = 1; i <= n; i++) {
      String sql = "SELECT jt.text FROM " + tableName + " AS t, "
          + "JSON_TABLE(t.variants, '$[*]' COLUMNS (text VARCHAR(255) PATH '$.text')) "
          + "AS jt where t.id = :id";
      Query query = entityManager.createNativeQuery(sql);
      query.setParameter("id", i);
      var.put(i, query.getResultList());
    }

    return var;
  }

  private Long getRows() {
    return (Long) sessionFactory.openSession().createQuery("select count(*) from " + clazz.getSimpleName(), clazz).uniqueResult();
  }

}

