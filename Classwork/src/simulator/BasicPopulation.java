package simulator;

public abstract class BasicPopulation implements Population {

	protected static final int NEED_LUXURY = 0;
	protected static final int NEED_ESSENTIAL = 1;
	protected static final int NEED_ALL = 2;
	
	protected double luxuryNeed;
	protected double essentialNeed;
	
	
	
	public void lapse() {
		reduceFood();
		goShoppingFor(assessNeeds());
	}

	protected void reduceFood() {
		// TODO Auto-generated method stub
		
	}

	protected void goShoppingFor(int assessNeeds) {
		// TODO Auto-generated method stub
		
	}

	protected int assessNeeds() {
		// TODO Auto-generated method stub
		return null;
	}

}
