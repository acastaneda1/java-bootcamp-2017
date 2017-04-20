package FinalProject.DAO;

import java.util.LinkedList;

import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;


public interface ItemBagDAO {

	public int createItemBag(int Quantity, Item item);

	public ItemBag getItemBag(int idItemBag);

	public LinkedList<ItemBag> getItembags();

	public boolean updateItemBag(ItemBag item);

	public boolean deleteItemBag(ItemBag item);
}
