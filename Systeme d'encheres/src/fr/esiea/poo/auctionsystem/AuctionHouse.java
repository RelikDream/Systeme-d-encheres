package fr.esiea.poo.auctionsystem;

public class AuctionHouse {
	private static AuctionHouse instance;
	
	public static AuctionHouse getinstance(){
		if(instance==null)
			instance = new AuctionHouse();
		return instance;
	}
}
