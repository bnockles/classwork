package guiTeacher;

public class MouseCoordinateGame extends GUIApplication {

	public static MouseCoordinateGame game;
	public static TextScreen coordinateScreen;
	public static BallScreen ballScreen;
	
	public static void main(String[] args){
		game = new MouseCoordinateGame(500, 500);
		Thread app = new Thread(game);
		app.start();
	}

	public MouseCoordinateGame(int width, int height) {
		super(width, height);
	}
	
	public void initScreen() {
		
		ballScreen = new BallScreen(getWidth(),getHeight());
		coordinateScreen= new TextScreen("Hi everyone",getWidth(), getHeight());
		
		
		setScreen(coordinateScreen);
		
	}

}
