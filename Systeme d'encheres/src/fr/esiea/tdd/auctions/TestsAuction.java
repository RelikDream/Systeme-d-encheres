package fr.esiea.tdd.auctions;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.poo.login.AbstractUser;
import fr.esiea.poo.login.UserType;
import fr.esiea.poo.login.UsersFactory;


public class TestsAuction {

	private AbstractUser user1;
	private AbstractUser user2;
	private AbstractUser user3;

	@Before
	public void setUp() throws Exception {
		System.out.println("Appel setUp");
		UsersFactory usersFactory=UsersFactory.getInstance();
		user1 = usersFactory.createUser(UserType.SELLER, "Tata");
		user2 = usersFactory.createUser(UserType.BUYER, "Toto");
		user3 = usersFactory.createUser(UserType.BOTH, "Titi");	
		
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Appel tearDown");
		
	}
	@Test
	public void inscription(){
		Assert.assertEquals("Jean Paul", user1.getLogin());
		Assert.assertEquals("Jean Jacques", user2.getLogin());

	}	
	@Test
	public void createAuctionSeller(){
		//TODO 
		Assert.fail();
		}
	@Test
	public void createAuctionBuyer(){
		//TODO 
		Assert.fail();
		}
	@Test
	public void createAuctionBoth(){
		//TODO 
		Assert.fail();
		}
	@Test
	public void createOfferSeller(){
		//TODO 
		Assert.fail();	
		}
	@Test
	public void createOfferBuyer(){
		//TODO 
		Assert.fail();	
		}
	@Test
	public void createOfferBoth(){
		//TODO 
		Assert.fail();	
		}
	@Test
	public void creationAlerte(){
		//TODO 
		Assert.fail();
		}
}
