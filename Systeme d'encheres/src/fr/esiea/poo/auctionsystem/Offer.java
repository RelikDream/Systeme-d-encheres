package fr.esiea.poo.auctionsystem;

public class Offer {
	private String userLogin;
	private int price;
	
	public Offer(String user, int price){
		//TODO
	}
	
	protected String getUser(){
		return this.userLogin;
	}
	public int getPrice(){
		return this.price;
	}
}
