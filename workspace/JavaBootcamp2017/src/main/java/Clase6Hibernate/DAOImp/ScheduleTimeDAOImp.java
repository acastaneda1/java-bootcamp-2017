package Clase6Hibernate.DAOImp;

import java.sql.Time;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.HibernateUtil;
import Clase6Hibernate.DAO.ScheduleTimeDAO;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.Teacher;

public class ScheduleTimeDAOImp implements ScheduleTimeDAO{

	public ScheduleTimeDAOImp(){
		
	}
	
	@Override
	public int createScheduleTime(String days, Time fromHour, Time toHour, Student students, Course courses){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		ScheduleTime schedule = new ScheduleTime(days, fromHour, toHour, students, courses);
		System.out.println(schedule.getToHour());
		int idSchedule = (int) session.save(schedule);
		transaction.commit();
		session.close();
		return idSchedule;
	}

	@Override
	public ScheduleTime getScheduleTime(int idScheduleTime){
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ScheduleTime scheduleTime = (ScheduleTime) session.get(ScheduleTime.class, idScheduleTime);
		transaction.commit();
		session.close();
		if (scheduleTime == null) {
			System.out.println("These schedule does not exist in the DB");
		} else {
			System.out.println("These are the schedule selected for the course: " + scheduleTime.getCourse().getCourseName() + " en el horario: "
					+scheduleTime.getDay()+" "+scheduleTime.getFromHour()+" - "+ scheduleTime.getToHour());
		}
		return scheduleTime;
	}

	@Override
	public List<ScheduleTime> getSchedulesTime(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select s from ScheduleTime s ";
		Query query = session.createQuery(hql);

		List<ScheduleTime> schedule = query.list();
		for (ScheduleTime datos : schedule) {
			System.out.println(datos.getCourse().getCourseName()+": " +datos.getDay()+" "+
					datos.getFromHour()+ " - "+datos.getToHour());
		}
		transaction.commit();
		session.close();
		return schedule;
	}

	@Override
	public void updateScheduleTime(ScheduleTime scheduleTime1){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		int idSchedule = scheduleTime1.getIdSchedule();
		Course course = scheduleTime1.getCourse();
		String day = scheduleTime1.getDay();
		Time from = scheduleTime1.getFromHour();
		Time to = scheduleTime1.getToHour();
		Student student = scheduleTime1.getStudent();

		ScheduleTime scheduleTime = (ScheduleTime) session.get(ScheduleTime.class, idSchedule);
		if (scheduleTime == null) {
			System.out.println("This course does not exist in the DB");
		} else {
			scheduleTime.setCourse(course);
			scheduleTime.setStudent(student);
			scheduleTime.setDay(day);
			scheduleTime.setFromHour(from);
			scheduleTime.setToHour(to);

			System.out.println("Schedule timefor the course: "+ scheduleTime.getCourse().getCourseName()+
					", has been updated with day: " + scheduleTime.getDay()+ ", from: " + scheduleTime.getFromHour()
					+ " to: " + scheduleTime.getToHour());
		}
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteScheduleTime(ScheduleTime scheduleTime1){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int idSchedule = scheduleTime1.getIdSchedule();
		ScheduleTime schedule = (ScheduleTime) session.get(ScheduleTime.class, idSchedule);
		if (schedule == null) {
			System.out.println("This schedule does not exist in the DB");
		} else {
			session.delete(schedule);
			System.out.println("This schedule has been deleted from the DB");
		}
		transaction.commit();
		session.close();
	}
}
