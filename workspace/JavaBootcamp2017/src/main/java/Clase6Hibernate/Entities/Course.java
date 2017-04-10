package Clase6Hibernate.Entities;

import java.util.HashSet;
import java.util.Set;

public class Course implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idCourse;
	private String courseName;
	private int hoursPerWeek;
	private Teacher assignedTeacher;
	private Set<Grades> grades = new HashSet<Grades>();
	private Set<ScheduleTime> schedule = new HashSet<ScheduleTime>();

	public Course() {

	}

	public Course(String name, int hours, Teacher teacher) {
		this.courseName = name;
		this.hoursPerWeek = hours;
		this.assignedTeacher = teacher;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setidCourse(int id) {
		this.idCourse = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String name) {
		this.courseName = name;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hours) {
		this.hoursPerWeek = hours;
	}

	public Teacher getAssignedTeacher() {
		return assignedTeacher;
	}

	public void setAssignedTeacher(Teacher teacher) {
		this.assignedTeacher = teacher;
	}

	public Set<ScheduleTime> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<ScheduleTime> scheduleTime) {
		this.schedule = scheduleTime;
	}

	public Set<Grades> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grades> grade) {
		this.grades = grade;
	}
}
