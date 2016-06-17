package simulator;

public final  class Inventory {

	private Account account;
	private int luxuryInventory;
	private int essentialInventory;

	
	public Inventory(double startingCash) {
		account = new Account(startingCash);
		luxuryInventory = 0;
		essentialInventory = 0;
	}


	public final boolean hasInStock(GroceryList list){
		return luxuryInventory> list.getLuxury() && essentialInventory > list.getEssential();
	}

	public final void sell(GroceryList list, double cost) {
		luxuryInventory -= list.getLuxury();
		essentialInventory -= list.getEssential();
		account.increase(cost);
		
	}
	
	
	public final void buy(GroceryList list, double cost) {
		// TODO Auto-generated method stub
		
	}
	
	
}
