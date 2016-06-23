package simulator;

public class LowerClass extends Population {

	
	public LowerClass(Location loc){
		this.location = loc;
		inventory= new Inventory(0);
		storesByDistance= loc.getCity().getStoresByProximity(loc);
		luxuryNeed = 7;
		essentialNeed = 21;
		luxuryCapacity = 10;
		essentialCapacity = 25;
		preferedShoppingDay1 = 6;
		luxuryConsumptionPerDay=1;
		essentialConsumptionPerDay=3;
		freshnessStandard = .3;
	}
}
