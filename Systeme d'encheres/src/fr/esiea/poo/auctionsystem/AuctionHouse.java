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
		Auction auction= new Auction(owner, 0/*TODO Create a unique code*/, new Item(itemId, itemDescription), minPrice, reservePrice, deadline);
		this.auctions.add(auction);
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
		new Offer(userLogin,price);
		//TODO
		
		return false;
	}
}
