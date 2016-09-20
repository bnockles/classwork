package introduction8;

public class RadomDiceRoll {

	public static void main(String[] args) {

		int[] results = new int[6];
		//declare variable, logic test, increment
		for(int index = 0; index < 10000; index ++){	
			int result = rollFairDie();
			System.out.println("Roll #"+(index+1)+
					": "+result);
			results[result-1] ++;
			
		}
		//print the results
		for(int i = 0; i < 6; i++){
			System.out.println((i+1)+"appeared" +
		results[i]+" times.");			
		}
	}
	
	
	//return 1,2,3,4,5,6, with equal probability
	public static int rollFairDie(){
		double rand = Math.random();//returns a double (0,1)
		int roll = (int) (6*rand);//[0,5]
		roll ++; //[1,6]
		return roll;
	}
	
//	public static int rollUnfairDie(){
//		
//	}

}














