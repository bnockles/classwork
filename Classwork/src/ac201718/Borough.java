package ac201718;

public class Borough {

	public static final Borough[] NY_BOROUGHS = {new Borough("Manhattan"), new Borough("Bronx"), new Borough("Queens"), new Borough("Brooklyn"), new Borough("Staten Island")};
	
	
	
	private String name;
	
	public Borough(String name) {
		this.name = name;
	}
	public String toString(){
		return name;
	}

}
