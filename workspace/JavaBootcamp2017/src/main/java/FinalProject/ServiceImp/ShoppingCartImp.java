package FinalProject.ServiceImp;

import java.util.Iterator;
import java.util.LinkedList;

import FinalProject.Entities.Item;
import FinalProject.Entities.User;
import FinalProject.Entities.ItemBag;
import FinalProject.Services.Payment;
import FinalProject.Services.ShoppingCartAPI;

public class ShoppingCartImp implements ShoppingCartAPI{

	private LinkedList<Item> itemList;
	private User user;

	public ShoppingCartImp() {
		itemList = new LinkedList<Item>();
	}

	@Override
	public void setCartUser(User userA) {
		this.user = userA;
	}

	@Override
	public void addItem(Item item) {
		itemList.add(item);
	}

	@Override
	public void removeItem(Item item) {
		if (itemList.contains(item))
			itemList.remove(item);
		else
			System.out.println("El item seleccionado no se encuentra en su carrito de compras");
	}

	public LinkedList<Item> getItems() {
		if (itemList.isEmpty())
			System.out.println("El carrito esta vacio");
		return itemList;

	}

	public boolean containItem(Item item) {
		if (itemList.contains(item))
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
		itemList.clear();
	}

	@Override
	public double buy(Payment paymentOption) {

		double totalPrice = 0;
		double subtotal = resumeTotal();
		System.out.println("El precio a pagar es: " + subtotal);
		
		boolean success = paymentOption.buyNow(user, itemList, subtotal);

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
		Iterator<Item> it = itemList.iterator();
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
