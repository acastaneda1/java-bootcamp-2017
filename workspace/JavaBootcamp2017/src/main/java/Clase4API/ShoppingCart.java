package Clase4API;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ShoppingCart implements ShoppingCartAPI {

	private LinkedList<Item> shoppingCar;

	public ShoppingCart() {
		shoppingCar = new LinkedList<Item>();
	}

	@Override
	public void addItem(Item item) {
		shoppingCar.add(item);
	}

	@Override
	public void removeItem(Item item) {
		if (shoppingCar.contains(item))
			shoppingCar.remove(item);
		else
			System.out.println("El item seleccionado no se encuentra en su carrito de compras");
	}

	public LinkedList<Item> getItems() {
		if (shoppingCar.isEmpty())
			System.out.println("El carrito está vacio");
		return shoppingCar;

	}

	
	public boolean containItem(Item item) {
		if (shoppingCar.contains(item))
			return true;
		else
			return false;
	}

	@Override
	public int resumeTotal() {

		int totalPrice = 0;
		Iterator<Item> it = getItems().listIterator();
		while (it.hasNext()) {
			Item item = it.next();
			totalPrice += item.getItemPrice();
		}
		return totalPrice;
	}

	@Override
	public void clearShoppingCart() {
		shoppingCar.clear();
	}

	@Override
	public int buy() {

		int totalPrice = resumeTotal();
		/*
		 * Iterator<Item> it = getItems().listIterator(); while (it.hasNext()) {
		 * Item item = it.next(); System.out.println(item.getItemId() + " " +
		 * item.getItemDescription() + " " + item.getItemPrice()); }
		 */

		System.out.println("El precio a pagar es :" + totalPrice);
		return totalPrice;
	}
}