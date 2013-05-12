package fr.esiea.poo.login;

import java.util.ArrayList;
import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;
import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.auctionsystem.AuctionState;

public class Both extends AbstractUser {

	// @autor : Thomas Emmanuelle
	
	protected Both(String login) {
		super(login);
		// TODO 
	}


	@Override
	public boolean publishAuction(int id) {
		ArrayList<Auction> auctions = AuctionHouse.getinstance().getAuctions(null, AuctionState.CREATED);
		for(Auction a: auctions){
			if(a.getId()==id){
				try{
				a.setState(AuctionState.PUBLISHED);
				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		// TODO 
		return false;
	}


	@Override
	public int createAuction(String owner, int itemId, String itemDescription,
			double minPrice, Date deadline, double reservePrice)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
