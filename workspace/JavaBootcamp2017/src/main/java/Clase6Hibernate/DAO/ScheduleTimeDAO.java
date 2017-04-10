package Clase6Hibernate.DAO;

import java.sql.Time;
import java.util.List;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.Entities.Student;

public interface ScheduleTimeDAO {

	public int createScheduleTime(String days, Time fromHour, Time toHour, Student students, Course courses);

	public ScheduleTime getScheduleTime(int idScheduleTime);

	public List<ScheduleTime> getSchedulesTime();

	public void updateScheduleTime(ScheduleTime scheduleTime);

	public void deleteScheduleTime(ScheduleTime scheduleTime);
}
