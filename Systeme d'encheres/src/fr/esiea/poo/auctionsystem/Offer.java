package fr.esiea.poo.auctionsystem;

import fr.esiea.poo.warning.Warning;

public class Offer {
	private final String userLogin;
	private final double price;
	private final Warning warning;
	public Offer(String userLogin, double price, Warning warning) {
		this.userLogin=userLogin;
		this.price=price;
		this.warning=warning;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public double getPrice() {
		return price;
	}
	public void warn(int aId){
		this.warning.sendWarning(aId);
	}

}
