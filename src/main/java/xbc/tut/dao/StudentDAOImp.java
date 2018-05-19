package xbc.tut.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import xbc.tut.model.Course;
import xbc.tut.model.Student;
import xbc.tut.util.HibernateUtil;

public class StudentDAOImp implements StudentDAO{

  private SessionFactory sessionFactory ;

  public StudentDAOImp(){
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  @Override
  public int addStudent(Student student) {

    // open a session
    Session session = sessionFactory.openSession();

    // begin the transaction
    session.beginTransaction();
    // use the session to save the new element and return the generated ID
    int id = (int) session.save(student);
    // commit the transaction
    session.getTransaction().commit();
    // close the transaction
    session.close();

    return id;
  }

  @Override
  public void updateStudent(Student student) {

    // open a session
    Session session = sessionFactory.openSession();

    // begin the transaction
    session.beginTransaction();
    // use the session to update the new element
    session.update(student);
    // commit the transaction
    session.getTransaction().commit();
    // close the transaction
    session.close();

  }

  @Override
  public void deleteStudent(Student student) {

    // open a session
    Session session = sessionFactory.openSession();

    // begin the transaction
    session.beginTransaction();
    // use the session to delete the new element
    session.delete(student);
    // commit the transaction
    session.getTransaction().commit();
    // close the transaction
    session.close();

  }

  @Override
  public Student getStudentById(int id) {

    // open a session
    Session session = sessionFactory.openSession();

    // retrieve the persistent object (or null if not found)
    Student student = session.get(Student.class, id);

    // close the session
    session.close();

    return student;
  }

  @Override
  public List<Student> getAllStudent() {

    // open the session
    Session session = sessionFactory.openSession();

    // get CriteriaBuilder
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

    // create criteria
    CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
    criteriaQuery.from(Student.class);

    return session.createQuery(criteriaQuery).getResultList();
  }
}

