package simulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manhattan extends Environment {

	
	public Manhattan() {
		stores = new ArrayList<GroceryStore>();
	}

	
	List<GroceryStore> getStoresByProximity(final Location l) {
		List<GroceryStore> closeStores = new ArrayList<GroceryStore>();
		closeStores.addAll(stores);
		closeStores.sort(new Comparator<GroceryStore>() {

			public int compare(GroceryStore o1, GroceryStore o2) {
				double distance1 = l.getDistanceTo(o1.getLocation());
				double distance2 = l.getDistanceTo(o2.getLocation());
				if(distance1 < distance2)return -1;
				if(distance1 > distance2)return 1;
				return 0;
			}
		});
		return closeStores;
	}

	public static Environment getInstance() {
		return new Manhattan();
	}

}
