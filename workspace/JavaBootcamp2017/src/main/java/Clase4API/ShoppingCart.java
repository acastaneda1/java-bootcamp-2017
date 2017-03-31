package Clase4API;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart implements ShoppingCartAPI {

	private LinkedList<Item> shoppingCar;

	public ShoppingCart(){
		shoppingCar = new LinkedList<Item>();
	}

	@Override
 	 public void addItem(Item item) {
 		shoppingCar.add(item);
 	}

	@Override
	public void removeItem(Item item){
		
	}
	
	public void getItems(){
		
	}
	
	public boolean containItem(Item item){
		if(shoppingCar.contains(item))
			return true;
		else
			return false;
	}
	public void resumeTotal(){
		
	}
	
	public void clearShoppingCart(){
		
	}
	
	public void buy(){
		
	}
}