package caveExplorer6;

public class TreasureRoom extends NPCRoom {

	public TreasureRoom(String description) {
		super(description);
		
	}
	
	public void setDefaultContents(String symbol){
		super.setDefaultContents("T");
	}
	

	public void enter(){
		super.enter();
		CaveExplorer.inventory.resetHP();
	}
	
}
