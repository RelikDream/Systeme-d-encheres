package fr.esiea.poo.auctionsystem;

public class Offer {
	private String userLogin;
	private double price;
	
	public Offer(String user, int price){
		//TODO
	}
	
	protected String getUser(){
		return this.userLogin;
	}
	public double getPrice(){
		return this.price;
	}
}
