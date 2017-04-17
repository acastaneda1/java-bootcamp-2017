package FinalProject.DAO;

import FinalProject.Entities.Offer;

public interface OfferDAO {

	public void createOffer(Offer offer);
	
	public void updateOffer(Offer offer);
	
	//public Item getOffer(Offer idOffer);
	
	public void deleteOffer(Offer offer);
}
