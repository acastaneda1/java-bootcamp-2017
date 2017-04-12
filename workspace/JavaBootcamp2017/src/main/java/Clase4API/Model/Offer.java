package Clase4API.Model;

import java.util.Iterator;
import java.util.LinkedList;

public class Offer {

	private int idOffer;
	private double price;
	private String name;
	private String description;
	private LinkedList<Item> items;

	public Offer( double offerPrice, String offerName, String offerDescription, LinkedList<Item> offerItems) {
		
		this.price = offerPrice;
		this.name = offerName;
		this.description = offerDescription;
		this.items = offerItems;
	}

	public void setOfferId(int newValue) {
		idOffer = newValue;
	}

	public int getOfferId() {
		return idOffer;
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

	public void setOfferDescription(String newValue) {
		description = newValue;
	}

	public String getOfferDescription() {
		return description;
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
