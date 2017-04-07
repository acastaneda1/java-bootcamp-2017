package Clase6Hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import Clase6Hibernate.Entities.Student;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import java.text.ParseException;

public class MainClass {

	public static void main(String[] args) throws ParseException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String inputString = "2016-01-01";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = dateFormat.parse(inputString);
		int idStudent;
		Student student = new Student("Desde", "Java", 1, inputDate);
		// idStudent = (int) session.save(student);
		
		String idcurso = "Juan";
		Query query = session.createQuery("SELECT  course FROM Grades ");

		System.out.println(query);
		List<Object> listDatos = query.list();
		for (Object datos : listDatos) {
			System.out.println(datos);
		}
		session.getTransaction().commit();
		session.close();

		HibernateUtil.shutdown();
	}
}
