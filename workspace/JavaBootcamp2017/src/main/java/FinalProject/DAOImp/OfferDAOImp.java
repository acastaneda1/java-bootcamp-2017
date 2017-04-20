package FinalProject.DAOImp;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import FinalProject.HibernateUtil;
import FinalProject.DAO.OfferDAO;
import FinalProject.Entities.Item;
import FinalProject.Entities.Offer;

@Service
public class OfferDAOImp implements OfferDAO {

	@Override
	public int createOffer(Offer offer1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int idOffer = 0;
		try {
			transaction = session.beginTransaction();
			Offer offer = new Offer(offer1.getOfferPrice(), offer1.getOfferName(), offer1.getOfferDescription());
			idOffer = (int) session.save(offer);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idOffer;

	}

	@Override
	public Offer getOffer(int idOffer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Offer offer = null;
		try {
			transaction = session.beginTransaction();
			offer = (Offer) session.get(Offer.class, new Integer(idOffer));
			if (offer == null) {
				System.out.println("There is not offer with id " + idOffer);
			} else {
				System.out.println("Offer name: " + offer.getOfferName() + "......... $ " + offer.getOfferPrice() + "\n");
				if (offer.getOfferItems().size() > 1)
					for (Item datos : offer.getOfferItems()) {
						System.out.println("Item: " + datos.getName() + "......... $ " + datos.getItemPrice());
					}
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return offer;
	}

	@Override
	public List<Offer> getOffers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Offer> offers = null;

		try {
			transaction = session.beginTransaction();
			String hql = "select o from Offer o ";
			Query query = session.createQuery(hql);

			offers = query.list();
			for (Offer offerdata : offers) {
				System.out.println("Offer name: " + offerdata.getOfferName() + "......... $ " + offerdata.getOfferPrice() + "\n");
				if (offerdata.getOfferItems().size() > 1)
					for (Item datos : offerdata.getOfferItems()) {
						System.out.println("Item name: " + datos.getName() + "......... $ " + datos.getItemPrice());
					}
			}
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return offers;
	}

	@Override
	public boolean updateOffer(Offer offer1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		LinkedList<Item> emptyItems = new LinkedList<Item>();
		boolean success = false;

		try {
			int idOffer = offer1.getOfferId();
			String name = offer1.getOfferName();
			String description = offer1.getOfferDescription();
			double price = offer1.getOfferPrice();
			List<Item> items = offer1.getOfferItems();

			transaction = session.beginTransaction();
			Offer offer = (Offer) session.get(Offer.class, idOffer);
			if (offer == null) {
				System.out.println("This item does not exist in the DB");
			} else {
				offer.setOfferName(name);
				offer.setOfferDescription(description);
				offer.setOfferPrice(price);
				for (Item datos : items) {
					emptyItems.add(datos);
				}
				offer.setOfferItems(emptyItems);

				System.out.println("Offer has been updated with name: " + offer.getOfferName() + ", description: "
						+ offer.getOfferDescription() + " and price: $" + offer.getOfferPrice());
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
	public boolean deleteOffer(Offer offer1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int idOffer = 0;
		boolean success = false;

		try {
			transaction = session.beginTransaction();
			idOffer = offer1.getOfferId();
			Offer offer = (Offer) session.get(Offer.class, idOffer);
			if (offer == null) {
				System.out.println("This offer does not exist in the DB");
			} else {
				session.delete(offer);
				System.out.println("This offer has been deleted from the DB");
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
