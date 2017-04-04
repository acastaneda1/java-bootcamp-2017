package Clase4API;

import Clase4API.ServiceImp.ShoppingCart;

public class ShoppingCartFactory {

	public ShoppingCartFactory() {

	}

	public static ShoppingCart getLocalShoppingCart() {
		return new ShoppingCart();
	}

}
