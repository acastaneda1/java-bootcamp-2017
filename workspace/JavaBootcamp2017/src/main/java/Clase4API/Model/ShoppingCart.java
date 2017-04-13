package Clase4API.Model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import Clase6Hibernate.Entities.Grades;

@Entity
@Table(name = "shopping_cart1")
public class ShoppingCart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cart")
	private int idShoppingCart;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cart_items", joinColumns = { @JoinColumn(name = "id_cart") }, inverseJoinColumns = {
			@JoinColumn(name = "id_itembag") })
	private List<ItemBag> itemBags = new ArrayList<ItemBag>();

	@ManyToOne
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "id_user_FK") )
	private User user;

	@Column(name = "state")
	private String state;

	@Column(name = "last_update")
	private Time dateLastUpdate;

	public void ShoppingCart() {

	}

	public void ShoppingCart(String state, Time date) {
		this.state = state;
		this.dateLastUpdate = date;
	}

	public int getIdShoppingCart() {
		return idShoppingCart;
	}

	public void setIdShoppingCart(int newValue) {
		this.idShoppingCart = newValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User newUser) {
		this.user = newUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String newValue) {
		this.state = newValue;
	}

	public Time getLastUpdateDate() {
		return dateLastUpdate;
	}

	public void setLastUpdateDate(Time newValue) {
		this.dateLastUpdate = newValue;
	}

	public List<ItemBag> getItemBags() {
		return itemBags;
	}

	public void setItemBags(ArrayList<ItemBag> newValue) {
		this.itemBags = newValue;
	}
}
