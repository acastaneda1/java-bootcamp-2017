package Clase4API.Model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private int idCategory;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<Item>();

	public Category() {

	}

	public Category(String categoryName, String categoryDescription) {
		this.name = categoryName;
		this.description = categoryDescription;
	}

	public void setIdCategory(int newValue) {
		idCategory = newValue;
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setCategoryName(String newValue) {
		name = newValue;
	}

	public String getCategoryName() {
		return this.name;
	}

	public void setCategoryDescription(String newValue) {
		description = newValue;
	}

	public String getCategoryDescription() {
		return this.description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> newValue) {
		this.items = newValue;
	}
}
