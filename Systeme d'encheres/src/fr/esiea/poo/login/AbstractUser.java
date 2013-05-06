package fr.esiea.poo.login;

import fr.esiea.poo.auctionsystem.Auction;

/**
 * 
 * @author Thomas Emmanuelle
 *
 */
public abstract class AbstractUser {
	private String login;
	private String name;
	private String firstName;
	
	protected AbstractUser(String login){
		this.login=login;
	}
	public abstract int createAuction() throws Exception;
	public abstract boolean publishAuction(int id) throws Exception;
	public abstract boolean sendOfferto(int price ,Auction auction) throws Exception;
}
