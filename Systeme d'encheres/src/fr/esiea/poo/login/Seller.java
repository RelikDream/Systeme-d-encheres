package fr.esiea.poo.login;

import fr.esiea.poo.auctionsystem.Auction;
import fr.esiea.poo.auctionsystem.AuctionState;
import fr.esiea.poo.auctionsystem.Item;

public class Seller extends AbstractUser {

	protected Seller(String login) {
		super(login);
		
	}

	@Override
	public int createAuction( ) {

	//Auction auction = new Auction(id, object, minPrice, minPrice);
		
		
		//TODO
		return 0;
	}

	@Override
	public boolean publishAuction(int id) {
	
		AuctionState actionState = AuctionState.PUBLISHED;
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}

}
