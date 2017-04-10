package Clase6Hibernate.DAO;

import java.util.Date;
import java.util.List;

import Clase6Hibernate.Entities.Student;

public interface StudentDAO {

	public int createStudent(String name, String surname, int rn, Date birthDate);

	public List<Student> getStudents();

	public Student getStudent(int idStudent);

	public void updateStudent(Student student);

	public void deleteStudent(Student student);

}
