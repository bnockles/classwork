package caveExplorer6;

public class KeyRoom extends NPCRoom {

	public KeyRoom(String description) {
		super(description+" There is a shiney silver key resting on a cabinet in the corner of the room.");
		// TODO Auto-generated constructor stub
	}
	
	protected String[] validStrings(){
		String[] keys = {"w","d","s","a","q"};
		return keys;
	}
	
	public String getDirections(){
		String key = CaveExplorer.inventory.hasKey() ? "   Press 'q' to put the key back." : "   Press 'q' to pick up the key.";
		return super.getDirections()+"\n"+key;
	}

	
	protected void printInvalidMessage() {
		System.out.println("You can only enter "
				+ "'w','a','s', or 'd' to move and 'q' to perform the action.");
	}
	
	protected void performAction(int actionNumber) {
		if(actionNumber == 0){
			if(CaveExplorer.inventory.hasKey()){
				CaveExplorer.print("You drop the key where you found it.");
				CaveExplorer.inventory.removeKey();
			}else{
				CaveExplorer.print("You pick up the key.");
				CaveExplorer.inventory.addKey();
			}
		}else{
			super.performAction(actionNumber);
		}
	}
	
	

	
	
}
