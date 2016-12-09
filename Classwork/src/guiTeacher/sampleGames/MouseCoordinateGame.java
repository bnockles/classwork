package guiTeacher.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import guiTeacher.GUIApplication;
import guiTeacher.sampleScreens.BallScreen;
import guiTeacher.sampleScreens.TextScreen;

public class MouseCoordinateGame extends GUIApplication implements MouseListener{

	public static MouseCoordinateGame game;
	public static TextScreen coordinateScreen;
	public static BallScreen ballScreen;
	
	private boolean coordMode;
	
	public static void main(String[] args){
		game = new MouseCoordinateGame(500, 500);
		Thread app = new Thread(game);
		app.start();
	}

	public MouseCoordinateGame(int width, int height) {
		super(width, height);
		coordMode = true;
		//this is a MouseListener independent of Screens.
		addMouseListener(this);
	}
	
	public void initScreen() {
		
		ballScreen = new BallScreen(getWidth(),getHeight());
		coordinateScreen= new TextScreen("Hi everyone",getWidth(), getHeight());
		
		
		setScreen(coordinateScreen);
		
	}

	public void mouseClicked(MouseEvent e) {
		coordMode = !coordMode;
		if(coordMode)setScreen(coordinateScreen);
		else setScreen(ballScreen);
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
