package Clase4API.Model;

import java.util.Iterator;
import java.util.LinkedList;

public class Offer {

	private String id;
	private double price;
	private String name;
	private LinkedList<Item> items;

	public Offer( double offerPrice, String offerName, LinkedList<Item> offerItems) {
		
		price = offerPrice;
		name = offerName;
		items = offerItems;
	}

	public void setOfferId(String newValue) {
		id = newValue;
	}

	public String getOfferId() {
		return id;
	}

	public double getOfferPrice() {
		return price;
	}

	public void setOfferPrice(double newValue) {
		price = newValue;
	}

	public void setOfferName(String newValue) {
		name = newValue;
	}

	public String getOfferName() {
		return name;
	}

	public void addItemToOffer(Item item) {
		items.add(item);
	}

	public void removeItemToOffer(Item item) {
		items.remove(item);
	}

	public String formatOffer() {
		String stringOffer = " - " + this.name + " ......... $ " + this.price;
		Iterator<Item> it = items.iterator();
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
		System.out.println(stringOffer + "\n" + itemString);
		System.out.println(itemString);
		return stringOffer + "\n" + itemString;
	}
}
