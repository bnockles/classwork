package guiTeacher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CoordinateListener implements MouseMotionListener, MouseListener {

	private boolean coordinatesDisplayed;
	
	public CoordinateListener(){
		coordinatesDisplayed = true;
	}
	
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent m) {
		if(coordinatesDisplayed)MouseCoordinateGame.coordinateScreen.displayMessage("Mouse at "+m.getX()+","+m.getY());
		else MouseCoordinateGame.ballScreen.setBallPosition(m.getX(), m.getY());
	}

	public void mouseClicked(MouseEvent e) {
		coordinatesDisplayed=!coordinatesDisplayed;
		if(coordinatesDisplayed){
			MouseCoordinateGame.game.setScreen(MouseCoordinateGame.coordinateScreen);
		}else{
			MouseCoordinateGame.game.setScreen(MouseCoordinateGame.ballScreen);
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
