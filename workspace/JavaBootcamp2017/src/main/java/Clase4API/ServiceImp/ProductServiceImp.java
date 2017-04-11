package Clase4API.ServiceImp;

import java.util.Iterator;
import java.util.LinkedList;

import Clase4API.Model.Item;
import Clase4API.Model.Offer;
import Clase4API.DAO.ItemDAO;
import Clase4API.DAO.OfferDAO;
import Clase4API.DAOImp.ItemDAOImp;
import Clase4API.DAOImp.OfferDAOImp;
import Clase4API.Service.ProductService;
import javax.persistence.*;

public class ProductServiceImp implements ProductService{


	@Override
	public void createItem(Item item){
		ItemDAOImp.createItem(item);
	}
	
	@Override
	public void createOffer(Offer offer){
		
	}
	
	@Override
	public void updateItem(Item item){
		
	}
	
	@Override
	public void updateOffer(Offer offer){
		
	}
	
	@Override
	public Item getItem(int idItem){
		
	}
	
	@Override
	public Offer getOffer(int idOffer){
		
	}
	
	@Override
	public void deleteItem(Item item){
		
	}
	
	@Override
	public void deleteOffer(Offer offer){
		
	}
	
	@Override
	public void createTransaction(){
		
	}
}
