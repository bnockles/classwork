package caveExplorer6;

public class CaveRoom {

	private String description;
	private String directions;
	private String contents;
	private String defaultContents;

	private CaveRoom[] borderingRooms;
	private Door[] doors; 

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;


	public CaveRoom(String description){
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;

		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		for(int i = 0 ; i < borderingRooms.length; i++){
			borderingRooms[i] = null;
			doors[i] = null;
		}
		setDirections();
	}

	protected void setDirections() {
		directions	= "";
		if(doors[NORTH] == null && 
				doors[EAST] == null &&
				doors[SOUTH] == null &&
				doors[WEST] == null){
			directions = "\n\nThis is a room with no exit. You will die here.";		
		}else{
			for(int dir = 0; dir < doors.length; dir++){
				if(doors[dir] != null){
					directions += "\n   There is a "+doors[dir].getDescription()+" to "+toDirection(dir)+". "+doors[dir].getDetails();
				}
			}
		}

	}

	public static String toDirection(int dir) {
		String[] directions = {"the North","the East",
				"the South", "the West"};

		return directions[dir];
	}

	public String getContents(){
		return contents;
	}

	public void enter(){
		contents = "X";
	}

	public void leave(){
		contents = defaultContents;
	}

	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}


	public void addRoom(int direction, CaveRoom anotherRoom, Door door){
		borderingRooms[direction] = anotherRoom;
		doors[direction] = door;
		setDirections();
	}

	/**
	 * Gives this room access to anotherRoom (and vice-versa) and
	 * sets a door between them, and updates the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	/**
	 * 
	 * @param dir
	 * @return opposite direction of dir (NORTH returns SOUTH...)
	 */
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}


	public String getDescription(){
		return description;
	}


	public String getDirections(){
		return directions;
	}




	public Door getDoor(int dir){
		return doors[dir];
	}


	public void setDescription(String string) {
		description = string;
	}

	public void interpretInput(String input) {
		while(!isValid(input)){
			printInvalidMessage();
			input = CaveExplorer.in.nextLine();
		}
		String[] keys = validStrings();
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		if(indexFound < 4){
			goToRoom(indexFound);
		}else{
			performAction(indexFound-4);
		}

	}

	protected void performAction(int actionNumber) {
		if(actionNumber == 0){
			unlockDoors();
		}else{
			System.out.println("That does nothing.");
		}
	}

	private void unlockDoors() {
		for(int i = 0; i < 4; i++){
			Door d = CaveExplorer.currentRoom.doors[i];
			if(d 
					!= null){
				if(d.isLocked() && d.canUnlock()){
					d.setLock(false);
					d.setOpen(true);
					System.out.println("You managed to unlock the door to "+toDirection(i)+".");
				}else if(d.isLocked()){
					System.out.println("Though you tried, you could not open the door to "+toDirection(i)+".");
				}
			}
		}
	}

	protected String[] validStrings(){
		String[] keys = {"w","d","s","a","e"};
		return keys;
	}

	protected void printInvalidMessage() {
		System.out.println("You can only enter "
				+ "'w','a','s','d' or 'e'.");
	}

	public void goToRoom(int direction){
		if(borderingRooms[direction] != null &&
				doors[direction].isOpen()){
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}

	public boolean isValid(String s){
		String[] keys = validStrings();
		for(String key:keys){
			if (s.equals(key))return true;
		}
		return false;
	}

	public static void setUpCaves() {
		CaveExplorer.caves = new CaveRoom[5][5];
		for(int i = 0; i < CaveExplorer.caves.length; i++){
			for(int j = 0; j < CaveExplorer.caves[i].length; j++){
				CaveExplorer.caves[i][j] = new NPCRoom("This cave has coordinates "+i+", "+j);
			}
		}



		CaveExplorer.caves[0][2] = new EventRoom("This is the room"
				+ " where that guy with a tail met you.",
				new GameStartEvent());

		CaveExplorer.caves[2][3] = new TreasureRoom("You have found a broken vending machine. "
				+ "It appears you can have any object in the machine at no cost. Better not tell anyone else! You feel replenished.");

		CaveExplorer.caves[3][3] = new KeyRoom("You have entered a well-furnished room.");

		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		CaveExplorer.caves[0][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][2],new Door());
		CaveExplorer.caves[0][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][2],new Door());
		CaveExplorer.caves[0][2].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][3],new Door());
		CaveExplorer.caves[0][3].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][3],new Door());
		Door lockedDoor = new Door();
		lockedDoor.setLock(true);
		lockedDoor.setOpen(false);
		CaveExplorer.caves[1][3].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][3],lockedDoor);
		CaveExplorer.caves[1][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][2],new Door());

		CaveExplorer.caves[2][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[3][2],new Door());

		CaveExplorer.caves[3][2].setConnection(CaveRoom.EAST,CaveExplorer.caves[3][3],new Door());

		CaveExplorer.monsters = new NPC[1];
		NPC mac = new NPC(CaveExplorer.caves);
		mac.setPosition(3, 3);
		CaveExplorer.monsters[0] = mac;
	}













}
