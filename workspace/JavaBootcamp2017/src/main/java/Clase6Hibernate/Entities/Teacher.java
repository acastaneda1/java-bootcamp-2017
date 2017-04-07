package Clase6Hibernate.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idTeacher;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Set<Course> courses = new HashSet<Course>();

	public Teacher() {

	}

	public Teacher(String name, String surname, Date birthDate) {
		this.firstName = name;
		this.lastName = surname;
		this.dateOfBirth = birthDate;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int id) {
		this.idTeacher = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String surname) {
		this.lastName = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date birthDate) {
		this.dateOfBirth = birthDate;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> course) {
		this.courses = course;
	}
}
