package simulator;

import java.util.List;

public abstract class GroceryStore{

	public static final double STORE_STARTING_AMOUNT=100000 + Environment.getRelocateCost(0,0); 
	
	protected final Inventory inventory = new Inventory(STORE_STARTING_AMOUNT);
	//location is final. Location can be set only by calling the "relocate" method
	protected final Location location = new Location(Manhattan.getInstance(), 0,0);
	
	
	final Location getLocation(){return location;}
	
	
	/**
	 * 
	 * @param list
	 * @return total cost of all items on list. Note: lists are always purchased in full. 
	 * Price does not have to be linear and may even be a combination: i.e. "buy two items, get one free" 
	 */
	abstract double estimateCost(GroceryList list);


	public final void sell(GroceryList list) {
		inventory.sell(list, estimateCost(list));
	}


	/**
	 * this method gets called every single "day"
	 * In it you can reorder supplies from the distributors
	 */
	public abstract void lapse();
	


	
}
