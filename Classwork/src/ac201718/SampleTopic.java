package ac201718;

public class SampleTopic implements Topic {

	public SampleTopic() {
		// TODO Auto-generated constructor stub
	}

	public void talk() {
		Utility.print("Say anything.");
		String response = Utility.getInput();
		while(true) {
			Utility.print("You said \""+response+ "\". Say anything.");
			response = Utility.getInput();
		}
	}

	public boolean isTriggered(String userInput) {
		return userInput.indexOf("keyword") >= 0;
	}

}
