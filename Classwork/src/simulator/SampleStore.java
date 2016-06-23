/**
 * 
 */
package simulator;

import java.util.List;

/**
 * @author Teacher
 *
 */
public final class SampleStore extends GroceryStore{

	/**
	 * 
	 */
	public SampleStore(Location l) {
		this.location = l;
	}

	public void initDistributors(List<Distributor> listByProximity){
		distributors = listByProximity;
	}
	
	
	@Override
	double estimateCost(GroceryList list) {
		return list.getLuxury()*Food.LUXURY+list.getEssential()*Food.ESSENTIAL;
	}

	@Override
	double getFreshness() {
		return 1;
	}

	@Override
	void orderSupplies() {
		// TODO Auto-generated method stub
		
	}

}
