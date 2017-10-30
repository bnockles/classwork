package caveExplorer6;

import java.util.Arrays;

public class NPC {

	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	private boolean following;
	private boolean active;
	private String description;

	public NPC(CaveRoom[][] floor) {
		this.floor = floor;
		this.description = "monster";
		//monser has not entered unless position is set
		currentRow = -1;
		currentCol = -1;
		currentRoom = null;
		following = true;
		active = true;
	}

	public void setPosition(int row, int col){

		//always check row before column
		if(row >= 0 && row < floor.length && col >= 0 && col < floor[row].length
				&& floor[row][col] instanceof NPCRoom){
			//removes monster from whatever room it may currently be in
			if(currentRoom != null){
				currentRoom.leaveMonster();
			}

			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterMonster(this);
		}

	}

	public void act(){
		if(active){

			int[] move = calculateMovement();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
			if(currentRoom == CaveExplorer.currentRoom){
				CaveExplorer.currentInteraction = this;
			}
		}
	}
	
	
	public void interact(){
		System.out.println("Looks like we are in the same place! Type 'p' and I will leave you alone.");
		String punch = CaveExplorer.in.nextLine();
		while(!punch.equalsIgnoreCase("p")){
			CaveExplorer.inventory.damage(10);
			System.out.println("Sorry, you're just going to have to type 'P'");
			punch = CaveExplorer.in.nextLine();
		}
		active = false;
	}
	
	private int[] calculateMovement(){
		CaveRoom[][] c = floor;
		int[] coord = new int[2];
		if(following){
			//make students figure this out!
			return moveTowardPlayer();			
		}else{

			return randomMove();
		}
	}

	private int[] randomMove() {
		int[] coord = new int[2];
		int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
		int i = (int)(Math.random() * pos.length);
		coord = pos[i];
		int newR = currentRow + coord[0];
		int newC = currentCol + coord[1];
		while(currentRoom.getDoor(i) == null || !(CaveExplorer.caves[newR][newC] instanceof NPCRoom)){
			i = (int)(Math.random() * pos.length);
			coord = pos[i];
			newR = currentRow + coord[0];
			newC = currentCol + coord[1];
		}
		return coord;
	}

	private int[] moveTowardPlayer() {
		int[] coord = new int[2];
		int[] pCoord = findPlayer();
		int pRow = pCoord[0];
		int pCol = pCoord[1];
		if(pRow < this.currentRow && currentRoom.getDoor(CaveRoom.NORTH) != null){
			coord[0] = -1;
		}else if(pRow > this.currentRow && currentRoom.getDoor(CaveRoom.SOUTH) != null){
			coord[0] = 1;
		}else if(pCol > this.currentCol && currentRoom.getDoor(CaveRoom.EAST) != null){
			coord[1] = 1;
		}else if(pCol < this.currentCol && currentRoom.getDoor(CaveRoom.WEST) != null){
			coord[1] = -1;
		}

		return coord;
	}

	public static int[] findPlayer() {
		int[] coord = new int[2];
		A: for(int i = 0; i < CaveExplorer.caves.length; i++){
			for(int j = 0; j < CaveExplorer.caves[i].length; j++){
				if(CaveExplorer.caves[i][j] == CaveExplorer.currentRoom){
					coord[0] = i;
					coord[1] = j;
					return coord;
				}
			}
		}
		return coord;
	}
	
	public boolean isActive(){
		return active;
	}

	public String getInactiveDescription() {
		return "This is where you encountered the "+description+".";
	}

}
