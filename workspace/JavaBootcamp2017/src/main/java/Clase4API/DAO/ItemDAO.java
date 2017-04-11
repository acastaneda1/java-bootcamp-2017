package Clase4API.DAO;

import Clase4API.Model.Item;

public interface ItemDAO {

	public void createItem(Item item);
	
	public void updateItem(Item item);
	
	public Item getItem(int idItem);
	
	public void deleteItem(Item item);
}
