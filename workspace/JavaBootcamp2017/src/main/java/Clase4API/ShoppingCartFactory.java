package Clase4API;

public class ShoppingCartFactory {
	
	public ShoppingCartFactory(){
		
	}
	
	public static ShoppingCart getLocalShoppingCart(){
		return new ShoppingCart();
	}

}
