package Clase1OPP.KeyPointProxy;
import java.util.Date;

public class Proxy {

	SlowAccessDB slowThing;

	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void showDateProxy() {
		if (slowThing == null) {
			slowThing = new SlowAccessDB();
		}
		slowThing.Access();
	}

}
