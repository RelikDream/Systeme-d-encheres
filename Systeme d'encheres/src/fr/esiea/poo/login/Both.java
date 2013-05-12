package fr.esiea.poo.login;

import fr.esiea.poo.auctionsystem.Auction;

public class Both extends AbstractUser {

	// @autor : Emmanuelle
	
	protected Both(String login) {
		super(login);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createAuction() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean publishAuction(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendOfferto(int price, Auction auction) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
