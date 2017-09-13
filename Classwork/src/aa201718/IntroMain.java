package aa201718;//package name

public class IntroMain {

	//static variable
	public static final String SCHOOL_NAME = "Brooklyn Tech High School";
	
	public static void main(String[] args) {
		//local variable
		Conventions conventionsInstance = new Conventions("Ben","Nockles");
		//notice how when I declare a variable of type Conventions, the IDER knows what I am talking about because Conventions is in the same package as this class
		
		//instance method call: notice how we call the method ON THE INSTANCE
		conventionsInstance.go();
	}
	

}
