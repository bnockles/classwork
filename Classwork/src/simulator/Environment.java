package simulator;

import java.util.ArrayList;
import java.util.List;

public abstract class Environment {

	List<GroceryStore> stores;
	List<Population> population;
	int day;


	public final List<GroceryStore> getStores() {
		return stores;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return cost of setting up a grocery store at coordinates x, y
	 */
	public static int getRelocateCost(int x, int y){
		return 1000000;
	}

	public void lapse(){
		day = ((day+1)%7);
		for(Population p: population){
			p.lapse();
		}
		for(GroceryStore g: stores){
			g.lapse();
		}
	}
	
	public int getDay() {
		return day;
	}
	
}
