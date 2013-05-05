package fr.esiea.poo.login;

import fr.esiea.poo.auctionsystem.Auction;

public class Buyer extends AbstractUser {

	protected Buyer(String login) {
		super(login);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createAuction() throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean publishAuction(int id) throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}

}
