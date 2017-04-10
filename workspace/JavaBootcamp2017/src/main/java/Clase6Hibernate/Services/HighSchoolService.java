package Clase6Hibernate.Services;

import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.Teacher;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Grades;
import Clase6Hibernate.Entities.ScheduleTime;

public interface HighSchoolService {

	/*
	 * This method receive all data to create a new student (name, last name,
	 * registration number and date of birth) and it is persist in the DB. It
	 * returns the idStudent which was saved, it is a integer value.
	 */
	public int createStudent(String name, String surname, int rn, Date birthDate);

	/*
	 * This method returns a List of Student objects with all the students in
	 * the DB
	 */
	public List<Student> getStudents();

	/*
	 * This method receive the student id and returns a Student object with all
	 * information saved in the DB
	 */
	public Student getStudent(int idStudent);

	/*
	 * This method receive a Student object and it update the new information of
	 * the selected student in the DB
	 */
	public void updateStudent(Student student);

	/*
	 * This method receive a Student object and delete it from the DB
	 */
	public void deleteStudent(Student student);

	/*
	 * This method receive all data to create a new teacher (name, last name and
	 * date of birth) and it is saved in the DB. It returns the idTeacher which
	 * was saved, it is a integer value.
	 */
	public int createTeacher(String name, String surname, Date birthDate);

	/*
	 * This method returns a List of Teachers objects with all the teachers in
	 * the DB
	 */
	public List<Teacher> getTeachers();

	/*
	 * This method receive the teacher id and returns a teacher object with all
	 * information saved in the DB
	 */
	public Teacher getTeacher(int idTeacher);

	/*
	 * This method receive a teacher object and it update the new information of
	 * the selected teacher in the DB
	 */
	public void updateTeacher(Teacher teacher);

	/*
	 * This method receive a teacher object and delete it from the DB
	 */
	public void deleteTeacher(Teacher teacher);

	/*
	 * This method receive all data to create a new course (course name, hours
	 * per week and teacher assigned) and it is saved in the DB. It returns the
	 * idCourse which was saved, it is a integer value.
	 */
	public int createCourse(String name, int hours, Teacher teacher);

	/*
	 * This method returns a list of course objects with all the courses in the
	 * DB
	 */
	public List<Course> getCourses();

	/*
	 * This method receive the course id and returns a course object with all
	 * information saved in the DB
	 */
	public Course getCourse(int idCourse);

	/*
	 * This method receive a course object and it update the new information of
	 * the selected course in the DB
	 */
	public void updateCourse(Course course);

	/*
	 * This method receive a course object and delete it from the DB
	 */
	public void deleteCourse(Course course);

	/*
	 * This method receive all data to create a new grades (student, course,
	 * every partial note and final exam) and it is saved in the DB. It returns
	 * the idGrades which was saved, it is a integer value.
	 */
	public int createGrades(Student students, Course courses, int note1, int note2, int note3, int finalNote);

	/*
	 * This method receive the grades id and returns a grades object with all
	 * information saved in the DB
	 */
	public Grades getGradesbyId(int idGrades);

	/*
	 * This method receive a grades object and it update the new information of
	 * the selected grade in the DB
	 */
	public void updateGrades(Grades grades);

	/*
	 * This method receive a grades object and delete it from the DB
	 */
	public void deleteGrades(Grades grades);

	/*
	 * This method receive a course object and returns a list of student objects
	 * with all the courses in the DB
	 */
	// public List<Student> getStudentsThatFailedCourse(Course course);

	// public List<Student> getStudentsThatPassedCourse(Course course);

	/*
	 * This method receive all data to create a new schedule (course, student,
	 * day, hour to starts and hour to finish) and it is saved in the DB. It
	 * returns the idSchedule which was saved, it is a integer value.
	 */
	public int createScheduleTime(String days, Time fromHour, Time toHour, Student students, Course courses);

	/*
	 * This method receive the schedule id and returns a ScheduleTime object
	 * with all information saved in the DB
	 */
	public ScheduleTime getScheduleTime(int idScheduleTime);

	/*
	 * This method returns a list of schedule time objects with all the
	 * schedules in the DB
	 */
	public List<ScheduleTime> getSchedulesTime();

	/*
	 * This method receive a ScheduleTime object and it update the new
	 * information of the selected schedule in the DB
	 */
	public void updateScheduleTime(ScheduleTime scheduleTime);

	/*
	 * This method receive a ScheduleTime object and delete it from the DB
	 */
	public void deleteScheduleTime(ScheduleTime scheduleTime);
}
