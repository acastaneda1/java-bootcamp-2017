package Clase4API.Model;

import java.util.Iterator;
import java.util.LinkedList;

import Clase4API.Service.Payment;

public class CashPayment implements Payment {

	private double amount;
	private int transactionId;

	public CashPayment() {
		transactionId = new Counter().getIDTransaction();
	}

	public void setIdTransaction(int newId) {
		this.transactionId = newId;
	}

	@Override
	public int getIdTransaction() {
		return transactionId;
	}

	@Override
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, double total) {
		double expensiveItem = getMostExpensiveItem(shoppingCar);
		setAmount(total - (expensiveItem * 0.9));
		System.out.println("La compra No." + transactionId + " se realiza en efectivo. Tiene descuento: el producto producto m�s costoso le es cobrado el 90%");
		return true;
	}

	public void setAmount(double totalPrice) {
		this.amount = totalPrice;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	public double getMostExpensiveItem(LinkedList<Item> shoppingCar) {

		double maxPrice = 0;
		Iterator<Item> it = shoppingCar.listIterator();
		while (it.hasNext()) {
			Item item = it.next();
			if (item.getItemPrice() >= maxPrice) {
				maxPrice = item.getItemPrice();
			}
		}
		return maxPrice;

	}
}
