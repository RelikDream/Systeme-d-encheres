package fr.esiea.tdd.auctions;


import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.poo.auctionsystem.AuctionHouse;
import fr.esiea.poo.auctionsystem.Item;
import fr.esiea.poo.auctionsystem.Offer;
import fr.esiea.poo.login.AbstractUser;
import fr.esiea.poo.login.UserType;
import fr.esiea.poo.login.UsersFactory;


public class TestsAuction {

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
	public void testItemRecognition(){
		Item i=new Item(1,"description");
		Assert.assertTrue(1==i.getId());
		Assert.assertFalse(2==i.getId());
	}
	@Test
	public void testOfferRecognition(){
		Offer o= new Offer(this.buyer.getLogin(),1000);
		Assert.assertTrue(o.getUserLogin()==this.buyer.getLogin()&&o.getPrice()==1000);
		Assert.assertFalse(o.getUserLogin()==this.seller.getLogin()&&o.getPrice()==1000);
		Assert.assertFalse(o.getUserLogin()==this.buyer.getLogin()&&o.getPrice()==9999);
		Assert.assertFalse(o.getUserLogin()==this.seller.getLogin()&&o.getPrice()==9999);
		
	}
	@Test
	public void testAuctionRecognition(){
		try {
			this.seller.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));
			Assert.assertNotNull(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testOffer(){
		try {
			this.seller.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertFalse(this.buyer.sendOfferto(1000,AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId()));
			this.seller.publishAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId());
			Assert.assertTrue(this.buyer.sendOfferto(1000,AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId()));
			
		} catch (Exception e) {
			Assert.fail();
		}		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCancelAuction(){
		try {
			this.seller.createAuction(1, "Descritption de l'objet d'id 1",new Date(2013, 06, 02, 13, 13),1000);
			this.seller.publishAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId());
			Assert.assertTrue(this.seller.cancelAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 13)).getId()));
			this.seller.createAuction(2, "Descritption de l'objet d'id 2",new Date(2013, 06, 02, 13, 14),1000);
			this.seller.publishAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getId());
			this.buyer.sendOfferto(1001, AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getId());
			Assert.assertFalse(this.seller.cancelAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getId()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test (expected=Exception.class)
	public void testReservePriceAccessDenied() throws Exception{
		try {
			this.seller.createAuction(2, "Descritption de l'objet d'id 2",new Date(2013, 06, 02, 13, 14),1000);
			this.seller.publishAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getReservePrice(this.buyer.getLogin());
	}
	@Test
	public void testReservePriceAccessGranted() throws Exception{
		try {
			this.seller.createAuction(2, "Descritption de l'objet d'id 2",new Date(2013, 06, 02, 13, 14),1000);
			this.seller.publishAuction(AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		AuctionHouse.getInstance().getAuction(new Date(2013, 06, 02, 13, 14)).getReservePrice(this.seller.getLogin());
	}
}
