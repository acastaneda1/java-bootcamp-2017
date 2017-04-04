package Clase4API.Service;

import java.util.LinkedList;

import Clase4API.ServiceImp.Item;
import Clase4API.ServiceImp.User;

public interface Payment {

	/*
	 * This method receive an User, a shopping car with Items objects inside and
	 * the sum of item prices
	 */
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, double total);

	/*
	 * This method returns the total amount for each payment method
	 */
	public double getAmount();

	/*
	 * This method returns the unique identification number to each payment
	 * transaction
	 */
	public int getIdTransaction();
}
