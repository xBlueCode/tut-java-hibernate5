package xbc.tut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id ;

  @Column(name = "course_label")
  private String courseLabel ;

  @Column(name = "volume")
  private String volume ;

  public Course(String courseLabel, String volume) {
    this.courseLabel = courseLabel;
    this.volume = volume;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCourseLabel() {
    return courseLabel;
  }

  public void setCourseLabel(String courseLabel) {
    this.courseLabel = courseLabel;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }
}
