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
	}


	@Override
	public boolean publishAuction(int id) {
		ArrayList<Auction> auctions = AuctionHouse.getinstance().getAuctions(AuctionState.CREATED);
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
	public boolean sendOfferto(int price, int auctionId) throws Exception {
		return AuctionHouse.getinstance().addOffer(auctionId, price, this.getLogin());
	}


	@Override
	public void createAuction(int itemId, String itemDescription,double minPrice, Date deadline, double reservePrice)throws Exception {
		AuctionHouse.getinstance().addAuction(this.getLogin(), itemId, itemDescription, minPrice, deadline, reservePrice);
	}

}
