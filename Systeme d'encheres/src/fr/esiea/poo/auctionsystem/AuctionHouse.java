package fr.esiea.poo.auctionsystem;

import java.util.ArrayList;

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


	public boolean addAuction(int itemId, String itemDescription,int deadline){
		return this.addAuction(itemId, itemDescription, 0, deadline, 0);
	}
	public boolean addAuction(int itemId, String itemDescription,int deadline,double reservePrice){
		return this.addAuction(itemId, itemDescription, 0, deadline, reservePrice);
	}
	public boolean addAuction(int itemId, String itemDescription,double minPrice,int deadline){
		return this.addAuction(itemId, itemDescription, minPrice, deadline, 0);
	}
	public boolean addAuction(int itemId, String itemDescription,double minPrice,int deadline,double reservePrice){
		//TODO
		return false;
	}
	/**
	 * 
	 * @param orderBy
	 * @return
	 */
	public ArrayList<Auction> getAuctions(OrderBy orderBy){
		ArrayList<Auction> clone=(ArrayList<Auction>)this.auctions.clone();
		switch(orderBy){
		case DECREASING_MIN_PRICE:
			//TODO
			break;
		case DECREASING_OFFER:
			//TODO
			break;
		case DECREASING_RESERVE_PRICE:
			//TODO
			break;
		case INCREASING_MIN_PRICE:
			//TODO
			break;
		case INCREASING_OFFER:
			//TODO
			break;
		case INCREASING_RESERVE_PRICE:
			//TODO
			break;
		case STATE:
			//TODO
			break;
		case TIME_REMAINING:
			//TODO
			break;
		default:
			//TODO
			break;
		}
		return clone;
	}

	public boolean addOffer(int auctionId, double price,String userLogin){
		//TODO
		return false;
	}
}
