package Clase1OPP.BuilderExample;

public class MongoDBConnection implements DBConnectionBuilder{

	private DBConnection mongo;

	public MongoDBConnection() {
		mongo = new DBConnection();
	}

	public void buildLogIn() {
		mongo.SetUser("AngieCastaneda");
		mongo.SetPassword("pswmongo");
		mongo.SetDB("Mongo");
	}

	public DBConnection getConnection() {
		return mongo;
	}

}
