package simulator;

import java.util.List;

public interface Distributor extends Place{

	public static final int TYPE_ESSENTIAL = 0;
	public static final int TYPE_LUXURY = 1;
	
	double getQuote(int numberOfLuxury, int numberOfEssential,  double minFreshness);
	
	List<Food> getOrder(final Account purchasingAccount, final int numberOfLuxury, final int numberOfEssential, final double minFreshness);

}
