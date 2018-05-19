package xbc.tut.dao;

import java.util.List;
import xbc.tut.model.Course;

public interface CourseDAO {

  int addCourse(Course course);

  void updateCourse(Course course);

  void deleteCourse(Course course);

  Course getCourseById(int id);

  List<Course> getAllCourses();

}
