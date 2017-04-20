package Clase4API.Model;

import java.io.Serializable;

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

}
