package Clase4API;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.easymock.Mock;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class ShoppingCartTest {

	@TestSubject
	ShoppingCart shoppingCar = ShoppingCartFactory.getLocalShoppingCart();

	@Mock
	private Item mockItem;
	private User mockUser;
	
	@Before
	public void setUp() {
		mockItem = mock(Item.class);
		mockUser = mock(User.class);
		shoppingCar = ShoppingCartFactory.getLocalShoppingCart();
	}

	@Test
	public void whenAddAnItemIsAddedToShoppingCart() {
		shoppingCar.addItem(mockItem);
		assertTrue(shoppingCar.containItem(mockItem));
	}

	@Test
	public void whenRemoveAnItemIsRemovedToShoppingCart() {
		shoppingCar.addItem(mockItem);
		shoppingCar.removeItem(mockItem);
		assertFalse(shoppingCar.containItem(mockItem));
	}

	@Test
	public void whenRemoveAnRemovedItemItGivesUserErrorMesage() {
		shoppingCar.addItem(mockItem);
		shoppingCar.removeItem(mockItem);
		assertFalse(shoppingCar.containItem(mockItem));
		shoppingCar.removeItem(mockItem);
		assertFalse(shoppingCar.containItem(mockItem));
	}

	@Test
	public void whenGetShoppingCartFullItGivesAllItemsInTheShoppingCart() {
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);
		Item mockItem4 = mock(Item.class);
		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);
		shoppingCar.addItem(mockItem4);
		shoppingCar.removeItem(mockItem3);
		assertEquals(shoppingCar.getItems().size(), 3);
	}

	@Test
	public void whenGetShoppingCartEmptyItGivesUserErrorMessage() {
		assertEquals(shoppingCar.getItems().size(), 0);
	}

	@Test
	public void whenClearShoppingCartItRemoveAllItemsFromShoppingCar() {
		Item mockItem2 = mock(Item.class);
		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.clearShoppingCart();
		assertEquals(shoppingCar.getItems().size(), 0);
	}

	@Test
	public void whenResumeTheTotalItTotalizeAllItemsInShoppingCar() {

		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);
		Item mockItem4 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20);
		expect(mockItem2.getItemPrice()).andReturn(55);
		expect(mockItem3.getItemPrice()).andReturn(75);
		expect(mockItem4.getItemPrice()).andReturn(10);

		replay(mockItem);
		replay(mockItem2);
		replay(mockItem3);
		replay(mockItem4);

		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);
		shoppingCar.addItem(mockItem4);

		assertEquals(shoppingCar.resumeTotal(), 160);
	}

	@Test
	public void whenUserBuyItShowsTotalPriceMessage() {
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);
		Item mockItem4 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20);
		expect(mockItem2.getItemPrice()).andReturn(55);
		expect(mockItem3.getItemPrice()).andReturn(75);
		expect(mockItem4.getItemPrice()).andReturn(10);

		/*
		 * expect(mockItem.getItemId()).andReturn("1");
		 * expect(mockItem2.getItemId()).andReturn("2");
		 * expect(mockItem3.getItemId()).andReturn("3");
		 * expect(mockItem4.getItemId()).andReturn("4");
		 * 
		 * expect(mockItem.getItemDescription()).andReturn("Apple");
		 * expect(mockItem2.getItemDescription()).andReturn("Strawberry");
		 * expect(mockItem3.getItemDescription()).andReturn("Grapes");
		 * expect(mockItem4.getItemDescription()).andReturn("Kiwi");
		 */

		replay(mockItem);
		replay(mockItem2);
		replay(mockItem3);
		replay(mockItem4);

		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);
		shoppingCar.addItem(mockItem4);

		assertEquals(shoppingCar.buy(), 160);
	}
}
