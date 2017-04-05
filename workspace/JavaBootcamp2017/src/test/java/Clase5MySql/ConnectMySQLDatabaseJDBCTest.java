package Clase5MySql;

public class ConnectMySQLDatabaseJDBCTest {

	public static void main(String[] args) throws Exception {
		ConnectMySQLDatabaseJDBC jdbcMySQLConnectionDAO = new ConnectMySQLDatabaseJDBC();
		jdbcMySQLConnectionDAO.getDataBaseConnection();
	}
}
