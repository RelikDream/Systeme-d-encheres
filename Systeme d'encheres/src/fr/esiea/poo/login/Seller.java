package fr.esiea.poo.login;

import java.util.ArrayList;
import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;
import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.auctionsystem.AuctionState;
import fr.esiea.poo.warning.Warning;
import fr.esiea.poo.warning.WarningType;

public class Seller extends AbstractUser {

	protected Seller(String login) {
		super(login);
		
	}


	@Override
	public boolean publishAuction(int id) {
		return AuctionHouse.getInstance().publishAuction(id, this.getLogin());
	}

	@Override
	public boolean sendOfferto(int price, int auctionId, boolean followed) throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}


	@Override
	public void createAuction(int itemId, String itemDescription,double minPrice, Date deadline, double reservePrice )throws Exception {
		AuctionHouse.getInstance().addAuction(this.getLogin(), itemId, itemDescription, minPrice, deadline, reservePrice,new Warning(this,WarningType.OFFER_ON_AUCTION));
		
	}


	@Override
	public boolean cancelAuction(int auctionId) throws Exception {
		return AuctionHouse.getInstance().cancelAuction(this.getLogin(), auctionId);
	}
	@Override
	public boolean addWarning(int aId, WarningType wt) throws Exception{
		throw new Exception("you are not allowed to put optionals warnings");
	}
}
