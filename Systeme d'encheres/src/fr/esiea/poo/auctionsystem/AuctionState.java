package fr.esiea.poo.auctionsystem;

public enum AuctionState {
	CREATED("Etat Cr��e"),
	PUBLISHED("Etat Publi�e"),
	CANCELLED("Etat annul�e"),
	FINISHED("Etat Termin�e");
	private String state;

	AuctionState(String state){
		this.state=state;
	}
	@Override
	public String toString(){
		return this.state;
	}
}
