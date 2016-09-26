package chatbot8;

public class NocklesSchool implements Chatbot{

	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			NocklesMain.print("(Type 'quit' to go back.)");
			//static call on prompthInput method from
			//NocklesMain class
			schoolResponse = NocklesMain.promptInput();
			if(schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				NocklesMain.promptForever();
			}
			NocklesMain.print("That's my favorite part "
					+ "about school.");
		}
	}

}












