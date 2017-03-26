package Clase1OPP.AbstractFactoryExample;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {

      //get SQL Connection factory
      AbstractFactory ConnectionFactory = FactoryProducer.getFactory("SQLConnection");

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

      //call connect method of SQLConnection3
      sql3.connect();
      
      //get NoSQL Connection factory
      AbstractFactory ConnectionFactoryNoSQL = FactoryProducer.getFactory("NoSQLConnection");

      //get an object of NoSQLConnection called NoSQLConnection1
      NoSQLConnection Nosql1 = ConnectionFactoryNoSQL.getConnectionNoSQL("NoSQLConnection1");

      //call connect method of NoSQLConnection1
      Nosql1.connect();

      //get an object of NoSQLConnection called NoSQLConnection2
      NoSQLConnection Nosql2 = ConnectionFactoryNoSQL.getConnectionNoSQL("NoSQLConnection2");

      //call connect method of NoSQLConnection2
      Nosql2.connect();
      
      //get an object of NoSQLConnection called NoSQLConnection3
      NoSQLConnection Nosql3 = ConnectionFactoryNoSQL.getConnectionNoSQL("NoSQLConnection3");

      //call connect method of NoSQLConnection3
      Nosql3.connect();
      
	}

  }
