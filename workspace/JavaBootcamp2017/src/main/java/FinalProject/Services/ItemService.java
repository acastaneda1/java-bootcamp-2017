package FinalProject.Services;

import java.util.List;

import FinalProject.Entities.Item;
import FinalProject.Model.Category;

public interface ItemService {
	/*
	 * This method receive an item object, save it in DB and returns the id
	 */
	public int createItem(Item item);
	
	/*
	 * This method receive an item object and update it with the changes in DB
	 */
	public boolean updateItem(Item item);

	/*
	 * This method receive the id of an item object and returns the object
	 */
	public Item getItem(int idItem);

	/*
	 * This method returns a list of the item objects that exist on DB
	 */
	public List<Item> getItems();

	/*
	 * This method receive the category of an item object and returns a list of
	 * items that has this category
	 */
	public List<Item> getItemsByCategory(Category category);

	/*
	 * This method receive the name of an item object and returns a list of
	 * items has that name
	 */
	public List<Item> getItemsByName(String name);
	
	/*
	 * This method receive an item object and delete it from DB
	 */
	public boolean deleteItem(Item item);

}
