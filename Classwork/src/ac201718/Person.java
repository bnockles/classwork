package ac201718;

public class Person {

	
	public static final String[] FIRST_START = {"Chr","B","M","T","R","Gr","P","L"};
	public static final String[] FIRST_MIDDLE = {"ana","i","a","o","ala","ola","ara","e","is"};
	public static final String[] FIRST_LAST = {"","m","s","r","n","ian","ara","e"};
	
	
	public static final String[] LAST_START = {"Br","R","M","T","R","Gr","P","L"};
	public static final String[] LAST_MIDDLE = {"om","o","an","ola","et","e","is"};
	public static final String[] LAST_LAST = {"ers","son","rian"};
	
	
	private Borough home;
	private String firstName;
	private String lastName;
	
	public Person(String first, String last, Borough borough) {
		this.firstName = first;
		this.lastName = last;
		this.home = borough;
	}

	
	public String toString(){
		return "My name is "+firstName+" "+ lastName + " and I am from "+home+".";
	}
}
