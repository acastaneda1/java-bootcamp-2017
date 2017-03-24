package Clase1OPP.KeyPointProxy;

public class ProxyDemo {

	public static void main(String[] args) {

		// Create a Proxy object   
		Proxy proxy = new Proxy();

		//Create a FastAccessDB object 
		FastAccessDB fastThing = new FastAccessDB();
		
		//Call Access() on the FastAccessDB object
		fastThing.Access();

		//Call showDateProxy on the Proxy object that continues with Access() 
		//on the SlowAccessDB object 
		proxy.showDateProxy();

	}

}
