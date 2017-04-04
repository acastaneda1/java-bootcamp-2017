package Clase4API;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

import org.easymock.Capture;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.easymock.Mock;
import org.junit.runner.RunWith;

import Clase4API.ServiceImp.CashPayment;
import Clase4API.ServiceImp.CreditCardPayment;
import Clase4API.ServiceImp.Item;
import Clase4API.ServiceImp.PaypalPayment;
import Clase4API.ServiceImp.ShoppingCart;
import Clase4API.ServiceImp.User;

import java.util.LinkedList;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class ShoppingCartTest {

	@TestSubject
	ShoppingCart shoppingCar = ShoppingCartFactory.getLocalShoppingCart();

	@Mock
	private User mockUser;

	@Before
	public void setUp() {
		shoppingCar = ShoppingCartFactory.getLocalShoppingCart();
	}

	@Test
	public void whenAddAnItemIsAddedToShoppingCart() {
		Item mockItem = mock(Item.class);
		shoppingCar.addItem(mockItem);
		assertTrue(shoppingCar.containItem(mockItem));
	}

	@Test
	public void whenRemoveAnItemIsRemovedToShoppingCart() {
		Item mockItem = mock(Item.class);
		shoppingCar.addItem(mockItem);
		shoppingCar.removeItem(mockItem);
		assertFalse(shoppingCar.containItem(mockItem));
	}

	@Test
	public void whenRemoveAnRemovedItemItGivesUserErrorMesage() {
		Item mockItem = mock(Item.class);
		shoppingCar.addItem(mockItem);
		shoppingCar.removeItem(mockItem);
		assertFalse(shoppingCar.containItem(mockItem));
		shoppingCar.removeItem(mockItem);
		assertFalse(shoppingCar.containItem(mockItem));
	}

	@Test
	public void whenGetShoppingCartFullItGivesAllItemsInTheShoppingCart() {
		Item mockItem = mock(Item.class);
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
		Item mockItem = mock(Item.class);
		Item mockItem2 = mock(Item.class);
		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.clearShoppingCart();
		assertEquals(shoppingCar.getItems().size(), 0);
	}

	@Test
	public void whenResumeTheTotalItTotalizeAllItemsInShoppingCar() {
		Item mockItem = mock(Item.class);
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);
		Item mockItem4 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20.0);
		expect(mockItem2.getItemPrice()).andReturn(55.0);
		expect(mockItem3.getItemPrice()).andReturn(75.0);
		expect(mockItem4.getItemPrice()).andReturn(10.0);

		replay(mockItem);
		replay(mockItem2);
		replay(mockItem3);
		replay(mockItem4);

		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);
		shoppingCar.addItem(mockItem4);

		assertTrue(shoppingCar.resumeTotal() == 160.0);
	}

	@Test
	public void whenUserBuyItShowsTotalPriceMessageAndPaymentMethodMessage() {
		Item mockItem = mock(Item.class);
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);
		Item mockItem4 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20.0).times(5);
		expect(mockItem2.getItemPrice()).andReturn(55.0).times(5);
		expect(mockItem3.getItemPrice()).andReturn(75.0).times(5);
		expect(mockItem4.getItemPrice()).andReturn(10.0).times(5);

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

		double total = shoppingCar.buy(new CashPayment());
		assertTrue(total == 92.5);
	}

	@Test
	public void whenUserBuyByCreditCardIsApliedTheTenPercentDiscountOverThePurchase() {
		expect(mockUser.getUserName()).andReturn("UserName1");
		expect(mockUser.getUserCCNumber()).andReturn(445566778);

		replay(mockUser);

		Item mockItem = mock(Item.class);
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20.0).times(5);
		expect(mockItem2.getItemPrice()).andReturn(55.0).times(5);
		expect(mockItem3.getItemPrice()).andReturn(75.0).times(5);

		replay(mockItem);
		replay(mockItem2);
		replay(mockItem3);

		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);

		shoppingCar.setCartUser(mockUser);
		CreditCardPayment creditCardPayment = new CreditCardPayment();
		shoppingCar.buy(creditCardPayment);
		double total = creditCardPayment.getAmount();
		assertTrue(total == 135.0);
	}

	@Test
	public void whenUserBuyByPaypalTheCheapestItemIsForFree() {
		expect(mockUser.getUserEmail()).andReturn("UserName1@123.ar");
		expect(mockUser.getUserPassword()).andReturn("1234RFV");

		replay(mockUser);

		Item mockItem = mock(Item.class);
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20.0).times(5);
		expect(mockItem2.getItemPrice()).andReturn(30.0).times(5);
		expect(mockItem3.getItemPrice()).andReturn(30.0).times(5);

		replay(mockItem);
		replay(mockItem2);
		replay(mockItem3);

		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);

		shoppingCar.setCartUser(mockUser);
		PaypalPayment paypalPayment = new PaypalPayment();
		shoppingCar.buy(paypalPayment);
		double total = paypalPayment.getAmount();
		assertTrue(total == 60.0);
	}

	@Test
	public void whenUserBuyByCashTheMoreExpensiveItemIsNinetyPercentOfItsPrice() {

		Item mockItem = mock(Item.class);
		Item mockItem2 = mock(Item.class);
		Item mockItem3 = mock(Item.class);

		expect(mockItem.getItemPrice()).andReturn(20.0).times(5);
		expect(mockItem2.getItemPrice()).andReturn(30.0).times(5);
		expect(mockItem3.getItemPrice()).andReturn(30.0).times(5);

		replay(mockItem);
		replay(mockItem2);
		replay(mockItem3);

		shoppingCar.addItem(mockItem);
		shoppingCar.addItem(mockItem2);
		shoppingCar.addItem(mockItem3);

		shoppingCar.setCartUser(mockUser);
		CashPayment cashPayment = new CashPayment();
		shoppingCar.buy(cashPayment);
		double total = cashPayment.getAmount();
		assertTrue(total == 53.0);
	}
}
