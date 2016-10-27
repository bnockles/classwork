package twoDArraysDraft;

import java.util.Scanner;

public class CaveExplorer {

	private CaveRoom[][] caves;
	private static Scanner in;
	private CaveRoom currentRoom;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		new CaveExplorer();
	}
	
	
	public CaveExplorer(){
		caves = new CaveRoom[5][5];
		for(int i = 0; i < caves.length; i++){
			for(int j = 0; j < caves[i].length; j++){
				caves[i][j] = new CaveRoom("This cave has coordinates "+i+", "+j);
			}
		}
		currentRoom = caves[3][3];
		caves[3][3].setConnection(CaveRoom.EAST, caves[3][4], new Door());
		caves[3][3].setDescription("This is the room you started in.");
		
		caves[3][4].setConnection(CaveRoom.NORTH, caves[2][4], new Door());
		caves[2][4].setConnection(CaveRoom.WEST, caves[2][3], new Door());
		caves[2][3].setConnection(CaveRoom.SOUTH, caves[3][3], new Door());
		startExploring();
	}
	
	private void startExploring() {
		while(true){
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = waitForInput();
			act(input);
		}
	}


	private void act(String input) {
		currentRoom = currentRoom.interpretAction(input);
	}


	public static String waitForInput(){
		return in.nextLine();
	}
	
}
