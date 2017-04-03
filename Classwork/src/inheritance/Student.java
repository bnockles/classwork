/**
 * 
 */
package inheritance;

/**
 * @author bnockles
 *
 */
public class Student {

	private String firstName;
	private String lastName;
	private int graduatingClass;
	private Major major;
	
	
	/**
	 * 
	 */
	public Student() {
		firstName = "Joe";
		lastName = "Schmoe";
		graduatingClass= 2021;
		major = new Major();
	}
	
	
	public void act(){
		stateName();
		stateMajor();
		stateStatus();
	}
	
	public void stateStatus() {
		System.out.print("After I complete "+major.getCulminatingCourse()+", I'll graduate in "+graduatingClass+". ");
	}


	public void stateName(){
		System.out.print("\nMy name is "+firstName+" "+lastName+". ");
	}
	
	public void stateMajor(){
		System.out.print("I'm a "+major.getName()+" major. ");
	}
	
	

}
