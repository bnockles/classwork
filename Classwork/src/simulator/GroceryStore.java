package simulator;

import java.util.List;

public abstract class GroceryStore implements Place{

	public static final double STORE_STARTING_AMOUNT=100000 + Environment.getRelocateCost(0,0); 
	
	protected final Inventory inventory = new Inventory(STORE_STARTING_AMOUNT);
	protected final Inventory discardedInventory = new Inventory(0);
	//location is final. Location can be set only by calling the "relocate" method
	protected Location location;
	protected List<Distributor> distributors;
	
	public final Location getLocation(){return location;}
	
	
	/**
	 * 
	 * @param list
	 * @return total cost of all items on list. Note: lists are always purchased in full. 
	 * Price does not have to be linear and may even be a combination: i.e. "buy two items, get one free" 
	 */
	abstract double estimateCost(GroceryList list);

	/**
	 * Note: a population will not buy groceries at a store whose freshness standard is below that population's requirement.
	 * Further
	 * @return the freshness standard, a double describing the lowest-quality food that can be sold by this store
	 */
	abstract double getFreshness();
	
	public final List<Food> sell(GroceryList list) {
		return inventory.sell(list, estimateCost(list));
	}
	


	/**
	 * this method gets called every single "day"
	 * In it you can reorder supplies from the distributors
	 */
	public final void lapse(){
		inventory.lapse();//food ages each day after it is purchased from distributors
		inventory.sortByFreshness();
		inventory.discardNonfreshFood(getFreshness(), discardedInventory);//food that is below this store's freshness standard gets moved to the discardedInventory
		orderSupplies();
	}
	
	/**
	 * Is called after every call of lapse() method (called every day). Should determine whether or not supplies need to be ordered,
	 * where to order them, and how much to order. See the Distributor interface for additional details on how food can be ordered
	 */
	abstract void orderSupplies();

	public String toString(){
		return "the store at "+location;
	}
	
}
