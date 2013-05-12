package fr.esiea.poo.auctionsystem;

import java.util.ArrayList;
import java.util.Date;

public class AuctionHouse {
	public enum OrderBy {
		STATE,
		DECREASING_OFFER,
		INCREASING_OFFER,
		DECREASING_MIN_PRICE,
		INCREASING_MIN_PRICE,
		DECREASING_RESERVE_PRICE,
		INCREASING_RESERVE_PRICE,
		TIME_REMAINING;
	}
	private static AuctionHouse instance;
	
	private ArrayList<Auction> auctions;
	public static AuctionHouse getinstance(){
		if(instance==null)
			instance = new AuctionHouse();
		return instance;
	}

	private AuctionHouse(){
		this.auctions=new ArrayList<Auction>();
	}


	public void addAuction(String owner,int itemId, String itemDescription,Date deadline){
		this.addAuction(owner, itemId, itemDescription, 0, deadline, 0);
	}
	public void addAuction(String owner,int itemId, String itemDescription,Date deadline,double reservePrice){
		this.addAuction(owner, itemId, itemDescription, 0, deadline, reservePrice);
	}
	public void addAuction(String owner,int itemId, String itemDescription,double minPrice,Date deadline){
		this.addAuction(owner,itemId, itemDescription, minPrice, deadline, 0);
	}
	public void addAuction(String owner,int itemId, String itemDescription,double minPrice,Date deadline,double reservePrice){
		Auction auction= new Auction(owner, this.auctions.size(), new Item(itemId, itemDescription), minPrice, reservePrice, deadline);
		this.auctions.add(auction);
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Auction> getAuctions(AuctionState state){
		ArrayList<Auction> clone;
		
		if(state==null)
			clone=(ArrayList<Auction>) this.auctions.clone();
		
		else{	
			clone= new ArrayList<Auction>();
			for(Auction a: this.auctions){
				if(a.getState()==state)
					clone.add(a);
			}
		}
		return clone;
	}

	public boolean addOffer(int auctionId, double price,String userLogin){
		ArrayList<Auction> auctions=this.getAuctions(AuctionState.PUBLISHED);
		Auction auction=null;
		for(Auction a: auctions){
			if(a.getId()==auctionId)
				auction=a;
				break;
		}
		if (auction==null)
			return false;
		try {
			auction.updateOffer(new Offer(userLogin,price));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
