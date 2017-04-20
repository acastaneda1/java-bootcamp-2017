package FinalProject.DAO;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import FinalProject.DAOImp.ShoppingCartDAOImp;
import FinalProject.DAOImp.UserDAOImp;
import FinalProject.Entities.ShoppingCart;
import FinalProject.Entities.User;
import FinalProject.Model.State;

public class ShoppingCartTest {

	ShoppingCartDAOImp cartDao; 
	ShoppingCart cartExample;
	User userExample;
	State stateCart;
	Date today;
	
	@Before
	public void setUp() {
		Date today = new Date();
		stateCart = State.Pendiente;
		
		cartDao = new ShoppingCartDAOImp();
		userExample = new User("Pedro", "pedro@pe.pe", "qwert", 12345);
		cartExample = new ShoppingCart(stateCart, today, userExample); 	
	}
	
	@Test
	public void whenAddAnShoppingCartIsCreatedItIsSaveInBD() throws ParseException {
		Date today = new Date();
		
		UserDAOImp userTestDao = new UserDAOImp();
		User userTest = userTestDao.getUser(3);
		int idCart= cartDao.createCart(userTest);
		//System.out.println(cartExample.getState()+" "+cartExample.getLastUpdateDate()+" "+cartExample.getUser().getUserName());
		assertTrue(cartDao.getShoppingCart(idCart).getUser()==cartExample.getUser());
		//assertEquals(cartDao.getShoppingCart(idCart), cartExample);
	}
}
