package simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Population {

	protected static final int NEED_LUXURY = 0;
	protected static final int NEED_ESSENTIAL = 1;
	protected static final int NEED_ALL = 2;

	protected double luxuryNeed;
	protected double essentialNeed;
	protected int luxuryCapacity;
	protected int essentialCapacity;
	protected int preferedShoppingDay1;


	protected int luxuryConsumptionPerDay;
	protected int essentialConsumptionPerDay;

	protected Location location;
	protected Inventory inventory;
	protected List<GroceryStore> storesByDistance;



	/**
	 * depletes food supply and decides whether or not to shop for groceries
	 * called after ever iteration 
	 */
	public void lapse() {
		reduceFood();
		throwAwayExpiredFood();
		List<ShoppingItenerary> possibleTrips = assessNeeds();
		if (!possibleTrips.isEmpty())goShoppingFor(possibleTrips);
	}

	private void throwAwayExpiredFood() {
		inventory.lapse();
		inventory.discardNonfreshFood(.05, null);
	}

	protected void reduceFood() {
		inventory.sortByOldest();
		for(int i = 0; i < luxuryConsumptionPerDay; i++){
			inventory.consumeLux();
		}
		for(int i = 0; i < essentialConsumptionPerDay; i++){
			inventory.consumeEss();
		}
	}

	protected void goShoppingFor(List<ShoppingItenerary> lists) {
		ShoppingItenerary selected = selectBestItenerary(lists);
		GroceryStore selectedBusiness = selected.getStore();
		List<Food> products = selectedBusiness.sell(selected.getList());
		inventory.buy(products, selectedBusiness.estimateCost(selected.getList()));			


	}

	private ShoppingItenerary selectBestItenerary(List<ShoppingItenerary> lists) {
		lists.sort(new Comparator<ShoppingItenerary>() {

			public int compare(ShoppingItenerary o1, ShoppingItenerary o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("Testing sort method of iteneraries in Population. Best choice is "+lists.get(0).getStore().estimateCost(lists.get(0).getList())+
				"while least is "+lists.get(lists.size()-1).getStore().estimateCost(lists.get(lists.size()-1).getList()));
		
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

		ArrayList<ShoppingItenerary> possibleOptions = new ArrayList<ShoppingItenerary>();
		if(inventory.getLuxury()-luxuryConsumptionPerDay<0 || inventory.getEssential()-essentialConsumptionPerDay<0){


			double travelCoef = 1.0;
			if(location.getCity().getDay()==preferedShoppingDay1)travelCoef=.1;
			int amountOfLuxuryNeeded = getNeed(Distributor.TYPE_LUXURY);
			int amountOfEssentialNeeded = getNeed(Distributor.TYPE_LUXURY);
			GroceryList list = new GroceryList(amountOfLuxuryNeeded,amountOfEssentialNeeded);
			for(GroceryStore g: storesByDistance){
				possibleOptions.add(new ShoppingItenerary(location, travelCoef, g, list));			
			}
		}
		return possibleOptions;
	}


	private int getDaysUntilSHopping(){
		return   (preferedShoppingDay1 - location.getCity().getDay())%7;
	}

	private int getNeed(int type) {
		int days = getDaysUntilSHopping();
		int amountUntilShoppingDay =(type==Distributor.TYPE_LUXURY)?days*luxuryConsumptionPerDay:days*essentialConsumptionPerDay;
		int capacity = (type== Distributor.TYPE_LUXURY)?luxuryCapacity:essentialCapacity;
		if(amountUntilShoppingDay < capacity)return amountUntilShoppingDay;
		else return capacity;
	}


	//returns 





}
