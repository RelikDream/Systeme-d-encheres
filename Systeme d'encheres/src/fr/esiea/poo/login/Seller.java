package fr.esiea.poo.login;

import fr.esiea.poo.auctionsystem.Auction;

public class Seller extends AbstractUser {

	protected Seller(String login) {
		super(login);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createAuction() {
		//TODO
		return 0;
	}

	@Override
	public boolean publishAuction(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		throw new Exception("you are not allowed to send an offer !");
	}

}
