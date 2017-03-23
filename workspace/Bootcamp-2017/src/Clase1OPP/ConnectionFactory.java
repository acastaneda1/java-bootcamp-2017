package Clase1OPP;

public class ConnectionFactory extends AbstractFactory{
		
   public SQLConnection getConnectionSQL(String ConnectionType){
   
      if(ConnectionType == null){
         return null;
      }		
      
      if(ConnectionType.equalsIgnoreCase("SQLConnection1")){
         return new SQLConnection1();
         
      }else if(ConnectionType.equalsIgnoreCase("SQLConnection2")){
         return new SQLConnection2();
         
      }else if(ConnectionType.equalsIgnoreCase("SQLConnection3")){
         return new SQLConnection3();
      }
      
      return null;
   }
}
