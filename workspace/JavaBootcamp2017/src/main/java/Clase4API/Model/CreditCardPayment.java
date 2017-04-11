package Clase4API.Model;

import java.util.LinkedList;

import Clase4API.Service.Payment;

public class CreditCardPayment implements Payment {

	private String name;
	private int creditCardNumber;
	private double amount;
	private double percentageDiscount;
	private int transactionId;

	public CreditCardPayment() {
		transactionId = new Counter().getIDTransaction();
	}

	@Override
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, double total) {

		setUserName(user.getUserName());
		setUserCCNumber(user.getUserCCNumber());
		setPercentageDiscount(0.1);
		setAmount(total * (1 - percentageDiscount));
		System.out.println("La compra No." + transactionId + " se realiza por tarjeta de credito y tiene descuento del 10%.");
		return true;
	}

	public void setIdTransaction(int newId) {
		this.transactionId = newId;
	}

	@Override
	public int getIdTransaction() {
		return transactionId;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	public String getUserName() {
		return name;
	}

	public void setUserCCNumber(int CCNumber) {
		this.creditCardNumber = CCNumber;
	}

	public int getUserCCNumber() {
		return creditCardNumber;
	}

	public void setAmount(double totalPrice) {
		this.amount = totalPrice;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	public void setPercentageDiscount(double discount) {
		this.percentageDiscount = discount;
	}

	public double getPercentageDiscount() {
		return amount;
	}
}
