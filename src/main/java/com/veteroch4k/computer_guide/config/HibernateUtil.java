package com.veteroch4k.computer_guide.config;

import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
@EnableTransactionManagement
public class HibernateUtil {

  @Bean
  public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
    return new HiddenHttpMethodFilter();
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setPackagesToScan("com.veteroch4k.computer_guide");
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory.getObject());
    return transactionManager;
  }

  @Bean
  public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
    OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
    return interceptor;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    // Set Hibernate properties
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    // Other properties...
    return properties;
  }

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan("com.veteroch4k.computer_guide");

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    return em;
  }

}
