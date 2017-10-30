package ad201718;

public class Arrays2D {

	public static void main(String[] args) {
		Arrays2D practice = new Arrays2D();
	}


	public Arrays2D() {
		drawAPicture();
	}


	//A warm up for the first day of 2D arrays
	private void printPrimeNumbers(int length) {
		boolean[] isComposite = new boolean[length];
		System.out.println("something");
		for(int i = 2; i < Math.sqrt(length); i++){
			int start = 2*i;
			for(int j = start; j < length; j+= i){
				isComposite[j] = true;
			}
		}
		for(int value = 0; value < length; value ++){
			if(!isComposite[value])System.out.println(value + " is prime.");
		}
	}

	private void drawAPicture(){
		String[][] pic = new String[10][12];
		for(int j = 0; j <pic.length; j++){
			String x = ",";
			if(j < pic.length - 3){
				x = " ";
			}
			for(int i = 0; i < pic[0].length; i++){
				pic[j][i] = x;
			}
		}
		drawBox(pic, 5,4);
		display(pic);
	}
	
	private void drawBox(String[][] pic, int i, int j) {
		if(i-1 > -1){
			if(j - 1 > -1){
				pic[i-1][j-1] = "_";
			}
			pic[i-1][j] = "_";
			if(j + 1 < pic[i].length){
				pic[i-1][j+1] = "_";
			}
		}
		if(j-2 > -1){
			if(j - 1 > -1){
				pic[i-2][j-1] = "|";
			}
			pic[i-2][j] = "_";
			if(j + 1 < pic[i].length){
				pic[i-2][j+1] = "_";
			}
		}
		if(i+1 < pic.length){
			if(j - 2 > -1){
				pic[i+1][j-1] = "|";
			}
			if(j - 1 > -1){
				pic[i+1][j-1] = "_";
			}
			pic[i+1][j] = "_";
			if(j + 1 < pic[i].length){
				pic[i+1][j+1] = "_";
			}
			if(j + 2 < pic[i].length){
				pic[i+1][j+2] = "|";
			}
		}
	}


	private void display(String[][] pic){
		for(int row = 0; row <pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println("");
		}
	}


}
