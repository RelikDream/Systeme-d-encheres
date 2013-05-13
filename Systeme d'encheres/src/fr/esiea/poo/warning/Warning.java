package fr.esiea.poo.warning;

import fr.esiea.poo.login.AbstractUser;

public class Warning {
	private final AbstractUser user;
	private final WarningType type;
	private boolean isActive;
	
	public Warning(AbstractUser u, WarningType wt){
		this.user=u;
		this.type=wt;
		this.isActive=true;
	}
	
	public void sendWarning(int aId){
		if(this.isActive){
			switch(this.type){
			case AUCTION_CANCELED:
				this.user.warnMe("The auction "+aId+" is canceled");
				break;
			case BETTER_OFFER:
				this.user.warnMe("A better offer has been done on the action "+aId);
				break;
			case OFFER_ON_AUCTION:
				this.user.warnMe("An offer has been done on your action "+aId);
				break;
			case RESERVE_PRICE_REACHED:
				this.user.warnMe("The action "+aId+" have reached the reserve price");
				break;
			default:			
			}
		}
	}
	public void enable(){
		this.isActive=true;
	}
	public void disable(){
		this.isActive=false;
	}
	public boolean isActive(){
		return this.isActive;
	}
	public WarningType getType(){
		return this.type;
	}
	
}
