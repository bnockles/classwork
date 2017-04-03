package inheritance;

public class ClubMember extends Student{

	String club;

	public ClubMember() {
		super();
		club = "unaffiliated";
	}

	public void act(){
		super.act();
		stateClub();
	}

	public void stateClub() {
		System.out.print("I'm also a member of the "+club+" club. ");
	}

}
