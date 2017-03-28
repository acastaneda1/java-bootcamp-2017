package Clase1OPP.AbstractFactoryExample;


public abstract class AbstractFactory {
	abstract SQLConnection getConnectionSQL(String ConnectionType);
	abstract NoSQLConnection getConnectionNoSQL(String ConnectionType);
}
