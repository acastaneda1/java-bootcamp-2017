package FinalProject.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.DAOImp.ItemDAOImp;
import FinalProject.DAOImp.OfferDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Entities.Offer;
import FinalProject.Model.Category;
import FinalProject.Services.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ItemDAOImp items;

	@Autowired
	private OfferDAOImp offerDao;

	public ProductServiceImp() {
		items = new ItemDAOImp();
	}

	public void setOfferDAO(OfferDAOImp offerDao) {
		this.offerDao = offerDao;
	}

	public void setItemDAO(ItemDAOImp itemDao) {
		this.items = itemDao;
	}

	@Override
	public int createItem(Item item) {
		return items.createItem(item);
	}

	@Override
	public int createOffer(Offer offer) {
		return offerDao.createOffer(offer);
	}

	@Override
	public boolean updateItem(Item item) {
		return items.updateItem(item);
	}

	@Override
	public boolean updateOffer(Offer offer) {
		return offerDao.updateOffer(offer);
	}

	@Override
	public List<Item> getItems() {
		return items.getItems();
	}

	@Override
	public Item getItem(int idItem) {
		return items.getItem(idItem);
	}

	@Override
	public List<Item> getItemsByCategory(Category category) {
		return items.getItemByCategory(category);
	}

	@Override
	public List<Item> getItemsByName(String name) {
		return items.getItemByName(name);
	}

	@Override
	public boolean deleteItem(Item item) {
		return items.deleteItem(item);
	}

	@Override
	public boolean deleteOffer(Offer offer) {
		return offerDao.deleteOffer(offer);
	}

	@Override
	public void createTransaction() {

	}

	@Override
	public Offer getOffer(int idOffer) {
		return offerDao.getOffer(idOffer);
	}

	@Override
	public List<Offer> getOffers() {
		return offerDao.getOffers();
	}
}
