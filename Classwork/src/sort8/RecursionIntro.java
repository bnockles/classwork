package sort8;

public class RecursionIntro {


	public static void main(String[] args) {
		hanoiSolution(3, "A", "B", "C");
		
//		System.out.println("Using a for loop:");
//		for(int i = 0; i < 5; i++){
//			System.out.println("Hello world! x"+i);
//		}
//		System.out.println("Without using a for loop:");
//		forLoop(5, new Action(){
//			
//			private int value = 0;
//			
//			public void act(){
//				System.out.println("Hello world! x"+value);
//				value++;
//			}
//		});
	}

	private static void forLoop(int i, Action action) {
		if(i <= 0){
			//base case
			return;
		}else{
			//standard action
			action.act();
			//recursive call
			forLoop(i-1, action);
		}
	}
	
	
	public static int factorial(int x){
		//for loop method
//		int factorial = 1;
//		for(int i = x; i > 0; i--){
//			factorial = factorial * i;
//		}
//		System.out.println(factorial);
//		return factorial;
		
		
		  
		  //RECURSION METHOD
		
		if (x > 1) {
			return x *factorial(x-1);
		}
		return 1;
		
		
		 
	}
	
	public static void hanoiSolution(int numberOfDiscs, 
			String startPeg, 
			String midPeg, 
			String endPeg){
		if(numberOfDiscs <=1){
			System.out.println("Move "+startPeg+" to "+endPeg);
		}else{
			hanoiSolution(numberOfDiscs-1, startPeg, 
					endPeg, 
					midPeg);
			hanoiSolution(1, startPeg, midPeg, endPeg);
			hanoiSolution(numberOfDiscs-1, 
					midPeg, startPeg, endPeg);
		}
		
	}
	

}













