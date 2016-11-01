package caveExplorer6;


import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;
	private static Scanner in;
	public static CaveRoom currentRoom;
	private Inventory inventory;

	
	public static void main(String[] args){
		in = new Scanner(System.in);

		caves = new CaveRoom[5][5];
		for(int i = 0; i < caves.length; i++){
			for(int j = 0; j < caves[i].length; j++){
				caves[i][j] = new CaveRoom("This cave has coordinates "+i+", "+j);
			}
		}
		currentRoom = caves[0][1];
		currentRoom.enter();
		caves[0][1].setConnection(caves[0][2]);

	}
	
	
}
