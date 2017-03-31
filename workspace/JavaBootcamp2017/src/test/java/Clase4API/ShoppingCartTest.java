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

import Clase3OPP.Entry;

import java.util.LinkedList;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class ShoppingCartTest {
	
	@TestSubject
	ShoppingCart shoppingCar;
	
	@Mock
	private Item mockItem;
	
	@Before
	public void setUp() {
		mockItem = mock(Item.class);
		shoppingCar = ShoppingCartFactory.getLocalShoppingCart();
	}
	
	@Test
	public void whenAddAnItemIsAddedToShoppingCart() {
		shoppingCar.addItem(mockItem);
		assertTrue(shoppingCar.containItem(mockItem));
	}

}
