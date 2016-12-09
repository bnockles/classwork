package guiTeacher.sampleScreens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.components.Visible;
import guiTeacher.userInterfaces.MessageDisplayer;
import guiTeacher.userInterfaces.Screen;

public class TextScreen extends Screen implements MessageDisplayer, MouseMotionListener{

	private TextLabel label;
	
	public TextScreen(String text, int width, int height) {
		super(width, height);
		label.setText(text);
		update();
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		label = new TextLabel(40, getHeight()-45, getWidth()-80, 40, "");
		label.setSize(40);
		viewObjects.add(label);
	}

	public void displayMessage(String message) {
		label.setText(message);
		update();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
	public void mouseMoved(MouseEvent m) {
		displayMessage("Mouse at "+m.getX()+","+m.getY());
	}

}
