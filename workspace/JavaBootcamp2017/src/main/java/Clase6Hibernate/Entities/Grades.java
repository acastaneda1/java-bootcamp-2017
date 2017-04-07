package Clase6Hibernate.Entities;

public class Grades implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idGrade;
	private Student student;
	private Course course;
	private int partialNote1;
	private int partialNote2;
	private int partialNote3;
	private int finalExam;

	public Grades() {

	}

	public Grades(Student students, Course courses, int note1, int note2, int note3, int finalNote) {
		this.student = students;
		this.course = courses;
		this.partialNote1 = note1;
		this.partialNote2 = note2;
		this.partialNote3 = note3;
		this.finalExam = finalNote;
	}

	public int getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(int id) {
		this.idGrade = id;
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

	public int getPartialNote1() {
		return partialNote1;
	}

	public void setPartialNote1(int note1) {
		this.partialNote1 = note1;
	}
	
	public int getPartialNote2() {
		return partialNote2;
	}

	public void setPartialNote2(int note2) {
		this.partialNote2 = note2;
	}
	
	public int getPartialNote3() {
		return partialNote3;
	}

	public void setPartialNote3(int note3) {
		this.partialNote3 = note3;
	}
	
	public int getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(int finalNote) {
		this.finalExam = finalNote;
	}
}
