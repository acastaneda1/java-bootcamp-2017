package Clase5MySql;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConnectMySQLDatabaseJDBC {

	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;

	public void getDataBaseConnection() throws Exception {
		try {
			// Get the connection with DB
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/high_school", "root", "");

			// Get the data from database
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(
					"SELECT  CONCAT(`t`.first_name, ' ', `t`.last_name) AS teacher,	CONCAT(`s`.day,' ', `s`.from, ' - ', `s`.to, ': ', `c`.name) AS schedule FROM `course` AS `c` INNER JOIN `teacher` AS `t` ON (`c`.assigned_teacher = `t`.id_teacher) INNER JOIN `schedule_time` AS `s` ON (`c`.id_course = `s`.course) WHERE t.id_teacher = '2'ORDER BY `s`.course");
			formatResult(result);

		} catch (SQLException e) {
			System.out.println("Se produjo un error de MySQL: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.getStackTrace();
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void formatResult(ResultSet result) throws SQLException {
		String teacher = "";
		ArrayList schedule = new ArrayList();

		while (result.next()) {
			teacher = result.getString("Teacher");
			String schedulei = result.getString("Schedule");
			schedule.add(schedulei);
		}
		System.out.println("Teacher: " + teacher);
		System.out.println("Schedule: ");

		Iterator<String> it = schedule.iterator();
		while (it.hasNext()) {
			String element = it.next();
			System.out.print(element + " \n");
		}

	}

	private void close() {
		try {
			if (result != null) {
				result.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {

		}
	}

}
