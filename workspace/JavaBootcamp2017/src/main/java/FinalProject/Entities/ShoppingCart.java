package FinalProject.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
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

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = ItemBag.class, fetch = FetchType.EAGER)
	@JoinTable(name = "cart_items", joinColumns = { @JoinColumn(name = "id_cart") }, inverseJoinColumns = {
			@JoinColumn(name = "id_itembag") })
	private List<ItemBag> itemBags = new LinkedList<ItemBag>();

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "id_user_FK") )
	private User user;

	@Column(name = "state")
	private State state;

	@Column(name = "last_update")
	private Date dateLastUpdate;

	public ShoppingCart() {

	}

	public ShoppingCart(State state, Date date, User user) {
		this.state = state;
		this.dateLastUpdate = date;
		this.user = user;
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

	public LinkedList<ItemBag> getItemBags() {
		LinkedList<ItemBag> newBag = new LinkedList<ItemBag>();
		for (ItemBag i : this.itemBags){
			newBag.add(i);
		}
		return newBag;
	}

	public void addItem(Item item) {
		for (ItemBag i : this.itemBags) {
			if (i.getIdItemBag() == item.getItemId()) {
				i.setQuantity(i.getQuantity() + 1);
			} else {
				this.itemBags.add(new ItemBag(1, item));
			}
		}
	}

	public void removeItem(Item item) {
		for (ItemBag i : this.itemBags) {
			if (i.getIdItemBag() == item.getItemId()) {
				if (i.getQuantity() < 1) {
					i.setQuantity(i.getQuantity() - 1);
				} else {
					this.itemBags.remove(i);
				}
			} else {
				System.out.println("This item does not exist in this cart");
			}
		}
	}
	
	public double resumeTotal() {
		double totalPrice = 0;
		Iterator<ItemBag> itBag = itemBags.listIterator();
		while(itBag.hasNext()){
			ItemBag itembag = itBag.next();
			totalPrice = totalPrice + itembag.getItem().getItemPrice()*itembag.getQuantity();
		}
		return totalPrice;
	}

	public void setItemBags(LinkedList<ItemBag> newValue) {
		this.itemBags = newValue;
	}
}
