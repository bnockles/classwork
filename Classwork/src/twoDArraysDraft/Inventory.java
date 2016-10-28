package twoDArraysDraft;

public class Inventory {

	private boolean hasMap;
	private String map;
	
	public Inventory(CaveRoom[][] caves) {
		hasMap = true;
		createMap(caves);
	}
	
	private void createMap(CaveRoom[][] caves) {
		//create top
		map = " ";
		for(int i = 0; i < caves[0].length; i++){
			map+="_";
		}
		map+=" ";
	}

	public String getDescription(){
		if(hasMap){
			
			return "You have a map:\n" +map;
		}else{
			return "You have no inventory.";
		}
	}

}
