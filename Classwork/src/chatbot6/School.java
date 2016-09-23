package chatbot6;

public class School implements Topic {

	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public School(){
		
	}
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			NocklesMain.print("Tell me about school.");
			schoolResponse = NocklesMain.getInput();
			if(schoolResponse.indexOf("stop")>= 0){
				inSchoolLoop =false;
				NocklesMain.talkForever();
			}else{
				NocklesMain.print("That's my favorite "
						+ "part about school too.");
			}
			
		}
	}
}










