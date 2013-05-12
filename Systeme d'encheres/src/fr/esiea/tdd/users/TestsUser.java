package fr.esiea.tdd.users;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	//TODO peut etre mettre les test de creation encheres offres ici
	

}
