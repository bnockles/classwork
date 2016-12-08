package guiTeacher;

public class MouseCoordinateGame extends GUIApplication {


	public static void main(String[] args){
		Thread app = new Thread(new MouseCoordinateGame(500, 500));
		app.start();
	}

	public MouseCoordinateGame(int width, int height) {
		super(width, height);
	}
	
	public void initScreen() {
		TextScreen startScreen= new TextScreen("Hi everyone",getWidth(), getHeight());
		addMouseMotionListener(new CoordinateListener(startScreen));
		setScreen(startScreen);
		
	}

}
