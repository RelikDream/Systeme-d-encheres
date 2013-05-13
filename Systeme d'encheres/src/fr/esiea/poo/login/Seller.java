package fr.esiea.poo.login;

import java.util.ArrayList;
import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;
import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.auctionsystem.AuctionState;

public class Seller extends AbstractUser {

	protected Seller(String login) {
		super(login);
		
	}


	@Override
	public boolean publishAuction(int id) {
		ArrayList<Auction> auctions = AuctionHouse.getInstance().getAuctions(AuctionState.CREATED);
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
		throw new Exception("you are not allowed to send an offer !");
	}


	@Override
	public void createAuction(int itemId, String itemDescription,double minPrice, Date deadline, double reservePrice)throws Exception {
		AuctionHouse.getInstance().addAuction(this.getLogin(), itemId, itemDescription, minPrice, deadline, reservePrice);
	}


	@Override
	public boolean cancelAuction(int auctionId) throws Exception {
		return AuctionHouse.getInstance().cancelAuction(this.getLogin(), auctionId);
	}
}
