package fr.esiea.poo.auctionsystem;

public enum AuctionState {
	CREATED("Etat Créée"),
	PUBLISHED("Etat Publiée"),
	CANCELLED("Etat annulée"),
	FINISHED("Etat Terminée");
	private String state;

	AuctionState(String state){
		this.state=state;
	}
	@Override
	public String toString(){
		return this.state;
	}
}
