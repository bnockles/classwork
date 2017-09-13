package aa201718;//package name

//class declaration
public class Conventions {

	//fields
	private String name;
	private String description;
	
	
	//constructor with two arguments
	public Conventions(String firstName, String lastName) {
		//a constructor serves to instantiate fields
		
		//helper method
		initName(firstName,lastName);
		initDescription();
	}
	
	/*
	 * a helper method is used to organize code. We could put this in the construtor, but
	 * it would make our constructor too busy
	 */
	public void initName(String firstName, String lastName) {
		//local variable
		//notice how this variable is both declared and instantiated in one single line. This saves space
		String name = firstName + " " + lastName;
		//field: notice how use of word 'this' distinguishes from the local variable
		this.name = name;
		//this is the end of the method. At this point, all local variables are destroyed. They can never again be recovered
		
	}
	
	public void initDescription() {
		//static call: notice how we call the static field ON THE CLASS
		//in general, if a method call starts with a capital letter (class) it is a static call
		description = " is a member of "+IntroMain.SCHOOL_NAME;
		//furthermore, look how I don;t use the word 'this'. Inside this method, there are no local variables to confuse, so distinguishing the field is not necessary.
	}

	public void go() {
		//Is this an instance or static method?
		System.out.println(name+description);
	}

}
