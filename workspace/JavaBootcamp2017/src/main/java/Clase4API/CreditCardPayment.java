package Clase4API;

import java.util.LinkedList;

public class CreditCardPayment implements Payment {

	private String name;
	private int creditCardNumber;
	private int amount;

	@Override
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, int total) {

		setUserName(user.getUserName());
		setUserCCNumber(user.getUserCCNumber());
		setAmount(total);
		System.out.println("La compra se realiza por tarjeta de credito");
		return true;
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

	public void setAmount(int totalPrice) {
		this.amount = totalPrice;
	}

	public int getAmount() {
		return amount;
	}
}
