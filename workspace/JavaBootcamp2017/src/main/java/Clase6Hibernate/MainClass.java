package Clase6Hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.osgi.service.log.LogEntry;

import Clase6Hibernate.DAOImp.StudentImpDAO;
import Clase6Hibernate.DAOImp.TeacherDAOImp;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.Teacher;
import Clase6Hibernate.Services.HighSchoolServiceFactory;
import Clase6Hibernate.ServicesImp.HighSchoolServiceImp;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import java.text.ParseException;

public class MainClass {

	public static void main(String[] args) throws ParseException {

		HighSchoolServiceImp hs = HighSchoolServiceFactory.getService();
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "select g.course.courseName, sum(g.student) from Grades g join g.course where g.finalExam>6 and g.course.idCourse='1'";
		Query query = session.createQuery(hql);

		List<Grades> Gades = query.list();
		System.out.println(Gades);*/
		// for (Grades datos : Gades) {
		// System.out.println(datos);
		// }
		// session.getTransaction().commit();
		// session.close();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date bithDate = dateFormat.parse("2016-01-01");

		int idStudent1 = hs.createStudent("Desde", "Java", 2, bithDate);

		hs.getStudents();

		Student studentExample = hs.getStudent(17);
		studentExample.setFirstName("desde updated");
		hs.updateStudent(studentExample);		

		int idTeacher1 = hs.createTeacher("Desde", "Java", bithDate);

		hs.getTeachers();

		Teacher teacherExample = hs.getTeacher(5);
		teacherExample.setLastName("javala");
		hs.updateTeacher(teacherExample);
		
		int IdCourse1 = hs.createCourse("Bootcamp Java", 5, teacherExample);
		
		hs.getCourses();
		
		Course courseExample = hs.getCourse(4);
		courseExample.setCourseName("Bootcamp updated");

		hs.updateCourse(courseExample);
		
		hs.createGrades(studentExample, courseExample, 5, 6, 8, 7);
		
		Grades gradesExample = hs.getGradesbyId(34);
		gradesExample.setPartialNote1(6);
		hs.updateGrades(gradesExample);
		
		Time fromHour = Time.valueOf("08:00:00");
		Time toHour = Time.valueOf("10:00:00");
		
		hs.createScheduleTime("Monday", fromHour, toHour, studentExample, courseExample);
		
		hs.getSchedulesTime();
		ScheduleTime scheduleExample = hs.getScheduleTime(7);
		scheduleExample.setDay("Tuesday"); 
		hs.updateScheduleTime(scheduleExample);
		
		hs.deleteScheduleTime(scheduleExample);
		hs.deleteGrades(gradesExample);
		hs.deleteCourse(courseExample);
		hs.deleteStudent(studentExample);
		hs.deleteTeacher(teacherExample);
		
		
		HibernateUtil.shutdown();
	}
}
