package Clase6Hibernate.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idStudent;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private int registrationNumber;
	private Set<Grades> grades = new HashSet<Grades>(0);

	public Student() {

	}

	public Student(String name, String surname, int rn, Date birthDate) {
		this.firstName = name;
		this.lastName = surname;
		this.dateOfBirth = birthDate;
		this.registrationNumber = rn;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int id) {
		this.idStudent = id;
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

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int rn) {
		this.registrationNumber = rn;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date birthDate) {
		this.dateOfBirth = birthDate;
	}

	public Set<Grades> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grades> grade) {
		this.grades = grade;
	}

}
