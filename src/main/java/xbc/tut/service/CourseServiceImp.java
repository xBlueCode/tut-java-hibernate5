package xbc.tut.service;

import xbc.tut.dao.CourseDAO;
import xbc.tut.dao.CourseDAOImp;
import xbc.tut.model.Course;

import java.util.List;
import javax.transaction.Transactional;

//@Transactional
public class CourseServiceImp implements CourseService{

  private CourseDAO courseDAO ;

  public CourseServiceImp(){
    this.courseDAO = new CourseDAOImp() ;
  }

  @Override
  //@Transactional
  public int add(Course course) {
    return courseDAO.addCourse(course);
  }

  @Override
  //@Transactional
  public void update(Course course) {
    courseDAO.updateCourse(course);
  }

  @Override
  //@Transactional
  public void delete(Course course) {
    courseDAO.deleteCourse(course);
  }

  @Override
  //@Transactional
  public Course get(int id) {
    return courseDAO.getCourseById(id);
  }

  @Override
  //@Transactional
  public List<Course> getAll() {
    return courseDAO.getAllCourses();
  }

}
