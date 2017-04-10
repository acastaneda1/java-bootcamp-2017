package Clase6Hibernate.DAO;

import java.util.List;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.Student;

public interface GradesDAO {

	public int createGrades(Student students, Course courses, int note1, int note2, int note3, int finalNote);

	public Grades getGradesbyId(int idGrades);

	public void updateGrades(Grades grades);

	public void deleteGrades(Grades grades);

	public int getPercentageOfCourseLoss();
	
	public int getPercentageOfAprovedStudents();
}
