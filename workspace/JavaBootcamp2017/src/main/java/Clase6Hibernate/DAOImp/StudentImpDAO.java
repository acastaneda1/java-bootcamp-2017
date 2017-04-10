package Clase6Hibernate.DAOImp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.HibernateUtil;
import Clase6Hibernate.DAO.StudentDAO;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.Student;

public class StudentImpDAO implements StudentDAO {

	public StudentImpDAO() {

	}

	@Override
	public int createStudent(String name, String surname, int rn, Date birthDate) {
		int idStudent = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Student student = new Student(name, surname, rn, birthDate);
		idStudent = (int) session.save(student);
		transaction.commit();
		session.close();
		return idStudent;
	}

	@Override
	public List<Student>  getStudents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select s from Student s ";
		Query query = session.createQuery(hql);

		List<Student> students = query.list();
		for (Student datos : students) {
			System.out.println(datos.getFirstName() + " " + datos.getLastName());
		}
		transaction.commit();
		session.close();
		return students;
	}
	
	@Override
	public Student getStudent(int idStudent) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, idStudent);
		transaction.commit();
		session.close();
		if (student == null) {
			System.out.println("This student does not exist in the DB");
			return null;
		} else {
			System.out.println("This is the student selected: "+student.getFirstName()+" "+student.getLastName());
			return student;
		}

	}
	
	@Override
	public void updateStudent(Student student1) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		int idStudent = student1.getIdStudent();
		String name= student1.getFirstName();
		String surname = student1.getLastName();
		int rn = student1.getRegistrationNumber();
		Date birthDate = student1.getDateOfBirth();
		
		Student student = (Student) session.get(Student.class, idStudent);
		if (student == null) {
			System.out.println("This student does not exist in the DB");
		} else {
			student.setFirstName(name);
			student.setLastName(surname);
			student.setRegistrationNumber(rn);
			student.setDateOfBirth(birthDate);
			
			System.out.println("Student has been updated with name: " + student.getFirstName() + ", last name: " + student.getLastName()
					+ ", Registration number: " + student.getRegistrationNumber() + ", date of birth: " + student.getDateOfBirth());
		}
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteStudent(Student student1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int idStudent = student1.getIdStudent();
		Student student = (Student) session.get(Student.class, idStudent);
		if (student == null) {
			System.out.println("This student does not exist in the DB");
		} else {
			session.delete(student);
			System.out.println("This student has been deleted from the DB");
		}
		transaction.commit();
		session.close();
	}

}
