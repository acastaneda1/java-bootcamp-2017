package FinalProject.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_bag")
public class ItemBag implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itembag")
	private int idItemBag;

	@Column(name = "quantity")
	private int quantity;

	
	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_item")*/
	@ManyToOne( targetEntity= Item.class, fetch = FetchType.EAGER)
	private Item item;

	public ItemBag() {

	}

	public ItemBag(int quantity, Item item) {
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

	//@JsonIgnore
	public Item getItem() {
		return item;
	}

	public void setItem(Item newValue) {
		this.item = newValue;
	}
}
