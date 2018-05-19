package xbc.tut.dao;

import java.util.List;
import xbc.tut.model.Course;

public interface CourseDAO {

  boolean addCourse(Course course);

  boolean updateCourse(Course course);

  boolean deleteCourse(Course course);

  Course getCourseById(int id);

  List<Course> getAllCourses();

}
