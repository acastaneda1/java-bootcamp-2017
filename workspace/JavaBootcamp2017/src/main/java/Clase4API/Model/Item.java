package Clase4API.Model;

public class Item {

	private String id;
	private double price;
	private String description;

	public Item(double itemPrice, String itemDescription) {
		price = itemPrice;
		description = itemDescription;
	}

	public void setItemId(String newValue) {
		id = newValue;
	}

	public String getItemId() {
		return id;
	}

	public double getItemPrice() {
		return price;
	}

	public void setItemPrice(double newValue) {
		price = newValue;
	}

	public void setItemDescription(String newValue) {
		description = newValue;
	}

	public String getItemDescription() {
		return description;
	}
}
