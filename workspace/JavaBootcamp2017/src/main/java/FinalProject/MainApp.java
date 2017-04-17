package FinalProject;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import FinalProject.DAOImp.ItemDAOImp;
import FinalProject.Entities.Categories;
import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Entities.Offer;
import FinalProject.Entities.ShoppingCart;
import FinalProject.Entities.User;
import FinalProject.Model.Category;
import FinalProject.Model.State;


public class MainApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			Category category = Category.Frutas;
			
			User user = new User("Juan", "Juan@gmail.com", "123eds", 12345); 
			
			ItemBag itemBag = new ItemBag();
			itemBag.setQuantity(2);
			
			ItemBag itemBag2 = new ItemBag();
			itemBag2.setQuantity(4);
			
			ItemBag itemBag3 = new ItemBag();
			itemBag3.setQuantity(12);
			
			ItemBag itemBag4 = new ItemBag();
			itemBag4.setQuantity(1);
			
			LinkedList<ItemBag> bag = new LinkedList<ItemBag>();
			LinkedList<Item> bagOffer = new LinkedList<Item>();
			
			Item item1 = new Item(12.50, "Apple", "Red", category);
			item1.setItemBag(itemBag);
			
			Item item2 = new Item(12.50, "Pear", "Green", category);
			item2.setItemBag(itemBag2);
			
			ItemDAOImp item = new ItemDAOImp();
			//item.createItem(10.50, "Grapes", "Purple", category, itemBag3);
			//item.createItem(50.50, "Coconut", "Coast", category, itemBag2);
			//Item itemExample =item.getItem(2);
			//item.getItems();
			//item.getItemByCategory(category);
			//item.getItemByName("apple");
			//System.out.println(category);
			//itemExample.setItemDescription("Is not Green any more");
			//item.updateItem(itemExample);
			//item.deleteItem(itemExample);
			
			Item item4 = new Item(2.50, "Kiwi", "Green", category);
			item4.setItemBag(itemBag4);
			
			
			
			Offer offer = new Offer(12.00, "Pears", "-0.50");
			bagOffer.add(item2);
			bagOffer.add(item1);
			offer.setOfferItems(bagOffer);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			String todayString = dateFormat.format(today);
			Date lastUpdate = dateFormat.parse(todayString);
			bag.add(itemBag);
			bag.add(itemBag2);
			
			State stateCart = State.Pendiente;
			ShoppingCart cart = new ShoppingCart(stateCart, lastUpdate);
			cart.setItemBags(bag);
			cart.setUser(user);
			
			/*session.save(user);
			session.save(item1);
			session.save(itemBag);
			session.save(offer);
			session.save(cart);*/
			
			
			
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

