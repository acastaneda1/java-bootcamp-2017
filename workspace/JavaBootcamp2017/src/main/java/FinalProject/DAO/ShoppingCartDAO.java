package FinalProject.DAO;

import java.sql.Time;
import java.util.List;

import FinalProject.Entities.ShoppingCart;

public interface ShoppingCartDAO {
	
	public int createCart(String state, Time date);

	public List<ShoppingCart> getShoppingCarts();

	public ShoppingCart getShoppingCart(int idShoppingCart);

	public void updateShoppingCart(ShoppingCart shoppingCart);

	public void deleteShoppingCart(ShoppingCart shoppingCart);
}
