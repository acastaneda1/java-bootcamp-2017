package Clase4API;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase4API.Model.Category;
import Clase4API.Model.Item;
import Clase4API.Model.ItemBag;

public class MainApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();

			Category category = new Category("Fruits", "sweet");
			
			ItemBag itemBag = new ItemBag();
			itemBag.setQuantity(2);

			Item item1 = new Item(12.50, "Apple", "Red", category);
			item1.setItemBag(itemBag);


			session.save(category);
			session.save(itemBag);
			session.save(item1);

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
