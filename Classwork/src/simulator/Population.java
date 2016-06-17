package simulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Population {

	protected static final int NEED_LUXURY = 0;
	protected static final int NEED_ESSENTIAL = 1;
	protected static final int NEED_ALL = 2;
	
	protected double luxuryNeed;
	protected double essentialNeed;
	protected int preferedShoppingDay1;
	protected int preferedShoppingDay2;

	
	protected int luxuryConsumptionPerDay;
	protected int essentialConsumptionPerDay;
	
	protected Location location;
	protected int luxuryInventory;
	protected int essentialInventory;
	protected List<GroceryStore> storesByDistance;
	
	
	
	/**
	 * depletes food supply and decides whether or not to shop for groceries
	 * called after ever iteration 
	 */
	public void lapse() {
		reduceFood();
		goShoppingFor(assessNeeds());
	}

	protected void reduceFood() {
		luxuryInventory -= luxuryConsumptionPerDay;
		essentialInventory -= essentialConsumptionPerDay;
	}

	protected void goShoppingFor(List<ShoppingItenerary> lists) {
		ShoppingItenerary selected = selectBestItenerary(lists);
		GroceryStore selectedBusiness = selected.getStore();
		selectedBusiness.sell(selected.getList());
		luxuryInventory += selected.getList().getLuxury();
		essentialInventory += selected.getList().getEssential();
	}

	private ShoppingItenerary selectBestItenerary(List<ShoppingItenerary> lists) {
		lists.sort(new Comparator<ShoppingItenerary>() {

			public int compare(ShoppingItenerary o1, ShoppingItenerary o2) {
				return o1.compareTo(o2);
			}
		});
		return lists.get(0);
	}


	
	/**
	 * 
	 * The highest priority of a population is to have enough to to survive for another day.
	 * In a situation where not shopping would cause reduceFood() to dip into negative values, the population will ALWAYS go shopping
	 * Preference is given to shopping for enough food to last until the preferred shopping day
	 * On the preferred shopping day, the cost of travel is cut in half
	 * 
	 * @return several possible Iteneraries that would satisfy needs
	 */
	protected List<ShoppingItenerary> assessNeeds() {
		
		double priority=0;
		if(luxuryInventory-luxuryConsumptionPerDay<0)priority=1;
		if(essentialInventory-essentialConsumptionPerDay<0)priority=1;
		
		
		ArrayList<ShoppingItenerary> possibleOptions = new ArrayList<ShoppingItenerary>();
		addOption(1, possibleOptions, priority);
		return possibleOptions;
	}

	private void addOption(int numberOfDays, ArrayList<ShoppingItenerary> possibleOptions, double priority ) {
		double travelCoef = 1.0;
		if(location.getCity().getDay()==preferedShoppingDay1 || location.getCity().getDay()==preferedShoppingDay1)travelCoef=.5;
		GroceryList list = new GroceryList(luxuryConsumptionPerDay*numberOfDays,essentialConsumptionPerDay*numberOfDays);
		for(GroceryStore g: storesByDistance){
			possibleOptions.add(new ShoppingItenerary(location, travelCoef, g, list, priority));			
		}
	}


	//returns 





}
