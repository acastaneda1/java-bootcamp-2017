package Clase4API;

import java.util.LinkedList;

public class PaypalPayment implements Payment {

	private String email;
	private String password;
	private int amount;

	@Override
	public boolean buyNow(User user, LinkedList<Item> shoppingCar, int total) {

		setUserPassword(user.getUserPassword());
		setUserEmail(user.getUserEmail());
		setAmount(total);
		System.out.println("La compra se realiza por Paypal");
		return true;
	}

	public void setUserEmail(String emailUser) {
		this.email = emailUser;
	}

	public String getUserEmail() {
		return email;
	}

	public void setUserPassword(String userPassword) {
		this.email = userPassword;
	}

	public String getUserPassword() {
		return password;
	}

	public void setAmount(int totalPrice) {
		this.amount = totalPrice;
	}

	public int getAmount() {
		return amount;
	}
}
