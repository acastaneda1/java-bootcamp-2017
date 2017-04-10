package Clase6Hibernate.ServicesImp;

import Clase6Hibernate.Services.HighSchoolService;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.Teacher;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import Clase6Hibernate.DAO.CourseDAO;
import Clase6Hibernate.DAO.GradesDAO;
import Clase6Hibernate.DAO.ScheduleTimeDAO;
import Clase6Hibernate.DAO.StudentDAO;
import Clase6Hibernate.DAO.TeacherDAO;
import Clase6Hibernate.DAOImp.CourseDAOImp;
import Clase6Hibernate.DAOImp.GradesDAOImp;
import Clase6Hibernate.DAOImp.ScheduleTimeDAOImp;
import Clase6Hibernate.DAOImp.StudentImpDAO;
import Clase6Hibernate.DAOImp.TeacherDAOImp;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.ScheduleTime;

public class HighSchoolServiceImp implements HighSchoolService{
	
	StudentDAO studentDao = new StudentImpDAO();
	TeacherDAO teacherDao = new TeacherDAOImp();
	CourseDAO courseDAO = new CourseDAOImp();
	GradesDAO gradesDao = new GradesDAOImp();
	ScheduleTimeDAO scheduleDao = new ScheduleTimeDAOImp(); 
	
	public HighSchoolServiceImp(){
		
	}
	
	@Override
	public int createStudent(String name, String surname, int rn, Date birthDate){
		return studentDao.createStudent(name, surname, rn, birthDate);
	}

	@Override
	public List<Student> getStudents(){
		return studentDao.getStudents();
	}

	@Override
	public Student getStudent(int idStudent){
		return studentDao.getStudent(idStudent);
	}

	@Override
	public void updateStudent(Student student){
		studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Student student){
		studentDao.deleteStudent(student);
	}

	@Override
	public int createTeacher(String name, String surname, Date birthDate){
		return teacherDao.createTeacher(name, surname, birthDate);
	}

	@Override
	public List<Teacher> getTeachers(){
		return teacherDao.getTeachers();
	}

	@Override
	public Teacher getTeacher(int idTeacher){
		return teacherDao.getTeacher(idTeacher);
	}

	@Override
	public void updateTeacher(Teacher teacher){
		teacherDao.updateTeacher(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher){
		teacherDao.deleteTeacher(teacher);
	}

	@Override
	public int createCourse(String name, int hours, Teacher teacher){
		return courseDAO.createCourse(name, hours, teacher);
	}

	@Override
	public List<Course> getCourses(){
		return courseDAO.getCourses();
	}

	@Override
	public Course getCourse(int idCourse){
		return courseDAO.getCourse(idCourse);
	}

	@Override
	public void updateCourse(Course course){
		courseDAO.updateCourse(course);
	}

	@Override
	public void deleteCourse(Course course){
		courseDAO.deleteCourse(course);
	}

	@Override
	public int createGrades(Student students, Course courses, int note1, int note2, int note3, int finalNote){
		return gradesDao.createGrades(students, courses, note1, note2, note3, finalNote);
	}

	@Override
	public Grades getGradesbyId(int idGrades){
		return gradesDao.getGradesbyId(idGrades);
	}

	@Override
	public void updateGrades(Grades grades){
		gradesDao.updateGrades(grades);
	}

	@Override
	public void deleteGrades(Grades grades){
		gradesDao.deleteGrades(grades);
	}

	// @Override public List<Student> getStudentsThatFailedCourse(Course course);

	// @Override public List<Student> getStudentsThatPassedCourse(Course course);

	@Override
	public int createScheduleTime(String days, Time fromHour, Time toHour, Student students, Course courses){
		return scheduleDao.createScheduleTime(days, fromHour, toHour, students, courses);
	}

	@Override
	public ScheduleTime getScheduleTime(int idScheduleTime){
		return scheduleDao.getScheduleTime(idScheduleTime);
	}

	@Override
	public List<ScheduleTime> getSchedulesTime(){
		return scheduleDao.getSchedulesTime();
	}

	@Override
	public void updateScheduleTime(ScheduleTime scheduleTime){
		scheduleDao.updateScheduleTime(scheduleTime);
	}

	@Override
	public void deleteScheduleTime(ScheduleTime scheduleTime){
		scheduleDao.deleteScheduleTime(scheduleTime);
	}

}
