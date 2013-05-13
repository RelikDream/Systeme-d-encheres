package fr.esiea.poo.login;

import java.util.Date;

import fr.esiea.poo.auctionsystem.AuctionHouse;


public class Buyer extends AbstractUser {

	protected Buyer(String login) {
		super(login);
	}

	@Override
	public boolean sendOfferto(int price, int auctionId) throws Exception {
		return AuctionHouse.getInstance().addOffer(auctionId, price, this.getLogin());
	}

	@Override
	public boolean publishAuction(int id) throws Exception {
		throw new Exception("you are not allowed to publish an auction !");
	}

	@Override
	public void createAuction(int itemId, String itemDescription, double minPrice, Date deadline, double reservePrice) throws Exception {
		throw new Exception("You are not allowed to create an auction !");
	}

	@Override
	public boolean cancelAuction(int AuctionId) throws Exception {
		throw new Exception("you are not allowed to cancel an auction !");
	}

}
