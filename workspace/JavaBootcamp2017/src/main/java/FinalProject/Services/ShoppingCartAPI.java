package FinalProject.Services;

import java.util.LinkedList;

import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Entities.User;

public interface ShoppingCartAPI {
	/*
	 * This method receive an user and it is set in the shoppingCart object
	 */
	public void setCartUser(User user, int idShoppingCart);

	/*
	 * This method receive an user to create a new shoppingCart object in data
	 * base
	 */
	public int createShoppingCart(User user);

	/*
	 * This method receive the shopping cart id to delete it from data base
	 */
	public boolean deleteShoppingCart(int idShoppingCart);

	/*
	 * This method receive an Item and it is added to the shopping cart related
	 */
	public boolean addItem(Item item, int idShoppingCart);

	/*
	 * This method receive an Item and it is removed from the shopping cart if
	 * it already exist If the received item does not exist it shows a user
	 * error message
	 */
	public boolean removeItem(Item item, int idShoppingCart);

	/*
	 * This method return all the items contained in the shopping cart, if the
	 * cart is empty, it shows a user error message
	 */
	public LinkedList<ItemBag> getItems(int idShoppingCart);

	/*
	 * This method return the total of all the items' prices
	 */
	public double resumeTotal(int idShoppingCart);

	/*
	 * This method removes all the items contained in the shopping cart
	 */
	public boolean clearShoppingCart(int idShoppingCart);

	/*
	 * This method use the resumeTotal method and returns the total of the buy
	 * the Payment option is selected and implemented
	 */
	public double buy(Payment paymentOption, int idShoppingCart);
}
