package Clase4API;

import java.util.LinkedList;

public interface ShoppingCartAPI {

	public void addItem(Item item);

	public void removeItem(Item item);

	public LinkedList<Item> getItems();

	public int resumeTotal();

	public void clearShoppingCart();

	public int buy();
}
