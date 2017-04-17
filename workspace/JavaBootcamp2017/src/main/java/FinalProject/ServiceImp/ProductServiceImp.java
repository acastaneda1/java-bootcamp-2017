package FinalProject.ServiceImp;

import org.springframework.stereotype.Service;

import FinalProject.DAO.ItemDAO;
import FinalProject.DAOImp.ItemDAOImp;
import FinalProject.Entities.Item;
import FinalProject.Entities.Offer;
import FinalProject.Services.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	ItemDAO items = new ItemDAOImp();

	@Override
	public void createItem(Item item){
		items.createItem(item.getItemPrice(), item.getName(), item.getItemDescription(), item.getCategory(), item.getItemBag());
	}
	
	@Override
	public void createOffer(Offer offer){
		
	}
	
	@Override
	public void updateItem(Item item){
		items.updateItem(item);
	}
	
	@Override
	public void updateOffer(Offer offer){
		
	}
	
	@Override
	public Item getItem(int idItem){
		return items.getItem(idItem);
	}
	
	/*@Override
	public Offer getOffer(int idOffer){
		return new Offer();
	}*/
	
	@Override
	public void deleteItem(Item item){
		items.deleteItem(item);
	}
	
	@Override
	public void deleteOffer(Offer offer){
		
	}
	
	@Override
	public void createTransaction(){
		
	}
}

