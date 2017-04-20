package FinalProject.DAO;

import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Entities.ShoppingCart;
import FinalProject.Entities.User;
import FinalProject.Model.State;

public interface ShoppingCartDAO {

	public int createCart(User user);

	public ShoppingCart getShoppingCart(int idShoppingCart);

	public LinkedList<ItemBag> getItemBags(int idShoppingCart);

	public boolean addItem(Item item, int idShoppingCart);

	public boolean removeItem(Item item, int idShoppingCart);

	public double resumeTotalShoppingCart(int idShoppingCart);

	public boolean clearShoppingCart(int idShoppingCart);

	public boolean updateShoppingCart(ShoppingCart shoppingCart);

	public boolean deleteShoppingCart(int idShoppingCart);
}
