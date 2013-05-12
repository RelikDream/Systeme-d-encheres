package fr.esiea.poo.login;

import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;
import fr.esiea.poo.auctionsystem.AuctionState;
import fr.esiea.poo.auctionsystem.Item;

public class Seller extends AbstractUser {

	protected Seller(String login) {
		super(login);
		
	}


	@Override
	public boolean publishAuction(int id) {
	
		AuctionState actionState = AuctionState.PUBLISHED;
		
		// TODO
		return false;
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}


	@Override
	public int createAuction(String owner, int itemId, String itemDescription,
			double minPrice, Date deadline, double reservePrice)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
