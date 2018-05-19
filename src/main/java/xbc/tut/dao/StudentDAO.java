package xbc.tut.dao;

import java.util.List;
import xbc.tut.model.Course;
import xbc.tut.model.Student;

public interface StudentDAO {

  int addStudent(Student Student);

  void updateStudent(Student student);

  void deleteStudent(Student student);

  Student getStudentById(int id);

  List<Student> getAllStudent();

}
