package fr.esiea.poo.auctionsystem;

public class Auction {
	private int id;
	private Item object;
	private Object deadline;
	private AuctionState state;
	private double minPrice;
	private double reservePrice;
	
	protected Auction(){
		//TODO
	}
	
	@Override
	public String toString(){
		//TODO
		return null;
	}

}
