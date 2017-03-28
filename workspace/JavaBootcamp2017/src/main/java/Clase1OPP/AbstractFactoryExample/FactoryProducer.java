package Clase1OPP.AbstractFactoryExample;

public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
	   if(choice.equalsIgnoreCase("SQLConnection")){
	         return new ConnectionFactory();
	   }else if(choice.equalsIgnoreCase("NoSQLConnection")){
         return new ConnectionFactoryNoSQL();
	   }
	   return null;
   }
}
