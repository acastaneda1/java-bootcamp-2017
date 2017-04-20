package FinalProject.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.DAOImp.ItemDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Model.Category;
import FinalProject.Services.ItemService;

@Service
public class ItemServiceImp implements ItemService {
	
	@Autowired
	private ItemDAOImp items;

	public ItemServiceImp() {
		items = new ItemDAOImp();
	}
	public void setItemDAO(ItemDAOImp itemDao) {
		this.items = itemDao;
	}

	@Override
	public int createItem(Item item) {
		return items.createItem(item);
	}
	
	@Override
	public boolean updateItem(Item item) {
		return items.updateItem(item);
	}
	
	@Override
	public List<Item> getItems() {
		return items.getItems();
	}

	@Override
	public Item getItem(int idItem) {
		return items.getItem(idItem);
	}

	@Override
	public List<Item> getItemsByCategory(Category category) {
		return items.getItemByCategory(category);
	}

	@Override
	public List<Item> getItemsByName(String name) {
		return items.getItemByName(name);
	}

	@Override
	public boolean deleteItem(Item item) {
		return items.deleteItem(item);
	}

}
