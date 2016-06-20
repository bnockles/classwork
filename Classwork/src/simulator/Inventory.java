package simulator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final  class Inventory {

	private Account account;
	private List<LuxuryFood> luxuryInventory;
	private List<EssentialFood> essentialInventory;

	
	public Inventory(double startingCash) {
		account = new Account(startingCash);
		luxuryInventory = new ArrayList<LuxuryFood>();
		essentialInventory = new ArrayList<EssentialFood>();
	}


	public boolean hasInStock(GroceryList list){
		return luxuryInventory.size()> list.getLuxury() && essentialInventory.size() > list.getEssential();
	}

	public void sell(GroceryList list, double cost) {
		for(int i =0; i < list.getLuxury(); i ++){
			luxuryInventory.remove(0);
		}
		for(int i =0; i < list.getEssential(); i ++){
			essentialInventory.remove(0);
		}
		account.increase(cost);
		
	}
	
	
	public void buy(GroceryList list, double cost) {
		// TODO Auto-generated method stub
		
	}

	public void lapse(){
		for(Food f: luxuryInventory){
			f.deteriorate();
		}
		for(Food f: essentialInventory){
			f.deteriorate();
		}
	}
	
	public void discardNonfreshFood(double freshness, Inventory discardedInventory) {
		Iterator<LuxuryFood> iter = luxuryInventory.iterator();
		while(iter.hasNext()){
			Food lf = iter.next();
			if(lf.getFreshness() < freshness){
				luxuryInventory.remove(lf);
				discardedInventory.add(lf);
			}
			
		}
		Iterator<EssentialFood> iter2 = essentialInventory.iterator();
		while(iter2.hasNext()){
			Food ef = iter2.next();
			if(ef.getFreshness() < freshness){
				essentialInventory.remove(ef);
				discardedInventory.add(ef);
			}
			
		}
		
		
		
	}
	
	public final void charge(double amount){
		account.decrease(amount);
	}
	
	private void add(Food f) {
		if(f instanceof LuxuryFood){
			luxuryInventory.add((LuxuryFood)f);
		}
		if(f instanceof EssentialFood){
			essentialInventory.add((EssentialFood)f);
		}
	}



	
	
}
