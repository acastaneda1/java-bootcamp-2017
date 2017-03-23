package Clase1OPP;

public class FactoryProducer {
	   public static AbstractFactory getFactory(){
	 
	         return new ConnectionFactory();
	      
	   }
}
