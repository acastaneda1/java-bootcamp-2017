package Clase4API.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private int idItem;

	@Column(name = "price")
	private double price;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_itembag")
	private ItemBag itemBags;
	
	public void Item(){
		
	}

	public Item(double itemPrice, String itemName, String itemDescription, Category itemCategory) {
		this.price = itemPrice;
		this.description = itemDescription;
		this.name = itemName;
		this.category = itemCategory;
	}

	public void setItemId(int newValue) {
		this.idItem = newValue;
	}

	public int getItemId() {
		return idItem;
	}

	public double getItemPrice() {
		return price;
	}

	public void setItemPrice(double newValue) {
		this.price = newValue;
	}

	public void setItemDescription(String newValue) {
		this.description = newValue;
	}

	public String getItemDescription() {
		return description;
	}

	public void setName(String newValue) {
		this.name = newValue;
	}

	public String getName() {
		return name;
	}
	public ItemBag getItemBag() {
		return itemBags;
	}

	public void setItemBag(ItemBag newValue) {
		this.itemBags = newValue;
	}
}
