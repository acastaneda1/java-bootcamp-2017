package Clase4API;

import java.util.LinkedList;

public class CashPayment implements Payment {

	private int amount;

	public boolean buyNow(User user, LinkedList<Item> shoppingCar, int total) {

		setAmount(total);
		System.out.println("La compra se realiza en efectivo");
		return true;
	}

	public void setAmount(int totalPrice) {
		this.amount = totalPrice;
	}

	public int getAmount() {
		return amount;
	}
}
