package Clase4API.Service;

import java.util.LinkedList;
import java.util.List;

import Clase4API.Model.Item;
import Clase4API.Model.Offer;
import Clase4API.ServiceImp.ShoppingCart;

public interface ProductService {

	/*
	 * This method receive an item object and save it in DB
	 */
	public void createItem(Item item);

	/*
	 * This method receive an offer object and save it in DB
	 */
	public void createOffer(Offer offer);

	/*
	 * This method receive an item object and update it with the changes in DB
	 */
	public void updateItem(Item item);

	/*
	 * This method receive an offer object and update it with the changes in DB
	 */
	public void updateOffer(Offer offer);

	/*
	 * This method receive the id of an item object and returns it 
	 */
	//public Item getItem(int idItem);

	/*
	 * This method receive the id of an offer object and returns it 
	 */
	//public Offer getOffer(int idOffer);

	/*
	 * This method receive an item object and delete it from DB
	 */
	public void deleteItem(Item item);
	/*
	 * This method receive an offer object and delete it from DB
	 */
	public void deleteOffer(Offer offer);

	/*
	 * This method create a transaction in DB
	 */
	public void createTransaction();

}
