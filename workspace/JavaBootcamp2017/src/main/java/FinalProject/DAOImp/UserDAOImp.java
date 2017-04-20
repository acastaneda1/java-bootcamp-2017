package FinalProject.DAOImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import FinalProject.HibernateUtil;
import FinalProject.DAO.UserDAO;
import FinalProject.Entities.ShoppingCart;
import FinalProject.Entities.User;

public class UserDAOImp implements UserDAO {

	@Override
	public int createUser(User user1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int idUser = 0;
		try {
			transaction = session.beginTransaction();
			User user = new User(user1.getUserName(), user1.getUserEmail(), user1.getUserPassword(), user1.getUserCCNumber());
			idUser = (int) session.save(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idUser;
	}

	@Override
	public List<User> getUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<User> user = null;

		try {
			transaction = session.beginTransaction();
			String hql = "select u from User u ";
			Query query = session.createQuery(hql);

			user = query.list();
			for (User datos : user) {
				System.out.println("Nombre: " + datos.getUserName() + ", email: " + datos.getUserEmail());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User getUser(int idUser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		User user = null;
		try {

			transaction = session.beginTransaction();
			user = (User) session.get(User.class, new Integer(idUser));
			if (user == null) {
				System.out.println("There is not user with id " + idUser);
			} else {
				System.out.println("User name: " + user.getUserName() + ", user email: " + user.getUserEmail());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<ShoppingCart> emptyCart = new ArrayList<ShoppingCart>();
		boolean success = false;

		try {
			int userId = user1.getUserId();
			String name = user1.getUserName();
			String email = user1.getUserEmail();
			String password = user1.getUserPassword();
			int creditCardNumber = user1.getUserCCNumber();

			transaction = session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			if (user == null) {
				System.out.println("This user does not exist in the DB");
			} else {
				user.setUserName(name);
				user.setUserEmail(email);
				user.setUserPassword(password);
				user.setUserCCNumber(creditCardNumber);

				System.out.println("User has been updated with name: " + user.getUserName() + ", email: " + user.getUserEmail()
						+ " and Credit Card Number: " + user.getUserCCNumber() + ".");
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
	public boolean deleteUser(User user1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean success = false;

		try {
			transaction = session.beginTransaction();
			int userId = user1.getUserId();
			User user = (User) session.get(User.class, userId);
			if (user == null) {
				System.out.println("This user does not exist in the DB");
			} else {
				session.delete(user);
				System.out.println("This user has been deleted from the DB");
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
	public boolean logInUser(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logOutUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
