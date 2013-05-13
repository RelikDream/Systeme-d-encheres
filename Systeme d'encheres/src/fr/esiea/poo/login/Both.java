package fr.esiea.poo.login;

import java.util.ArrayList;
import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;
import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.auctionsystem.AuctionState;
import fr.esiea.poo.warning.Warning;
import fr.esiea.poo.warning.WarningType;

public class Both extends AbstractUser {

	// @autor : Thomas Emmanuelle
	
	protected Both(String login) {
		super(login);
	}


	@Override
	public boolean publishAuction(int id) {
		return AuctionHouse.getInstance().publishAuction(id, this.getLogin());
	}

	@Override
	public boolean sendOfferto(int price, int auctionId, boolean followed) throws Exception {
		if(followed)
			return AuctionHouse.getInstance().addOffer(auctionId, price, this.getLogin(),new Warning(this, WarningType.BETTER_OFFER));
		
		return AuctionHouse.getInstance().addOffer(auctionId, price, this.getLogin(),null);
	}


	@Override
	public void createAuction(int itemId, String itemDescription,double minPrice, Date deadline, double reservePrice)throws Exception {
		AuctionHouse.getInstance().addAuction(this.getLogin(), itemId, itemDescription, minPrice, deadline, reservePrice,new Warning(this,WarningType.OFFER_ON_AUCTION));
	}


	@Override
	public boolean cancelAuction(int auctionId) throws Exception {
		return AuctionHouse.getInstance().cancelAuction(this.getLogin(), auctionId);
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
