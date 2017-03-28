package Clase1OPP.KeyPointProxy;

public class SlowAccessDB extends AccessDB{

	public SlowAccessDB() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
