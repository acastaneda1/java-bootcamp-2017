package FinalProject.Entities;

import java.io.Serializable;

import javax.persistence.*;

import FinalProject.Model.Category;

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

	@Column(name = "category")
	private Category category;
		
	public Item(){
		
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
	
	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category categories){
		this.category = categories;
	}
}
