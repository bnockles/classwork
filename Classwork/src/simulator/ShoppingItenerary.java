package simulator;

public final class ShoppingItenerary implements Comparable<ShoppingItenerary> {

	private  GroceryStore selectedStore;
	private GroceryList shoppingList;
	private double cost;
	private double priority;
	
	public ShoppingItenerary(Location origin, double travelCoef, GroceryStore selectedStore, GroceryList shoppingList, double priority){
		this.selectedStore = selectedStore;
		this.shoppingList = shoppingList;
		cost = calculateCost(origin, travelCoef);
	}

	private double calculateCost(Location origin, double travelCoef) {
		double travelRate = origin.getTravelRate();
		return travelRate*2*travelCoef*origin.getDistanceTo(selectedStore.getLocation())+selectedStore.estimateCost(shoppingList);
	}

	public GroceryStore getStore() {
		// TODO Auto-generated method stub
		return selectedStore;
	}
	
	public GroceryList getList(){
		return shoppingList;
	}

	public int compareTo(ShoppingItenerary arg0) {
		return (int) (this.cost - arg0.getCost());
	}

	private double getCost() {
		return cost;
	}
	
	
}
