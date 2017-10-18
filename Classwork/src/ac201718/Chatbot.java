package ac201718;

public class Chatbot {

	 private String user;
	 private boolean inLoop;
	 private String response;
	 private Topic groupMember1;

	
	public Chatbot() {
		groupMember1 = new SampleTopic();
		inLoop = true;
	}

	public void talkForever() {
		System.out.println("Greetings! What is your name?");
		user = Utility.getInput();
		while (inLoop) {
			Utility.print("Greetings, " + user + ". What genre of games do you like?");
			response = Utility.getInput();
			if (groupMember1.isTriggered(response)) {
				inLoop = false;
				groupMember1.talk();
			} else {
				Utility.print("I'm sorry I dont understand you.");
			}
		}
	}
	
}
