package FinalProject.DAOImp;

import java.util.List;

import javax.persistence.*;

import FinalProject.HibernateUtil;
import FinalProject.DAO.ItemDAO;
import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.Model.Category;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Teacher;

public class ItemDAOImp implements ItemDAO {

	public ItemDAOImp() {

	}

	@Override
	public int createItem(double itemPrice, String itemName, String itemDescription, Category itemCategory, ItemBag itemBag) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int idItem = 0;
		try {
			transaction = session.beginTransaction();
			Item item = new Item(itemPrice, itemName, itemDescription, itemCategory);
			item.setItemBag(itemBag);
			idItem = (int) session.save(item);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idItem;
	}

	@Override
	public Item getItem(int idItem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Item item = null;
		try {

			transaction = session.beginTransaction();
			item = (Item) session.get(Item.class, new Integer(idItem));
			if (item == null) {
				System.out.println("There is not item with id " + idItem);
				return null;
			} else {
				System.out.println("Item name: " + item.getName() + "......... $ " + item.getItemPrice());
			}
			transaction.commit();
			return item;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return item;
	}

	@Override
	public List<Item> getItemByCategory(Category category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Item> item = null;
		try {
			transaction = session.beginTransaction();
			int categori = 0;
			String hql = "select i from Item i where i.category=:categori";
			Query query = session.createQuery(hql).setParameter("categori", category);

			item = query.list();
			for (Item datos : item) {
				System.out.println("Item name: " + datos.getName() + "......... $ " + datos.getItemPrice());
			}
			transaction.commit();
			return item;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return item;
	}
	
	@Override
	public List<Item> getItemByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Item> item = null;
		try {
			transaction = session.beginTransaction();
			int categori = 0;
			String hql = "select i from Item i where i.name=:names";
			Query query = session.createQuery(hql).setParameter("names", name);

			item = query.list();
			for (Item datos : item) {
				System.out.println("Item name: " + datos.getName() + "......... $ " + datos.getItemPrice());
			}
			transaction.commit();
			return item;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return item;
	}


	@Override
	public List<Item> getItems() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Item> item = null;

		try {
			transaction = session.beginTransaction();
			String hql = "select i from Item i ";
			Query query = session.createQuery(hql);

			item = query.list();
			for (Item datos : item) {
				System.out.println("Item name: " + datos.getName() + "......... $ " + datos.getItemPrice());
			}
			transaction.commit();
			return item;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return item;
	}

	@Override
	public void updateItem(Item item1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			int idItem = item1.getItemId();
			String name = item1.getName();
			Category category = item1.getCategory();
			ItemBag itembag = item1.getItemBag();
			String description = item1.getItemDescription();
			double price = item1.getItemPrice();

			transaction = session.beginTransaction();
			Item item = (Item) session.get(Item.class, idItem);
			if (item == null) {
				System.out.println("This item does not exist in the DB");
			} else {
				item.setCategory(category);
				;
				item.setItemBag(itembag);
				item.setItemDescription(description);
				item.setItemPrice(price);
				item.setName(name);

				System.out.println("Item has been updated with name: " + item.getName() + ", description: " + item.getItemDescription()
						+ " and price: $" + item.getItemPrice() + ". The category is: " + item.getCategory());
			}
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteItem(Item item1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			int idItem = item1.getItemId();
			Item item = (Item) session.get(Item.class, idItem);
			if (item == null) {
				System.out.println("This item does not exist in the DB");
			} else {
				session.delete(item);
				System.out.println("This item has been deleted from the DB");
			}
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
