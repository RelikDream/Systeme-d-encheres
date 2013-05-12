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
	private Offer currentOffer;

	protected Auction(String owner,int id, Item object, double minPrice, double reservePrice,Date deadline ){
		this.id = id;
		this.owner=owner;
		this.object = object;
		this.minPrice= minPrice;
		this.reservePrice = reservePrice;
		this.deadline=deadline;
		this.state=AuctionState.CREATED;
		this.currentOffer=new Offer("",minPrice);
	}

	public AuctionState getState() {
		return state;
	}

	public void setState(AuctionState state) throws Exception {
		switch (state){
		case CANCELLED:
			if(this.state==AuctionState.FINISHED)
				throw new Exception("You can't cancelled a finished auction");
			break;
		case CREATED:
			throw new Exception("You can't change a auction to a created state");
		case FINISHED:
			if(this.state!=AuctionState.PUBLISHED)
				throw new Exception("An auction need to be published before it can be finished");
			break;
		case PUBLISHED:
			if(this.state!=AuctionState.CREATED)
				throw new Exception("You need to have a newly created auction to publish it");
			break;
		default:
			throw new Exception("Invalid argument");

		}
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

	public double getReservePrice(String username) throws Exception {
		if(username.equals(this.owner))
			return reservePrice;
		throw new Exception("You are not the owner of this auction");
	}
	public boolean isReservePriceReached(){
		return currentOffer.getPrice()>=this.reservePrice;
				
	}
	public int getId(){
		return(id);
	}

	public void updateOffer(Offer o) throws Exception{
		if(this.currentOffer.getPrice()<o.getPrice())
			this.currentOffer=o;
		else
			throw new Exception("Offer prive is lower than the actual offer on this auction");
	}
}
