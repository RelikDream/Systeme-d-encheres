package fr.esiea.tdd.users;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.login.AbstractUser;
import fr.esiea.poo.login.UserType;
import fr.esiea.poo.login.UsersFactory;

public class TestsUser {

	private AbstractUser seller;
	private AbstractUser buyer;
	private AbstractUser both;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Start");
		this.seller = UsersFactory.getInstance().createUser(UserType.SELLER, "Toto");
		this.buyer = UsersFactory.getInstance().createUser(UserType.BUYER, "Tata");
		this.both = UsersFactory.getInstance().createUser(UserType.BOTH, "Titi");
		AuctionHouse.getInstance().clearAuctions();
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("End");
	}
	
	@Test
	public void inscription(){
		Assert.assertEquals("Toto", seller.getLogin());
		Assert.assertEquals("Tata", buyer.getLogin());
		Assert.assertEquals("Titi", both.getLogin());
	}
	@Test
	public void testSellerCreateAuction() throws Exception{
		this.seller.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));
	}
	@Test(expected=Exception.class)
	public void testBuyerCreateAuction() throws Exception{
		this.buyer.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));	
	}
	@Test
	public void testBothCreateAuction() throws Exception{
		this.both.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));	
	}
	@Test(expected=Exception.class)
	public void testSellerSendOffer() throws Exception{
		try {
			this.both.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.seller.sendOfferto(1000, AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId());
		
	}
	@Test
	public void testBuyerSendOffer() throws Exception{
		try {
			this.seller.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.buyer.sendOfferto(1000, AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId());
		
	}
	@Test
	public void testBothSendOffer() throws Exception{
		try {
			this.seller.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.both.sendOfferto(1000, AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId());
		
	}
	

}
