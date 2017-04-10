package Clase6Hibernate.DAOImp;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Teacher;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.HibernateUtil;
import Clase6Hibernate.DAO.CourseDAO;

public class CourseDAOImp implements CourseDAO {

	public CourseDAOImp() {

	}

	@Override
	public int createCourse(String name, int hours, Teacher teacher) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Course course = new Course(name, hours, teacher);
		int idCourse = (int) session.save(course);
		transaction.commit();
		session.close();
		return idCourse;
	}

	@Override
	public List<Course> getCourses() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select c from Course c ";
		Query query = session.createQuery(hql);

		List<Course> courses = query.list();
		for (Course datos : courses) {
			System.out.println(datos.getCourseName());
		}
		transaction.commit();
		session.close();
		return courses;
	}

	@Override
	public Course getCourse(int idCourse) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Course course = (Course) session.get(Course.class, idCourse);
		transaction.commit();
		session.close();
		if (course == null) {
			System.out.println("This course does not exist in the DB");
			return null;
		} else {
			System.out.println("This is the course selected: " + course.getCourseName());
			return course;
		}
	}

	@Override
	public void updateCourse(Course course1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		int idCourse = course1.getIdCourse();
		String name = course1.getCourseName();
		Teacher teacher = course1.getAssignedTeacher();
		int hours = course1.getHoursPerWeek();

		Course course = (Course) session.get(Course.class, idCourse);
		if (course == null) {
			System.out.println("This course does not exist in the DB");
		} else {
			course.setAssignedTeacher(teacher);
			course.setCourseName(name);
			course.setHoursPerWeek(hours);
			System.out.println("Course has been updated with name: " + course.getCourseName() + ", hours per week: " + course.getHoursPerWeek()
					+ " and teacher: " + course.getAssignedTeacher().getFirstName()+ " " +course.getAssignedTeacher().getLastName());
		}
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteCourse(Course course1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int idCourse = course1.getIdCourse();
		Course course = (Course) session.get(Course.class, idCourse);
		if (course == null) {
			System.out.println("This course does not exist in the DB");
		} else {
			session.delete(course);
			System.out.println("This course has been deleted from the DB");
		}
		transaction.commit();
		session.close();
	}
}
