package Clase1OPP.BuilderExample;

public class DBConnectionDirector {

	private DBConnectionBuilder ConnectionBuilder = null;

	public DBConnectionDirector(DBConnectionBuilder ConnectionBuilder) {
		this.ConnectionBuilder = ConnectionBuilder;
	}

	public void constructConnection() {
		ConnectionBuilder.buildLogIn();
	}

	public DBConnection getConnection() {
		return ConnectionBuilder.getConnection();
	}

}
