package FinalProject.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

import FinalProject.Model.State;

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
	private List<ItemBag> itemBags = new LinkedList<ItemBag>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "id_user_FK") )
	private User user;

	@Column(name = "state")
	private State state;

	@Column(name = "last_update")
	private Date dateLastUpdate;

	public ShoppingCart() {

	}

	public ShoppingCart(State state, Date date) {
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

	public State getState() {
		return state;
	}

	public void setState(State newValue) {
		this.state = newValue;
	}

	public Date getLastUpdateDate() {
		return dateLastUpdate;
	}

	public void setLastUpdateDate(Date newValue) {
		this.dateLastUpdate = newValue;
	}

	public List<ItemBag> getItemBags() {
		return itemBags;
	}

	public void setItemBags(LinkedList<ItemBag> newValue) {
		this.itemBags = newValue;
	}
}
