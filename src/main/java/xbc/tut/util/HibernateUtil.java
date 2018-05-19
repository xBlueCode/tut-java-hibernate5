package xbc.tut.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {

    try {
      // create the sessionFactory from hibernate.cfg.xml
      return new Configuration().configure().buildSessionFactory();
    }
    catch (Throwable ex){
      ex.printStackTrace();
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory(){
    return sessionFactory;
  }
}