package fr.esiea.poo.auctionsystem;

import java.util.ArrayList;
import java.util.Date;
import fr.esiea.poo.warning.*;

public class Auction {
	private final int id;
	private final String owner;
	private final Item object;
	private final Date deadline;
	private AuctionState state;
	private final double minPrice;
	private final double reservePrice;
	private Offer currentOffer;
	private ArrayList<Warning> warn;

	protected Auction(String owner,int id, Item object, double minPrice, double reservePrice,Date deadline ){
		this.id = id;
		this.owner=owner;
		this.object = object;
		this.minPrice= minPrice;
		this.reservePrice = reservePrice;
		this.deadline=deadline;
		this.state=AuctionState.CREATED;
		this.currentOffer=new Offer("",minPrice,null);
		this.warn=new ArrayList<Warning>();
	}

	protected void addWarning(Warning w){
		this.warn.add(w);
	}
	private ArrayList<Warning> getWarning(WarningType t){
		if(t==null)
			return (ArrayList<Warning>) this.warn.clone();
		ArrayList<Warning> warn=new ArrayList<Warning>();
		for(Warning w: this.warn){
			if(w.getType().equals(t))
				warn.add(w);
		}
		return warn;
		
	}
	public Offer getCurrentOffer() {
		return currentOffer;
	}

	public AuctionState getState() {
		return state;
	}

	protected void setState(AuctionState state) throws Exception {
		switch (state){
		case CANCELLED:
			if(this.state==AuctionState.FINISHED)
				throw new Exception("You can't cancelled a finished auction");
			ArrayList<Warning>warn=this.getWarning(WarningType.AUCTION_CANCELED);
			for(Warning w:warn){
				w.sendWarning(this.id);
				this.warn.remove(w);
			}
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
		if(this.state!=AuctionState.PUBLISHED)
			throw new Exception("The auction must be published to put an offer on it");
		if(this.currentOffer.getPrice()<o.getPrice()){
			this.currentOffer.warn(this.id);
			this.currentOffer=o;
			if(this.isReservePriceReached()){
				ArrayList<Warning>warn=this.getWarning(WarningType.RESERVE_PRICE_REACHED);
				for(Warning w:warn){
					w.sendWarning(this.id);
					this.warn.remove(w);
				}
			}
			ArrayList<Warning>warn=this.getWarning(WarningType.OFFER_ON_AUCTION);
			for(Warning w:warn){
				w.sendWarning(this.id);
			}
		}
		else
			throw new Exception("Offer prive is lower than the actual offer on this auction");
	}
}
