package FinalProject.DAOImp;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import FinalProject.HibernateUtil;
import FinalProject.DAO.ItemBagDAO;
import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;


public class ItemBagDAOImp implements ItemBagDAO {

	@Override
	public int createItemBag(int quantity, Item item) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int idItemBag = 0;
		try {
			transaction = session.beginTransaction();
			ItemBag itemBag = new ItemBag(quantity,item);
			idItemBag = (int) session.save(itemBag);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idItemBag;
	}

	@Override
	public ItemBag getItemBag(int idItemBag) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ItemBag itemBag = null;
		try {

			transaction = session.beginTransaction();
			itemBag = (ItemBag) session.get(ItemBag.class, new Integer(idItemBag));
			if (itemBag == null) {
				System.out.println("There is not itemBag with id " + idItemBag);
			} else {
				System.out.println("ItemBag contains " + itemBag.getQuantity() + " units of item: " + itemBag.getItem().getName()
						+ "......... $ " + itemBag.getItem().getItemPrice());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return itemBag;
	}

	

	@Override
	public LinkedList<ItemBag> getItembags() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		LinkedList<ItemBag> itemBag = new LinkedList<ItemBag>();

		try {
			transaction = session.beginTransaction();
			String hql = "select i from ItemBag i ";
			Query query = session.createQuery(hql);

			List<ItemBag> itemBag1 = query.list();
			
			for (ItemBag datos : itemBag1) {
				itemBag.add(datos);
				System.out.println("ItemBag has " + datos.getQuantity() + " units of this Item: " + datos.getItem().getName()
						+ "......... $ " + datos.getItem().getItemPrice());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return itemBag;
	}

	@Override
	public boolean updateItemBag(ItemBag itemBag1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean success= false;
		
		try {
			int idItemBag = itemBag1.getIdItemBag();
			int quantity = itemBag1.getQuantity();
			Item item = itemBag1.getItem();
		
			transaction = session.beginTransaction();
			ItemBag itemBag = (ItemBag) session.get(ItemBag.class, idItemBag);
			if (itemBag == null) {
				System.out.println("This item bag does not exist in the DB");
			} else {
				itemBag.setQuantity(quantity);
				itemBag.setItem(item);
				session.merge("ItemBag", itemBag);
				System.out.println("ItemBag has been updated with " + itemBag.getQuantity() + " units of item: "
						+ itemBag.getItem().getName() + ", description: " + itemBag.getItem().getItemDescription() + " and price: $"
						+ itemBag.getItem().getItemPrice());
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
	public boolean deleteItemBag(ItemBag itemBag1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean success= false;
		int idItemBag;

		try {
			transaction = session.beginTransaction();
			idItemBag = itemBag1.getIdItemBag();
			ItemBag itemBag = (ItemBag) session.get(ItemBag.class, idItemBag);
			if (itemBag == null) {
				System.out.println("This item bag does not exist in the DB");
			} else {
				session.delete(itemBag);
				System.out.println("This item bag has been deleted from the DB");
				success= true;
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
