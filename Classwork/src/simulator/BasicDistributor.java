package simulator;

import java.util.ArrayList;
import java.util.List;

public class BasicDistributor implements Distributor {

	final Location location;


	public BasicDistributor(Location loc) {
		this.location=loc;
	}

	public double getQuote(final int numberOfLuxury, final int numberOfEssential, final double minFreshness) {
		return numberOfLuxury*Food.LUXURY + numberOfEssential*Food.ESSENTIAL;
	}

	public final List<Food> getOrder(final Account purchasingAccount, final int numberOfLuxury, final int numberOfEssential, final double minFreshness){
		if(purchasingAccount.getAmmount() >= getQuote(numberOfLuxury, numberOfEssential, minFreshness)){
			purchasingAccount.decrease(getQuote(numberOfLuxury, numberOfEssential, minFreshness));
			List<Food> order = new ArrayList<Food>();
			for(int i = 0; i < numberOfLuxury; i++){
				order.add(new LuxuryFood(Math.random()*(1.0-minFreshness) + minFreshness));
			}
			for(int i = 0; i < numberOfEssential; i++){
				order.add(new EssentialFood(Math.random()*(1.0-minFreshness) + minFreshness));
			}
			return order;
		}else return null;
	}

	public final Location getLocation(){
		return location;
		
	}
}
