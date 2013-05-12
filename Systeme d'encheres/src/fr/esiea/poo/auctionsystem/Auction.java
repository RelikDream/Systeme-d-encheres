package fr.esiea.poo.auctionsystem;

public class Auction {
	private int id;
	private Item object;
	private Object deadline;
	private AuctionState state;
	private double minPrice;
	private double reservePrice;
	
	protected Auction(int id, Item object, double minPrice, double reservePrice ){
		this.id = id;
		this.object = object;
		this.minPrice= minPrice;
		this.reservePrice = reservePrice;
		//TODO
	}
	
	@Override
	public String toString(){
		//TODO
		return null;
	}

}
