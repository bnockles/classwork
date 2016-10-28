package twoDArraysDraft;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;
	private static Scanner in;
	public static CaveRoom currentRoom;
	private Inventory inventory;

	
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
		inventory = new Inventory(caves);
		startExploring();
	}
	
	private void startExploring() {
		while(true){
			print(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = waitForInput();
			act(input);
		}
	}
	
	public static void print(String s){
		System.out.println(s);
	}


	private void act(String input) {
		currentRoom = currentRoom.interpretAction(input);
	}


	public static String waitForInput(){
		return in.nextLine();
	}
	
}
