package Clase1OPP.SingletonExample;

public class DBConnection {

	public static void main(String[] args) {
		SingletonExample singletonExample = SingletonExample.getInstance();

		singletonExample.DBConnect();
	}

}
