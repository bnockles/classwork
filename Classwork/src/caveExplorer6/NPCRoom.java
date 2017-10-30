package caveExplorer6;

public class NPCRoom extends CaveRoom {

	private NPC presentNPC;

	public NPCRoom(String description) {
		super(description);
	}

	public boolean canEnter(){
		return presentNPC== null;
	}
	
	public void enterMonster(NPC m){
		presentNPC = m;
	}

	public void leaveMonster(){
		presentNPC = null;
	}

	public boolean containsMonster(){
		return presentNPC != null;
	}

	public String getContents(){
		if(containsMonster() && presentNPC.isActive()){
			return "M";
		}
		return super.getContents();
	}
	
	public String getDescription(){
		if(containsMonster() && !presentNPC.isActive()){
			return super.getDescription() +"\n"+presentNPC.getInactiveDescription();
		}
		return super.getDescription();
	}

}
