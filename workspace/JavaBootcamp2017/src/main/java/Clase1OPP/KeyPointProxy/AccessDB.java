package Clase1OPP.KeyPointProxy;
import java.util.Date;

public abstract class AccessDB {
	
	public void Access() {
		System.out.println(this.getClass().getSimpleName() + " accessing at " + new Date());
	}

}
