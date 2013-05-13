package fr.esiea.poo.login;

import java.util.Date;

import fr.esiea.poo.warning.WarningType;


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
	public void createAuction(int itemId,String itemDescription, Date deadline) throws Exception{
		this.createAuction(itemId, itemDescription, 0, deadline, 0);
	}
	public void createAuction(int itemId,String itemDescription, Date deadline,double reservePrice) throws Exception{
		this.createAuction(itemId, itemDescription, 0, deadline, reservePrice);
	}
	public void createAuction(int itemId,String itemDescription, double minPrice,Date deadline) throws Exception{
		this.createAuction(itemId, itemDescription, minPrice, deadline, 0);
		
	}
	public void warnMe(String msg){
		System.out.println(this.login +" received a warning:\n"+msg);
	}
	public abstract void createAuction(int itemId,String itemDescription, double minPrice,Date deadline,double reservePrice) throws Exception;
	public abstract boolean cancelAuction(int AuctionId)throws Exception;
	public abstract boolean publishAuction(int id) throws Exception;
	public abstract boolean sendOfferto(int price ,int auctionId, boolean followed) throws Exception;
	public abstract boolean addWarning(int aId, WarningType wt) throws Exception;
}
