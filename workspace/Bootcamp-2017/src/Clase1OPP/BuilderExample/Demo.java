package Clase1OPP.BuilderExample;

public class Demo {
	
	public static void main(String[] args) {

		DBConnectionBuilder ConnectionBuilder = new MongoDBConnection();
		DBConnectionDirector ConnectionDirector = new DBConnectionDirector(ConnectionBuilder);
		ConnectionDirector.constructConnection();
		DBConnection connection = ConnectionDirector.getConnection();
		System.out.println(connection);
		
		ConnectionBuilder = new SQLConnection();
		ConnectionDirector = new DBConnectionDirector(ConnectionBuilder);
		ConnectionDirector.constructConnection();
		connection = ConnectionDirector.getConnection();
		System.out.println(connection);
	}

}
