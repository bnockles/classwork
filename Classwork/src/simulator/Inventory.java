package simulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final  class Inventory implements Comparator<Food>{

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

	public boolean canAfford(double amount){
		return amount <= account.getAmmount();
	}
	
	public List<Food> sell(GroceryList list, double cost) {
		ArrayList<Food> product = new ArrayList<Food>();
		for(int i =0; i < list.getLuxury(); i ++){
			product.add(luxuryInventory.remove(0));
		}
		for(int i =0; i < list.getEssential(); i ++){
			product.add(essentialInventory.remove(0));
		}
		account.increase(cost);
		return product;
		
	}
	
	
	public void buy(List<Food> purchasedProducts, double cost) {
		account.decrease(cost);
		for(Food f: purchasedProducts){
			if(f instanceof EssentialFood)essentialInventory.add((EssentialFood) f);
			else if(f instanceof LuxuryFood)luxuryInventory.add((LuxuryFood) f);
		}

	}

	
	/**
	 * deteriorates all food
	 */
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
				if(discardedInventory!= null) discardedInventory.add(lf);
			}
			
		}
		Iterator<EssentialFood> iter2 = essentialInventory.iterator();
		while(iter2.hasNext()){
			Food ef = iter2.next();
			if(ef.getFreshness() < freshness){
				essentialInventory.remove(ef);
				if(discardedInventory!= null) discardedInventory.add(ef);
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


	public void sortByFreshness() {
		luxuryInventory.sort(this);
		essentialInventory.sort(this);
	}


	public int compare(Food f1, Food f2) {
		if(f1.getFreshness()-f2.getFreshness()>0)return 1;
		else if(f1.getFreshness()-f2.getFreshness()<0)return -1;
		else return 0;
	}


	public void consumeLux() {
		luxuryInventory.remove(0);
	}
	
	public void consumeEss() {
		essentialInventory.remove(0);
	}


	public void sortByOldest() {
		class OldSort implements Comparator<Food>{
			public int compare(Food f1, Food f2) {
				if(f1.getFreshness()-f2.getFreshness()>0)return -1;
				else if(f1.getFreshness()-f2.getFreshness()<0)return 1;
				else return 0;
			}
			
		}
		
		luxuryInventory.sort(new OldSort());
		System.out.println("Checking sort by oldest (least fresh food at top)\nThe oldest food has freshness "+luxuryInventory.get(0).getFreshness()+" while the newest has "+luxuryInventory.get(luxuryInventory.size()-1).getFreshness());
		essentialInventory.sort(new OldSort());
	}


	public int getLuxury() {
		return luxuryInventory.size();
	}

	public int getEssential(){
		return essentialInventory.size();
	}




	
	
}
