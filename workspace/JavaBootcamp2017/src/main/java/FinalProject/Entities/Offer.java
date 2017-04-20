package FinalProject.Entities;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_offer")
	private int idOffer;

	@Column(name = "price")
	private double price;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "offer_items", joinColumns = { @JoinColumn(name = "id_offer") }, inverseJoinColumns = {
			@JoinColumn(name = "id_item") })
	private List<Item> items = new LinkedList<Item>();

	public Offer() {

	}

	public Offer(double offerPrice, String offerName, String offerDescription) {

		this.price = offerPrice;
		this.name = offerName;
		this.description = offerDescription;
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

	public void setOfferItems(LinkedList<Item> items) {
		this.items = items;
	}

	public List<Item> getOfferItems() {
		return this.items;
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
