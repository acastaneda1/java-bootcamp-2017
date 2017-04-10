package Clase6Hibernate.DAOImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.HibernateUtil;
import Clase6Hibernate.DAO.GradesDAO;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.Teacher;

public class GradesDAOImp implements GradesDAO{
	
	public GradesDAOImp(){
		
	}
	
	@Override
	public int createGrades(Student students, Course courses, int note1, int note2, int note3, int finalNote){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Grades grades = new Grades(students, courses, note1, note2, note3, finalNote);
		int idGrades = (int) session.save(grades);
		transaction.commit();
		session.close();
		return idGrades;
	}

	@Override
	public Grades getGradesbyId(int idGrades){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Grades grades = (Grades) session.get(Grades.class, idGrades);
		transaction.commit();
		session.close();
		if (grades == null) {
			System.out.println("These grades does not exist in the DB");
		} else {
			System.out.println("These are the grades selected for student: " + grades.getStudent().getFirstName() + " "
					+grades.getStudent().getLastName()+", from the course: "+grades.getCourse().getCourseName());
		}
		return grades;
	}

	@Override
	public void updateGrades(Grades grades1){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = grades1.getStudent();
		Course course = grades1.getCourse();
		int idGrades = grades1.getIdGrade();
		int note1 = grades1.getPartialNote1();
		int note2 = grades1.getPartialNote2();
		int note3 = grades1.getPartialNote3();
		int finalExam = grades1.getFinalExam();
		
		Grades grades = (Grades) session.get(Grades.class, idGrades);
		if (grades == null) {
			System.out.println("These grades does not exist in the DB");
		} else {
			grades.setCourse(course);
			grades.setStudent(student);
			grades.setPartialNote1(note1);
			grades.setPartialNote2(note2);
			grades.setPartialNote3(note3);
			grades.setFinalExam(finalExam);

			System.out.println("Grades has been updated to the Student: " + grades.getStudent().getFirstName()+" "+ grades.getStudent().getLastName() 
					+ ", in the course: " + grades.getCourse().getCourseName()
					+ " and notes are: note1:" + grades.getPartialNote1()
					+", note2: "+grades.getPartialNote2()+", note3:"+grades.getPartialNote3());
		}
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteGrades(Grades grades1){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int idGrades = grades1.getIdGrade();
		Grades grades = (Grades) session.get(Grades.class, idGrades);
		if (grades == null) {
			System.out.println("These grades does not exist in the DB");
		} else {
			session.delete(grades);
			System.out.println("These grades has been deleted from the DB");
		}
		transaction.commit();
		session.close();
	}

	public int getGradesFromCourse(int idCourse){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql ="select  g from Grades g join g.course c where c.idCourse= :course";
		Query query = session.createQuery( hql ,Grades.class ).setParameter("course",idCourse);
		List<Student> students = query.list();
		transaction.commit();
		session.close();
		return students.size();
	}
	
	@Override
	public int getPercentageOfCourseLoss(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql ="select  g from Grades g join g.student s join g.course c where c.idCourse= :course and g.finalExam <= 6";
		int idCourse = 2;
		Query query = session.createQuery( hql ,Grades.class ).setParameter("course",idCourse);
		List<Student> students = query.list();
		int courseStudents = getGradesFromCourse(idCourse);
		int lossPercentage = students.size()*100/courseStudents;
		transaction.commit();
		session.close();
		System.out.println("The percentage of students that failed the course is: "+lossPercentage+"%");
		return lossPercentage;	
	}
	
	@Override
	public int getPercentageOfAprovedStudents(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql ="select  g from Grades g join g.student s join g.course c where c.idCourse= :course and g.finalExam > 6";
		int idCourse = 2;
		Query query = session.createQuery( hql ,Grades.class ).setParameter("course",idCourse);
		List<Student> students = query.list();
		int courseStudents = getGradesFromCourse(idCourse);
		int AprovedPercentage = students.size()*100/courseStudents;
		transaction.commit();
		session.close();
		System.out.println("The percentage of students that passed the course is: "+AprovedPercentage+"%");
		return AprovedPercentage;	
	}
}
