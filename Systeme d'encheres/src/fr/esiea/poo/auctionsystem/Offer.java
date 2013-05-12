package fr.esiea.poo.auctionsystem;

public class Offer {
	private final String userLogin;
	private final double price;
	public Offer(String userLogin, double price) {
		this.userLogin=userLogin;
		this.price=price;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public double getPrice() {
		return price;
	}

}
