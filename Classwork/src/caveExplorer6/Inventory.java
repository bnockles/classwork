package caveExplorer6;

public class Inventory {
	private boolean hasMap;
	private int hp;
	private String map;
	private boolean key;
	
	public Inventory(){
		hasMap = false;
		hp = 100;
		updateMap();
	}
	
	public void updateMap() {
		map = " ";
		for(int i = 0; i < CaveExplorer.caves[0].length -1;
				i++){
			map += "____";//4 underscores
		}
		map += "___\n";//3 underscores and new line
		for(CaveRoom[] row: CaveExplorer.caves){
			//three rows of text
			for(int i = 0; i < 3; i++){
				//a line of text for each room
				String text="";
				for(CaveRoom cr: row){
					//THIS LINE NEEDS TO BE IN THE ELSE
//					text += "|";
					if(cr.getDoor(CaveRoom.WEST) != null && 
							cr.getDoor(CaveRoom.WEST).isOpen()){
						text += " ";
					}else{
						text+="|";
					}
					if(i == 0){
						text+="   ";//3 spaces
					}else if(i == 1){
						text += " "+cr.getContents()+" ";
					}else if(i==2){
						if(cr.getDoor(CaveRoom.SOUTH) != null &&
								cr.getDoor(CaveRoom.SOUTH).isOpen()){
							text+="   ";//3 spaces
						}else{
							text+="___";//3 horizontal lines
						}
					}
				}//last caveroom in the row
				text+="|";
				map +=text+"\n";
			}//last of the 3 text lines
		}//last row
		
		
	}


	public String getDescription() {
		if(hasMap){
			return map+"\nHP: "+hp;
		}
		else{
			return "HP: "+hp+"\nThere is nothing in your inventory";
		}
	}
	
	public void setMap(boolean b){
		hasMap = b;
	}

	public void resetHP() {
		hp = 100;
	}

	public void damage(int amount) {
		hp -= amount;
	}

	public void addKey() {
		this.key = true;
	}

	public boolean hasKey() {
		return this.key;
	}

	public void removeKey() {
		this.key = false;
		
	}

}










