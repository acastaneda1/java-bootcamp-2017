package Clase4API.DAO;

import Clase4API.Model.Offer;

public interface OfferDAO {
	
	public void createOffer(Offer offer);

	public void updateOffer(Offer offer);
	
	public Offer getOffer(int idOffer);
	
	public void deleteOffer(Offer offer);
}
