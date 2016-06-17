package simulator;

public class Location {

	private Environment city;
	private int x;
	private int y;
	
	public Location(Environment city, int x, int y){
		this.city = city;
		this.x = x;
		this.y = y;
		
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
	
	public Environment getCity(){
		return city;
	}

	//return price per unit of travel
	public double getTravelRate() {
		return 1.0;
	}
	
}
