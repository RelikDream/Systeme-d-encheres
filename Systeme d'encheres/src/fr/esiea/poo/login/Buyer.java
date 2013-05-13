package fr.esiea.poo.login;

import java.util.Date;

import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.warning.Warning;
import fr.esiea.poo.warning.WarningType;


public class Buyer extends AbstractUser {

	protected Buyer(String login) {
		super(login);
	}

	@Override
	public boolean sendOfferto(int price, int auctionId, boolean followed) throws Exception {
		if(followed)
			return AuctionHouse.getInstance().addOffer(auctionId, price, this.getLogin(),new Warning(this, WarningType.BETTER_OFFER));
		
		return AuctionHouse.getInstance().addOffer(auctionId, price, this.getLogin(),null);
	}

	@Override
	public boolean publishAuction(int id) throws Exception {
		throw new Exception("you are not allowed to publish an auction !");
	}
	
	@Override
	public void createAuction(int itemId, String itemDescription, double minPrice, Date deadline, double reservePrice) throws Exception {
		throw new Exception("You are not allowed to create an auction !");
	}

	@Override
	public boolean cancelAuction(int AuctionId) throws Exception {
		throw new Exception("you are not allowed to cancel an auction !");
	}
	@Override
	public boolean addWarning(int aId, WarningType wt){
		switch(wt){
		case AUCTION_CANCELED:
		case RESERVE_PRICE_REACHED:
			AuctionHouse.getInstance().addWarning(aId, new Warning(this, wt));
			return true;
		default:
			return false;
		
		}
		
	}

}
