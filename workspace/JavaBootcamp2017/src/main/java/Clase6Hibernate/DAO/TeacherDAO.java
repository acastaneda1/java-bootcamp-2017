package Clase6Hibernate.DAO;

import java.util.Date;
import java.util.List;

import Clase6Hibernate.Entities.Teacher;

public interface TeacherDAO {

	public int createTeacher(String name, String surname, Date birthDate);

	public List<Teacher> getTeachers();

	public Teacher getTeacher(int idTeacher);

	public void updateTeacher(Teacher teacher);

	public void deleteTeacher(Teacher teacher);
}
