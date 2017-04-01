package Clase4API;

import java.util.LinkedList;

public interface Payment {

	/*
	 * This method receive an User, a shopping car with Items objects inside and
	 * the sum of item prices
	 */
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, int total);
}
