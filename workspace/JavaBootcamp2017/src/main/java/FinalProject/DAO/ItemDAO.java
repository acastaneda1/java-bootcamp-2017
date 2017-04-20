package FinalProject.DAO;

import java.util.List;

import FinalProject.Entities.Item;
import FinalProject.Model.Category;

public interface ItemDAO {

	public int createItem(Item item);

	public Item getItem(int idItem);

	public List<Item> getItemByCategory(Category category);

	public List<Item> getItemByName(String name);

	public List<Item> getItems();

	public boolean updateItem(Item item);

	public boolean deleteItem(Item item);
}
