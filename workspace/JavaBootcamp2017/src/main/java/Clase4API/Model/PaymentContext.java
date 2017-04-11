package Clase4API.Model;

import java.util.LinkedList;

import Clase4API.Service.Payment;

public class PaymentContext {

	private Payment payment;

	public PaymentContext(Payment paymentSelected) {
		this.payment = paymentSelected;
	}

	public boolean executePayment(User user, LinkedList<Item> shoppingCar, int total) {
		return payment.buyNow(user, shoppingCar, total);
	}
}
