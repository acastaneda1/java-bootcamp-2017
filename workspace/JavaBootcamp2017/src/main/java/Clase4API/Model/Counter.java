package Clase4API.Model;

public class Counter {
	private int count=0;
	private int idTransaction;
	
	public int getIDTransaction(){
		
		idTransaction=++count;
		setIdTransaction(idTransaction);
		return idTransaction;
	}
	
	public void setIdTransaction(int id){
		this.idTransaction = id;
	}

}
