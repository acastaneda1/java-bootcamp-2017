package FinalProject.ServiceImp;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.DAOImp.ShoppingCartDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Entities.User;
import FinalProject.Model.State;
import FinalProject.Entities.ItemBag;
import FinalProject.Services.Payment;
import FinalProject.Services.ShoppingCartAPI;

@Service
public class ShoppingCartImp implements ShoppingCartAPI {

	private LinkedList<ItemBag> itemList;
	private User user;
	private State state;
	private Date date;
	int idCartDao;

	@Autowired
	ShoppingCartDAOImp cartDao;

	public ShoppingCartImp() {

	}

	public ShoppingCartImp(User user) {
		this.user = user;
		this.date = new Date();
	}

	public void setShoppingCartDAO(ShoppingCartDAOImp cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public void setCartUser(User userA, int idShoppingCart) {
		this.user = userA;
	}

	@Override
	public int createShoppingCart(User user) {
		return cartDao.createCart(user);
	}

	@Override
	public boolean deleteShoppingCart(int idShoppingCart) {
		return cartDao.deleteShoppingCart(idShoppingCart);
	}

	@Override
	public boolean addItem(Item item, int idShoppingCart) {
		return cartDao.addItem(item, idShoppingCart);
	}

	@Override
	public boolean removeItem(Item item, int idShoppingCart) {
		return cartDao.removeItem(item, idShoppingCart);
	}

	@Override
	public LinkedList<ItemBag> getItems(int idShoppingCart) {
		return cartDao.getItemBags(idShoppingCart);
	}

	@Override
	public double resumeTotal(int idShoppingCart) {
		return cartDao.resumeTotalShoppingCart(idShoppingCart);
	}

	@Override
	public boolean clearShoppingCart(int idShoppingCart) {
		return cartDao.clearShoppingCart(idShoppingCart);
	}

	@Override
	public double buy(Payment paymentOption, int IdShoppingCart) {

		double totalPrice = 0;
		double subtotal = resumeTotal(IdShoppingCart);
		System.out.println("El precio a pagar es: " + subtotal);

		boolean success = true;// paymentOption.buyNow(user, itemList,
								// subtotal);

		if (!success)
			System.out.println("La compra no puedo ser realizada por el metodo seleccionado");
		else {
			totalPrice = paymentOption.getAmount();
			System.out.println("Por ende el valor final de su compra fue: " + totalPrice);
		}

		return totalPrice;
	}
}
