package com.veteroch4k.computer_guide.services;

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
    return (Long) (sessionFactory.openSession().createQuery("select count(*) from " +  clazz.getSimpleName() + " u where u.answer in (:answers)", clazz))
        .setParameterList("answers", ans)
        .uniqueResult();
  }

  public List<T> findAll() {
    return sessionFactory.openSession().createQuery("from " + clazz.getSimpleName(), clazz).list();
  }

}
