package fr.esiea.poo.auctionsystem;

import java.util.Date;

public class Auction {
	private final int id;
	private final String owner;
	private final Item object;
	


	private final Date deadline;
	private AuctionState state;
	private final double minPrice;
	private final double reservePrice;
	
	protected Auction(String owner,int id, Item object, double minPrice, double reservePrice,Date deadline ){
		this.id = id;
		this.owner=owner;
		this.object = object;
		this.minPrice= minPrice;
		this.reservePrice = reservePrice;
		this.deadline=deadline;
		this.state=AuctionState.CREATED;
	}
	
	@Override
	public String toString(){
		//TODO Tranform Auction into a String
		return null;
	}
	
	public AuctionState getState() {
		return state;
	}

	public void setState(AuctionState state) {
		//TODO verify we can't change to fobbiden Auctions
		this.state = state;
	}

	public String getOwner() {
		return owner;
	}

	public Item getObject() {
		return object;
	}

	public Date getDeadline() {
		return deadline;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}
	public int getId(){
		return(id);
	}

}
