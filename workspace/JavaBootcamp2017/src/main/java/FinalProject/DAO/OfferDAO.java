package FinalProject.DAO;

import java.util.List;

import FinalProject.Entities.Offer;

public interface OfferDAO {

	public int createOffer(Offer offer);
	
	public Offer getOffer(int idOffer);
	
	public List<Offer> getOffers();
	
	public boolean updateOffer(Offer offer);
	
	public boolean deleteOffer(Offer offer);
}
