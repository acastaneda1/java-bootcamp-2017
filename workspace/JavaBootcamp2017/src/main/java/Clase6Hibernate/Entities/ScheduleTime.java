package Clase6Hibernate.Entities;

import java.sql.Time;

public class ScheduleTime implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idSchedule;
	private String day;
	private Time fromHour;
	private Time toHour;
	private Student student;
	private Course course;

	public ScheduleTime() {

	}

	public ScheduleTime(String days, Time fromHour, Time toHour, Student students, Course courses) {
		this.day = days;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.student = students;
		this.course = courses;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int id) {
		this.idSchedule = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String days) {
		this.day = days;
	}

	public Time getFromHour() {
		return fromHour;
	}

	public void setFromHour(Time fromHour) {
		this.fromHour = fromHour;
	}

	public Time getToHour() {
		return toHour;
	}

	public void setToHour(Time toHour) {
		this.toHour = toHour;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student students) {
		this.student = students;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course courses) {
		this.course = courses;
	}
}
