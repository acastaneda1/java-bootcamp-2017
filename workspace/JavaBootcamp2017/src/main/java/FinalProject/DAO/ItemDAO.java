package FinalProject.DAO;

import java.util.List;

import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Model.Category;

public interface ItemDAO {

	public int createItem(double itemPrice, String itemName, String itemDescription, Category itemCategory, ItemBag itemBag);

	public Item getItem(int idItem);

	public List<Item> getItemByCategory(Category category);

	public List<Item> getItemByName(String name);

	public List<Item> getItems();

	public void updateItem(Item item);

	public void deleteItem(Item item);
}
