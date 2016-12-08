package guiTeacher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CoordinateListener implements MouseMotionListener {

	MessageDisplayer display;
	
	public CoordinateListener(MessageDisplayer display){
		this.display = display;
	}
	
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent m) {
		display.displayMessage("Mouse at "+m.getX()+","+m.getY());
	}


}
