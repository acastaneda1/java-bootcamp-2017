package FinalProject.DAOImp;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import FinalProject.HibernateUtil;
import FinalProject.DAO.ShoppingCartDAO;
import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Entities.ShoppingCart;
import FinalProject.Entities.User;
import FinalProject.Model.State;

public class ShoppingCartDAOImp implements ShoppingCartDAO {

	public ShoppingCartDAOImp(){
		
	}
	@Override
	public int createCart(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int idCart = 0;
		try {
			transaction = session.beginTransaction();
			ShoppingCart cart = new ShoppingCart(State.Pagado, new Date(), user);
			idCart = (int) session.save(cart);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idCart;
	}

	@Override
	public ShoppingCart getShoppingCart(int idShoppingCart) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ShoppingCart cart = null;
		try {

			transaction = session.beginTransaction();
			cart = (ShoppingCart) session.get(ShoppingCart.class, new Integer(idShoppingCart));
			if (cart == null) {
				System.out.println("There is not shopping cart with id " + idShoppingCart);
				return null;
			} else {
				System.out.println("This shopping cart belongs to: " + cart.getUser().getUserName() + ", it was updated in "
						+ cart.getLastUpdateDate() + " and the status is:" + cart.getState());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cart;
	}

	@Override
	public LinkedList<ItemBag> getItemBags(int idShoppingCart) {
		ShoppingCart modifiedCart = getShoppingCart(idShoppingCart);
		if (modifiedCart.getItemBags().isEmpty()) {
			System.out.println("The cart is empty");
			return null;
		} else {
			return modifiedCart.getItemBags();
		}
	}
	
	@Override
	public boolean addItem(Item item, int idShoppingCart) {
		ShoppingCart modifiedCart = getShoppingCart(idShoppingCart);
		modifiedCart.addItem(item);
		return updateShoppingCart(modifiedCart);
	}
	
	@Override
	public boolean removeItem(Item item, int idShoppingCart) {
		ShoppingCart modifiedCart = getShoppingCart(idShoppingCart);
		modifiedCart.removeItem(item);
		return updateShoppingCart(modifiedCart);
	}
	@Override
	public boolean updateShoppingCart(ShoppingCart shoppingCart1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		LinkedList<ItemBag> emptyItemBag = new LinkedList<ItemBag>();
		boolean success = false;
		try {
			int idShoppingCart = shoppingCart1.getIdShoppingCart();
			Date lastUpdate = shoppingCart1.getLastUpdateDate();
			List<ItemBag> itemBags = shoppingCart1.getItemBags();
			State state = shoppingCart1.getState();
			User user = shoppingCart1.getUser();

			transaction = session.beginTransaction();
			ShoppingCart shoppingCart = (ShoppingCart) session.get(ShoppingCart.class, idShoppingCart);
			if (shoppingCart == null) {
				System.out.println("This shopping cart does not exist in the DB");
			} else {
				shoppingCart.setLastUpdateDate(lastUpdate);
				shoppingCart.setUser(user);
				shoppingCart.setState(state);
				if (emptyItemBag.isEmpty())
					for (ItemBag datos : itemBags) {
						emptyItemBag.add(datos);
					}
				shoppingCart.setItemBags(emptyItemBag);
				success = true;
			}
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

	@Override
	public double resumeTotalShoppingCart(int idShoppingCart) {

		ShoppingCart modifiedCart = getShoppingCart(idShoppingCart);
		double totalPrice = 0;
		Iterator<ItemBag> it = modifiedCart.getItemBags().listIterator();
		while (it.hasNext()) {
			ItemBag item = it.next();
			totalPrice = totalPrice + item.getItem().getItemPrice() * item.getQuantity();
		}
		return totalPrice;
	}
	
	@Override
	public boolean clearShoppingCart(int idShoppingCart) {
		ShoppingCart modifiedCart = getShoppingCart(idShoppingCart);
		modifiedCart.setItemBags(new LinkedList<ItemBag>());
		return updateShoppingCart(modifiedCart);
		
	}
	
	@Override
	public boolean deleteShoppingCart(int idShoppingCart) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean success = false;

		try {
			transaction = session.beginTransaction();
			ShoppingCart cart = (ShoppingCart) session.get(ShoppingCart.class, idShoppingCart);
			if (cart == null) {
				System.out.println("This shopping cart does not exist in the DB");
			} else {
				session.delete(cart);
				System.out.println("This shopping cart has been deleted from the DB");
				success = true;
			}
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

}
