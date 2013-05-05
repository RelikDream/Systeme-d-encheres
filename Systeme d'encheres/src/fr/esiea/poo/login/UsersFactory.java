package fr.esiea.poo.login;

import java.security.InvalidParameterException;

/**
 * 
 * @author Thomas
 *
 */
public class UsersFactory {
	private static UsersFactory instance;
	
	public static UsersFactory getInstance(){
		if (instance==null)
			instance = new UsersFactory();
		return instance;
	}
	
	private UsersFactory(){
		super();
	}
	
	public AbstractUser createUser(UserType t, String login){
		switch (t){
		case SELLER:
			return new Seller(login);
		case BUYER:
			return new Buyer(login);
		case BOTH:
			return new Both(login);
		default:
			throw new InvalidParameterException("This UserType is not available !");
		
		}
	}
	
	
}
