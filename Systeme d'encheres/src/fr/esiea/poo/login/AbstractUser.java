package fr.esiea.poo.login;

import java.util.Date;

import fr.esiea.poo.auctionsystem.Auction;

/**
 * 
 * @author Thomas Emmanuelle
 *
 */
public abstract class AbstractUser {
	public String getLogin() {
		return login;
	}
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstName;
	}
	private String login;
	private String name;
	private String firstName;
	
	protected AbstractUser(String login){
		this.login=login;
	}
	public int createAuction(String owner,int itemId, String itemDescription, Date deadline) throws Exception{
		return this.createAuction(owner, itemId, itemDescription, 0, deadline, 0);
	}
	public int createAuction(String owner,int itemId, String itemDescription,Date deadline,double reservePrice) throws Exception{
		return this.createAuction(owner, itemId, itemDescription, 0, deadline, reservePrice);
	}
	public int createAuction(String owner,int itemId, String itemDescription,double minPrice,Date deadline) throws Exception{
		return this.createAuction(owner, itemId, itemDescription, minPrice, deadline, 0);
		
	}
	public abstract int createAuction(String owner,int itemId, String itemDescription,double minPrice,Date deadline,double reservePrice) throws Exception;
	public abstract boolean publishAuction(int id) throws Exception;
	public abstract boolean sendOfferto(int price ,Auction auction) throws Exception;
}
