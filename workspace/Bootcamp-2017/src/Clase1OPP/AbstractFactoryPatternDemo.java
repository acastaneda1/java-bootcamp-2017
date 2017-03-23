package Clase1OPP;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {

      //get Connection factory
      AbstractFactory ConnectionFactory = FactoryProducer.getFactory();

      //get an object of SQLConnection called SQLConnection1
      SQLConnection sql1 = ConnectionFactory.getConnectionSQL("SQLConnection1");

      //call connect method of SQLConnection1
      sql1.connect();

      //get an object of SQLConnection called SQLConnection2
      SQLConnection sql2 = ConnectionFactory.getConnectionSQL("SQLConnection2");

      //call connect method of SQLConnection2
      sql2.connect();
      
      //get an object of SQLConnection called SQLConnection3
      SQLConnection sql3 = ConnectionFactory.getConnectionSQL("SQLConnection3");

      //call connect method of SSQLConnection3
      sql3.connect();
	}

  }
