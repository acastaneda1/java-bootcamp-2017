package Clase1OPP.BuilderExample;

public class DBConnection {

	private String user;
	private String password;
	private String dbactual;
	
	public String GetUser() {
		return user;
	}

	public void SetUser(String user) {
		this.user = user;
	}

	public String GetPassword() {
		return password;
	}

	public void SetPassword(String password) {
		this.password = password;
	}
	
	public String GetDB() {
		return dbactual;
	}

	public void SetDB(String dbactual) {
		this.dbactual = dbactual;
	}

	public String toString() {
		return "El usuario: " + user + ", se ha conectado a "+dbactual;
	}

}
