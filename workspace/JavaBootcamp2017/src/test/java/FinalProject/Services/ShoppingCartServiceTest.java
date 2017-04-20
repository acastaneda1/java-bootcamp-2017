package FinalProject.Services;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.easymock.EasyMock.*;

import FinalProject.Entities.User;

import FinalProject.DAOImp.ShoppingCartDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Entities.ItemBag;
import FinalProject.ServiceImp.ShoppingCartImp;

@RunWith(EasyMockRunner.class)
public class ShoppingCartServiceTest {

	@TestSubject
	ShoppingCartImp shoppingCart = new ShoppingCartImp();

	@Mock
	private ShoppingCartDAOImp cartDao;

	@Mock
	LinkedList<ItemBag> itemBags;

	@Mock
	Item item;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCartImp();
		shoppingCart.setShoppingCartDAO(cartDao);
	}

	@Test
	public void whenWeCreateANewShoppingCartItReturnsIdCart() {

		User user = new User();
		expect(cartDao.createCart(user)).andReturn(1).times(2);
		replay(cartDao);

		int idShoppingCart = shoppingCart.createShoppingCart(user);
		assertEquals(idShoppingCart, 1);
	}

	@Test
	public void whenWeDeleteAShoppingCartItReturnsTrue() {
		expect(cartDao.deleteShoppingCart(1)).andReturn(true).times(2);
		replay(cartDao);

		assertTrue(shoppingCart.deleteShoppingCart(1));
	}

	@Test
	public void whenWeGetItemsFromShoppingCartDaoGivesAListOfItemBags() {
		expect(cartDao.getItemBags(1)).andReturn(itemBags).times(2);
		replay(cartDao);

		LinkedList<ItemBag> cartItemBags = shoppingCart.getItems(1);
		assertEquals(cartItemBags, itemBags);
	}

	@Test
	public void whenWeAddAnItemToShoppingCartItReturnsTrue() {
		expect(cartDao.addItem(item, 1)).andReturn(true).times(2);
		replay(cartDao);

		assertTrue(shoppingCart.addItem(item, 1));
	}

	@Test
	public void whenWeRemoveAnItemFromShoppingCartItReturnsTrue() {
		expect(cartDao.removeItem(item, 1)).andReturn(true).times(2);
		replay(cartDao);

		assertTrue(shoppingCart.removeItem(item, 1));
	}

	@Test
	public void whenWeCleanAShoppingCartItReturnsTrueAndRemoveAllItemsFromShoppingCart() {
		expect(cartDao.clearShoppingCart(1)).andReturn(true).times(3);
		replay(cartDao);

		assertTrue(shoppingCart.clearShoppingCart(1));
	}

}
