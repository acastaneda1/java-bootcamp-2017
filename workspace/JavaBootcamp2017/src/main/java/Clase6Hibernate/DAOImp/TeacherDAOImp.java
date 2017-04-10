package Clase6Hibernate.DAOImp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.HibernateUtil;
import Clase6Hibernate.DAO.TeacherDAO;
import Clase6Hibernate.Entities.Teacher;

public class TeacherDAOImp implements TeacherDAO {

	public TeacherDAOImp() {

	}

	@Override
	public int createTeacher(String name, String surname, Date birthDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Teacher teacher = new Teacher(name, surname, birthDate);
		int idTeacher = (int) session.save(teacher);
		transaction.commit();
		session.close();
		return idTeacher;
	}

	@Override
	public List<Teacher> getTeachers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select t from Teacher t ";
		Query query = session.createQuery(hql);

		List<Teacher> teachers = query.list();
		for (Teacher datos : teachers) {
			System.out.println(datos.getFirstName() + " " + datos.getLastName());
		}
		transaction.commit();
		session.close();
		return teachers;
	}

	@Override
	public Teacher getTeacher(int idTeacher) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacher = (Teacher) session.get(Teacher.class, idTeacher);
		transaction.commit();
		session.close();
		if (teacher == null) {
			System.out.println("This teacher does not exist in the DB");
			return null;
		} else {
			System.out.println("This is the teacher selected: " + teacher.getFirstName() + " " + teacher.getLastName());
			return teacher;
		}
	}

	@Override
	public void updateTeacher(Teacher teacher1) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		int idTeacher = teacher1.getIdTeacher();
		String name = teacher1.getFirstName();
		String surname = teacher1.getLastName();
		Date birthDate = teacher1.getDateOfBirth();

		Teacher teacher = (Teacher) session.get(Teacher.class, idTeacher);
		if (teacher == null) {
			System.out.println("This teacher does not exist in the DB");
		} else {
			teacher.setFirstName(name);
			teacher.setLastName(surname);
			teacher.setDateOfBirth(birthDate);

			System.out.println("Teacher has been updated with name: " + teacher.getFirstName() + ", last name: " + teacher.getLastName()
					+ ", date of birth: " + teacher.getDateOfBirth());
		}
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteTeacher(Teacher teacher1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int idTeacher = teacher1.getIdTeacher();
		Teacher teacher = (Teacher) session.get(Teacher.class, idTeacher);
		if (teacher == null) {
			System.out.println("This teacher does not exist in the DB");
		} else {
			session.delete(teacher);
			System.out.println("This teacher has been deleted from the DB");
		}
		transaction.commit();
		session.close();
	}

}
