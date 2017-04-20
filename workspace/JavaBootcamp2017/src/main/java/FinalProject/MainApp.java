package FinalProject;

import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import FinalProject.DAOImp.ItemBagDAOImp;
import FinalProject.DAOImp.ItemDAOImp;
import FinalProject.DAOImp.OfferDAOImp;
import FinalProject.DAOImp.ShoppingCartDAOImp;
import FinalProject.DAOImp.UserDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Entities.Offer;
import FinalProject.Entities.ShoppingCart;
import FinalProject.Entities.User;
import FinalProject.Model.Category;



public class MainApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			Category category = Category.Frutas;
			
			LinkedList<ItemBag> bag = new LinkedList<ItemBag>();
			LinkedList<Item> bagOffer = new LinkedList<Item>();
						
			ItemDAOImp item = new ItemDAOImp();
			Item item1 = new Item(10.50, "Grapes", "Purple", category);
			Item item2 = new Item(50.50, "Coconut", "Coast", category);
			Item item3 = new Item(12.50, "Pear", "Green", category);
			item.createItem(item1);
			item.createItem(item2);
			item.createItem(item3);
			Item itemExample =item.getItem(1);
			Item itemExample2 =item.getItem(3);
			//item.getItems();
			//item.getItemByCategory(category);
			//item.getItemByName("apple");
			//System.out.println(category);
			//itemExample.setItemDescription("Is not Green any more");
			//item.updateItem(itemExample);
			//item.deleteItem(itemExample);
			
			UserDAOImp user = new UserDAOImp();
			User user1 = new User("Pedro", "pedro@pe.pe", "qwert", 12345);
			User user2 = new User("Ana", "ana@pe.pe", "qwert", 12345);
			user.createUser(user1);
			user.createUser(user2);
			User userExample = user.getUser(4);
			//user.getUsers();
			//userExample.setUserEmail("pe@an.pe");
			//user.updateUser(userExample);
			//user.deleteUser(user.getUser(1));
			
			ItemBagDAOImp itemBag3 = new ItemBagDAOImp();
			itemBag3.createItemBag(2, item.getItem(3));
			itemBag3.createItemBag(10, item.getItem(2));
			itemBag3.createItemBag(12, item.getItem(1));
			ItemBag itemBagExample = itemBag3.getItemBag(1);
			ItemBag itemBagExample2 = itemBag3.getItemBag(2);
			//itemBag3.getItembags();
			//itemBagExample.setQuantity(3);
			//itemBag3.updateItemBag(itemBagExample);
			//itemBag3.deleteItemBag(itemBag3.getItemBag(4));
			//Item item4 = new Item(2.50, "Kiwi", "Green", category);
			//item4.setItemBag(itemBag4);
						
			OfferDAOImp offerDao = new OfferDAOImp();
			bagOffer.add(itemExample);
			bagOffer.add(itemExample2);
			Offer offer1 = new Offer(12.00, "Pears off", "-0.50");
			Offer offer2 = new Offer(10.00, "Grapes off", "-0.50");
			offerDao.createOffer(offer1);
			offerDao.createOffer(offer2);
			Offer offerExample = offerDao.getOffer(1);
			offerDao.getOffers();
			//offerExample.setOfferDescription("Pears so cheap");
			//offerDao.updateOffer(offerExample);
			//offerDao.deleteOffer(offerExample);
			
			bag.add(itemBagExample);
			bag.add(itemBagExample2);
			
			ShoppingCartDAOImp cartDao = new ShoppingCartDAOImp();
			cartDao.createCart(userExample);
			ShoppingCart shoppingCartExample = cartDao.getShoppingCart(12);
			//shoppingCartExample.setState(State.Pagado);
			//cartDao.updateShoppingCart(shoppingCartExample);
			//cartDao.deleteShoppingCart(cartDao.getShoppingCart(11));
			//cart.setItemBags(bag);
			//cart.setUser(userExample);
			
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtil.shutdown();
	}
}

