package simulator;

public class Location {

	private int x;
	private int y;
	
	public Location(int x, int y){
		
	}
	
	public double getDistanceTo(Location other){
		return Math.sqrt(Math.pow(x-other.getX(), 2)+Math.pow(y-other.getY(), 2));
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
