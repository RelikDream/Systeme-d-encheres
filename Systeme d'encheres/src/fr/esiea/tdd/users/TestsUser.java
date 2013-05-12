package fr.esiea.tdd.users;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.poo.login.AbstractUser;
import fr.esiea.poo.login.UserType;
import fr.esiea.poo.login.UsersFactory;

public class TestsUser {

	private AbstractUser user1;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Start");
		user1 = UsersFactory.getInstance().createUser(UserType.SELLER, "Toto");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("End");
	}
	
	@Test
	public void inscription(){
		Assert.assertEquals("Toto", user1.getLogin());
	}
	
	@Test
	public void roleUser(){
		//TODO
		Assert.fail();
	}

}
