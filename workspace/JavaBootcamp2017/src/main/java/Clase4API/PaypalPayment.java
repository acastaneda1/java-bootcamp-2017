package Clase4API;

import java.util.LinkedList;
import java.util.Iterator;

public class PaypalPayment implements Payment {

	private String email;
	private String password;
	private double amount;

	@Override
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, double total) {

		setUserPassword(user.getUserPassword());
		setUserEmail(user.getUserEmail());
		double cheapOne = getCheapestItem(shoppingCar);
		System.out.println(cheapOne);
		setAmount(total - cheapOne);
		System.out.println("La compra se realiza por Paypal y tiene descuento: No se cobra el item de menor valor.");
		return true;
	}

	public void setUserEmail(String emailUser) {
		this.email = emailUser;
	}

	public String getUserEmail() {
		return email;
	}

	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}

	public String getUserPassword() {
		return password;
	}

	public void setAmount(double totalPrice) {
		this.amount = totalPrice;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	public double getCheapestItem(LinkedList<Item> shoppingCar) {

		double minimumPrice = 0;
		Iterator<Item> it = shoppingCar.listIterator();
		while (it.hasNext()) {
			Item item = it.next();
			System.out.println(item.getItemPrice());
			if (item.getItemPrice() <= minimumPrice) {
				minimumPrice = item.getItemPrice();
			}
		}
		return minimumPrice;
	}
}
