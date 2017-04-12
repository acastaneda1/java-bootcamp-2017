package Clase4API.Model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private int idCategory;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Item> item = new HashSet<Item>(0);

	public Category() {

	}

	public Category(String categoryName, String CategoryDescription) {
		this.name = categoryName;
		this.description = CategoryDescription;
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

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> newValue) {
		this.item = newValue;
	}
}
