package FinalProject.Services;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import FinalProject.DAOImp.ItemDAOImp;
import FinalProject.DAOImp.OfferDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Entities.Offer;
import FinalProject.Model.Category;
import FinalProject.ServiceImp.ProductServiceImp;

@RunWith(EasyMockRunner.class)
public class ProductServiceTest {

	@TestSubject
	ProductServiceImp productService = new ProductServiceImp();

	@Mock
	private ItemDAOImp itemDao;

	@Mock
	private OfferDAOImp offerDao;

	@Mock
	LinkedList<Offer> offers;

	@Mock
	LinkedList<Item> items;

	@Mock
	Item item;

	@Mock
	Offer offer;

	@Before
	public void setUp() {
		productService = new ProductServiceImp();
		productService.setItemDAO(itemDao);
		productService.setOfferDAO(offerDao);
	}

	@Test
	public void whenWeCreateANewItemItReturnsIdItem() {

		expect(itemDao.createItem(item)).andReturn(1).times(2);
		replay(itemDao);

		int idItem = productService.createItem(item);
		assertEquals(idItem, 1);
	}

	@Test
	public void whenWeDeleteAnItemItReturnsTrue() {
		expect(itemDao.deleteItem(item)).andReturn(true).times(2);
		replay(itemDao);

		assertTrue(productService.deleteItem(item));
	}

	@Test
	public void whenWeGetAnItemsDaoGivesTheItemRelated() {
		expect(itemDao.getItem(1)).andReturn(item).times(2);
		replay(itemDao);

		Item newItem = productService.getItem(1);
		assertEquals(newItem, item);
	}

	@Test
	public void whenWeGetAnItemsByCategoryDaoGivesTheItemListRelated() {
		expect(itemDao.getItemByCategory(Category.Frutas)).andReturn(items).times(2);
		replay(itemDao);

		List<Item> newItem = productService.getItemsByCategory(Category.Frutas);
		assertEquals(newItem, items);
	}

	@Test
	public void whenWeGetAnItemsByNameDaoGivesTheItemListRelated() {
		expect(itemDao.getItemByName("Apple")).andReturn(items).times(2);
		replay(itemDao);

		List<Item> newItem = productService.getItemsByName("Apple");
		assertEquals(newItem, items);
	}

	@Test
	public void whenWeGetAllItemsDaoGivesTheItemListRelated() {
		expect(itemDao.getItems()).andReturn(items).times(2);
		replay(itemDao);

		List<Item> newItem = productService.getItems();
		assertEquals(newItem, items);
	}

	@Test
	public void whenWeUpdateAnItemItReturnsTrue() {

		expect(itemDao.updateItem(item)).andReturn(true).times(2);
		replay(itemDao);

		assertTrue(productService.updateItem(item));
	}

	@Test
	public void whenWeCreateANewOfferItReturnsIdOffer() {

		expect(offerDao.createOffer(offer)).andReturn(1).times(2);
		replay(offerDao);

		int idOffer = productService.createOffer(offer);
		assertEquals(idOffer, 1);
	}

	@Test
	public void whenWeDeleteAnOfferItReturnsTrue() {
		expect(offerDao.deleteOffer(offer)).andReturn(true).times(2);
		replay(offerDao);

		assertTrue(productService.deleteOffer(offer));
	}

	@Test
	public void whenWeGetAnOfferDaoGivesTheOfferRelated() {
		expect(offerDao.getOffer(1)).andReturn(offer).times(2);
		replay(offerDao);

		Offer newOffer = productService.getOffer(1);
		assertEquals(newOffer, offer);
	}

	@Test
	public void whenWeGetAllOffersDaoGivesTheOfferListRelated() {
		expect(offerDao.getOffers()).andReturn(offers).times(2);
		replay(offerDao);

		List<Offer> newOffer = productService.getOffers();
		assertEquals(newOffer, offers);
	}

	@Test
	public void whenWeUpdateAnOfferItReturnsTrue() {

		expect(offerDao.updateOffer(offer)).andReturn(true).times(2);
		replay(offerDao);

		assertTrue(productService.updateOffer(offer));
	}
}
