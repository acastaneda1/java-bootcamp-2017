package Clase1OPP;

public abstract class AbstractFactory {
	abstract SQLConnection getConnectionSQL(String ConnectionType);
}
