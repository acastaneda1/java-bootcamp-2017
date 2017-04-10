package Clase6Hibernate.DAO;

import java.util.Date;
import java.util.List;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Teacher;

public interface CourseDAO {

	public int createCourse(String name, int hours, Teacher teacher);

	public List<Course> getCourses();

	public Course getCourse(int idCourse);

	public void updateCourse(Course course);

	public void deleteCourse(Course course);
}
