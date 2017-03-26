package Clase1OPP.AbstractFactoryExample;

public class ConnectionFactoryNoSQL extends AbstractFactory{
	
	public NoSQLConnection getConnectionNoSQL(String ConnectionType){
		   
      if(ConnectionType == null){
         return null;
      }		
      
      if(ConnectionType.equalsIgnoreCase("NoSQLConnection1")){
         return new NoSQLConnection1();
         
      }else if(ConnectionType.equalsIgnoreCase("NoSQLConnection2")){
         return new NoSQLConnection2();
         
      }else if(ConnectionType.equalsIgnoreCase("NoSQLConnection3")){
         return new NoSQLConnection3();
      }  
      return null;
	}
	
	SQLConnection getConnectionSQL(String ConnectionType) {
	      return null;
	}
}
