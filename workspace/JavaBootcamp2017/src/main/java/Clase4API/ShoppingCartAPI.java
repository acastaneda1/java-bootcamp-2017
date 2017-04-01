package Clase4API;

import java.util.LinkedList;

public interface ShoppingCartAPI {

	/* 
	 * This method receive an Item and it is added to the shopping cart
	 */
	public void addItem(Item item);

	/*
	 * This method receive an Item and it is removed from the shopping cart if
	 * it already exist If the received item does not exist it shows a user
	 * error message
	 */
	public void removeItem(Item item);

	/*
	 * This method return all the items contained in the shopping cart, if the
	 * cart is empty, it shows a user error message
	 */
	public LinkedList<Item> getItems();

	/* 
	 * This method return the total of all the items' prices 
	 */
	public int resumeTotal();

	/* 
	 * This method removes all the items contained in the shopping cart 
	 */
	public void clearShoppingCart();

	/*
	 * This method use the rresumeTotal method and returns the total of the buy
	 */
	public int buy();
}
