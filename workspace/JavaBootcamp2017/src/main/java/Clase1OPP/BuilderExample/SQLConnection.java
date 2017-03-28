package Clase1OPP.BuilderExample;

public class SQLConnection implements DBConnectionBuilder{

		private DBConnection sql;

		public SQLConnection() {
			sql = new DBConnection();
		}

		public void buildLogIn() {
			sql.SetUser("AngieCastaneda");
			sql.SetPassword("pswSQL");
			sql.SetDB("SQL");
		}

		public DBConnection getConnection() {
			return sql;
		}

}
