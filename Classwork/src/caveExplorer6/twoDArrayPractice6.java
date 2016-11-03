package caveExplorer6;

public class twoDArrayPractice6 {

	public static void main(String[] args) {
		boolean[][] mines = new boolean[6][6];
		createMines(mines, 10);
		String[][] field = 
				new String[mines.length][mines[0].length];
		matchValues(field, mines);
		printPic(field);
	
	}
	
	
	private static void matchValues(String[][] field, boolean[][] mines) {
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[0].length; col++){
				if(mines[row][col])field[row][col]="X";
				else{
					field[row][col] = 
							countAdjacent(mines, row, col);
				}
			}
		}
	}


	private static String countAdjacent(boolean[][] mines, 
			int r, int c) {
		//r and c represent coordinates of element 
		//we are providing a 
		//String for
		int count = 0;
		//loop through row above to row below
		for(int row = r-1; row <= r+1; row++){
			//loop through col left to col right
			for(int col = c-1; col <= c+1; col++){
				//exclude this element when counting
				if(row !=r && col != c){
					if(row >=0 &&
							row < mines.length&&
							col >= 0 && 
							col < mines[row].length)
				}
			}
		}
		return null;
	}


	private static void createMines(boolean[][] mines, 
			int numberOfMines) {
		while(numberOfMines >0){
			int row = (int)(Math.random()*mines.length);
			int col = (int)(Math.random()*mines[0].length);
			if(!mines[row][col]){
				mines[row][col] = true;
				numberOfMines --;
			}
		}
		
	}

















	public static void picDrawing(){
		String[][] pic = new String[10][12];
		for(int row = 0; row< pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				pic[row][col] = " ";
			}
		}
		pic[1][2]="O";
		pic[0][2]="|";
		pic[2][2]="|";
		pic[1][1]="-";
		pic[1][3]="-";
		pic[0][1]="\\";
		pic[2][3]="\\";
		pic[0][3]="/";
		pic[2][1]="/";		
		
		for(int row = 7; row< pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				pic[row][col] = "M";
			}
		}
		//top & bottom row is "_"
		for(int col = 0 ; col < pic[0].length; col++){
			pic[0][col]= "_";
			pic[pic.length-1][col]= "_";
		}
		//left and right col is "|"
		for(int row = 1; row < pic.length; row++){
			pic[row][0]="|";
			pic[row][pic[0].length-1]="|";
		}

	}
	
	public static void printPic(String[][] pic){
		for(int row = 0; row< pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}

}
