package fr.esiea.poo.auctionsystem;

import java.util.ArrayList;
import java.util.Date;

import fr.esiea.poo.warning.Warning;

public class AuctionHouse {

	private static AuctionHouse instance;

	private ArrayList<Auction> auctions;
	public static AuctionHouse getInstance(){
		if(instance==null)
			instance = new AuctionHouse();
		return instance;
	}

	private AuctionHouse(){
		this.auctions=new ArrayList<Auction>();
	}
	public Auction getAuction(Date date){
		for(Auction a: this.auctions){
			if (a.getDeadline().equals(date))
				return a;
		}
		return null;
	}
	public Auction getAuction(int aId){
		for(Auction a: this.auctions){
			if (a.getId()==aId)
				return a;
		}
		return null;
	}
	public void addWarning(int aId, Warning w){
		this.getAuction(aId).addWarning(w);
	}
	public void addAuction(String owner,int itemId, String itemDescription,double minPrice,Date deadline,double reservePrice,Warning warning){
		Auction auction= new Auction(owner, this.auctions.size(), new Item(itemId, itemDescription), minPrice, reservePrice, deadline);
		auction.addWarning(warning);
		this.auctions.add(auction);
	}
	public boolean cancelAuction(String username,int auctionId){
		for(Auction a:this.auctions){
			if(a.getId()==auctionId){
				if(!(a.isReservePriceReached())|| a.getCurrentOffer().getUserLogin().equals("")){
					try {
						a.setState(AuctionState.CANCELLED);
						return true;
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}

				}
				else
					return false;
			}
		}
		return false;
	}
	public boolean publishAuction(int id ,String username) {
		ArrayList<Auction> auctions = AuctionHouse.getInstance().getAuctions(AuctionState.CREATED);
		for(Auction a: auctions){
			if(a.getId()==id && a.getOwner().equals(username)){
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
	public void clearAuctions(){
		this.auctions.clear();
	}
	public ArrayList<Auction> getAuctions(AuctionState state){
		ArrayList<Auction> clone=null;

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

	public boolean addOffer(int auctionId, double price,String userLogin, Warning w){
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
			auction.updateOffer(new Offer(userLogin,price,w));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
