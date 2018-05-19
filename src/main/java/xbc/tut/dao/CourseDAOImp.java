package xbc.tut.dao;

import java.util.List;
import javax.persistence.OrderColumn;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import xbc.tut.model.Course;
import xbc.tut.util.HibernateUtil;

@Transactional
public class CourseDAOImp implements CourseDAO{

  private SessionFactory sessionFactory ;

  public CourseDAOImp(){
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  @Override
  public int addCourse(Course course) {

    // open a session
    Session session = sessionFactory.openSession();

    // begin the transaction
    session.beginTransaction();
    // use the session to save the new element and return the generated ID
    int id = (int) session.save(course);
    // commit the transaction
    session.getTransaction().commit();
    // close the transaction
    session.close();

    return id;
  }

  @Override
  public void updateCourse(Course course) {
    // open hibernate session
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    session.update(course);

    session.getTransaction().commit();

    session.close();
  }

  @Override
  public void deleteCourse(Course course) {
    // open hibernate session
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    session.delete(course);

    session.getTransaction().commit();

    session.close();
  }

  @Override
  public Course getCourseById(int id) {
/*    // open hibernate session
    Session session = sessionFactory.openSession();

    Course course = session.get(Course.class, id);

    session.close();

    return course;
    */
    return sessionFactory
        .openSession()
        .get(Course.class, id) ;
  }

  @Override
  public List<Course> getAllCourses() {
    Session session = sessionFactory.openSession();

    CriteriaQuery<Course> criteriaQuery= session
        .getCriteriaBuilder()
        .createQuery(Course.class);

    criteriaQuery.from(Course.class);

    return session.createQuery(criteriaQuery).getResultList();
  }

}