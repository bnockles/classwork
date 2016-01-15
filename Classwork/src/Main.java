
public class Main {
	public static void main(String[] args){
		System.out.println("Hello git!");
		//added a comment
		/**
		 * Let's try this from home!
		 */
		 //Here's a comment that was added online, via the browser
		if(isSquare(-16))System.out.println("Square!");
		else System.out.println(Math.sqrt(-16)+" not square");
	}
	
	public static boolean isSquare(double d){
		if(Math.sqrt(d)-(int)Math.sqrt(d)==0)return true;
		else return false;
		 //Here's a comment that was added online, via the browser\
		 //I need to make "Pull" work
	}
}

