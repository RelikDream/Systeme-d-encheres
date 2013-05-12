package fr.esiea.poo.login;

import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;

public class Buyer extends AbstractUser {

	protected Buyer(String login) {
		super(login);
		// TODO 
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		// TODO
		return false;
	}

	@Override
	public boolean publishAuction(int id) throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}

	@Override
	public int createAuction(String owner, int itemId, String itemDescription, double minPrice, Date deadline, double reservePrice) throws Exception {
		throw new Exception("You are not allowed to send an offer !");
	}

}
