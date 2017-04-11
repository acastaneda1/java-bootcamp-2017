package Clase4API.Model;

import java.util.LinkedList;

import Clase4API.Service.Payment;

import java.util.Iterator;

public class PaypalPayment implements Payment {

	private String email;
	private String password;
	private double amount;
	private int transactionId;

	public PaypalPayment() {
		transactionId = new Counter().getIDTransaction();
	}

	@Override
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, double total) {

		setUserPassword(user.getUserPassword());
		setUserEmail(user.getUserEmail());
		double cheapOne = getCheapestItem(shoppingCar);
		setAmount(total - cheapOne);
		System.out.println("La compra No." + transactionId + " se realiza por Paypal y tiene descuento: No se cobra el producto de menor valor.");
		return true;
	}

	public void setIdTransaction(int newId) {
		this.transactionId = newId;
	}

	@Override
	public int getIdTransaction() {
		return transactionId;
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

		double minimumPrice = shoppingCar.get(0).getItemPrice();
		Iterator<Item> it = shoppingCar.listIterator();
		while (it.hasNext()) {
			Item item = it.next();
			if (item.getItemPrice() <= minimumPrice) {
				minimumPrice = item.getItemPrice();
			}
		}
		return minimumPrice;
	}
}
