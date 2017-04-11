package Clase4API.ServiceImp;

import java.util.LinkedList;
import java.util.List;

import Clase4API.Model.Item;
import Clase4API.Model.Offer;
import Clase4API.Model.User;
import Clase4API.Service.Payment;
import Clase4API.Service.ShoppingCartAPI;

import java.util.Iterator;


public class ShoppingCart implements ShoppingCartAPI {

	private LinkedList<Item> shoppingCar;
	private User user;

	public ShoppingCart() {
		shoppingCar = new LinkedList<Item>();
	}

	@Override
	public void setCartUser(User userA) {
		this.user = userA;
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
	public double resumeTotal() {

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
	public double buy(Payment paymentOption) {

		double totalPrice = 0;
		double subtotal = resumeTotal();
		System.out.println("El precio a pagar es: " + subtotal);
		
		boolean success = paymentOption.buyNow(user, shoppingCar, subtotal);

		if (!success)
			System.out.println("La compra no puedo ser realizada por el metodo seleccionado");
		else {
			totalPrice = paymentOption.getAmount();
			System.out.println("Por ende el valor final de su compra fue: " + totalPrice);
		}
		
		return totalPrice;
	}
	
	@Override
	public String formatItems(){
		Iterator<Item> it = shoppingCar.iterator();
		String itemString = null;
		StringBuilder stringItem = new StringBuilder();
		while (it.hasNext()) {
			Item item = it.next();
			stringItem.append("-");
			stringItem.append(item.getItemDescription());
			stringItem.append(" ........$");
			stringItem.append(item.getItemPrice());
			stringItem.append(System.getProperty("line.separator"));
		}
		itemString = stringItem.toString();
		System.out.println(itemString);
		return itemString;
	}
	
}