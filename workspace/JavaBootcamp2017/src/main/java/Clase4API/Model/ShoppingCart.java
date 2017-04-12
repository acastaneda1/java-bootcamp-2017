package Clase4API.Model;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import Clase6Hibernate.Entities.Grades;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cart")
	private int idShoppingCart;

	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "cart")
	private ItemBag itemBags;

	@ManyToOne
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "id_user_FK") )
	private Set<User> user = new HashSet<User>();

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

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> newUser) {
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

	public ItemBag getItemBags() {
		return itemBags;
	}

	public void setItemBags(ItemBag newValue) {
		this.itemBags = newValue;
	}
}
