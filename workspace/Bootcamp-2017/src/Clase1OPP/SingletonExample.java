package Clase1OPP;

public class SingletonExample {

	private static SingletonExample singletonExample = null;

	private SingletonExample() {
	}

	public static SingletonExample getInstance() {
		if (singletonExample == null) {
			singletonExample = new SingletonExample();
		}
		return singletonExample;
	}

	public void DBConnect() {
		System.out.println("Conectado");
	}
	
}
