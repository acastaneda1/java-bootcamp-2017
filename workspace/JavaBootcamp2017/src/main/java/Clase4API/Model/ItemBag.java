package Clase4API.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "item_bag")
public class ItemBag implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itembag")
	private int idItemBag;

	@Column(name = "quantity")
	private int quantity;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "itemBags", fetch = FetchType.LAZY)
	private Item item;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cart_items", joinColumns = { @JoinColumn(name = "id_itembag") }, inverseJoinColumns = {
			@JoinColumn(name = "id_cart") })
	private Set<ShoppingCart> cart = new HashSet<ShoppingCart>();

	public void ItemBag() {

	}

	public void ItemBag(int quantity) {
		this.quantity = quantity;
	}

	public void setIdItemBag(int newValue) {
		this.idItemBag = newValue;
	}

	public int getIdItemBag() {
		return idItemBag;
	}

	public void setQuantity(int newValue) {
		this.quantity = newValue;
	}

	public int getQuantity() {
		return quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item newValue) {
		this.item = newValue;
	}

	public Set<ShoppingCart> getShoppingCart() {
		return cart;
	}

	public void setShoppingCart(Set<ShoppingCart> newValue) {
		this.cart = newValue;
	}
}