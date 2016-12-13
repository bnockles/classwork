package guiPractice8.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice8.Screen;
import guiPractice8.components.TextArea;
import guiPractice8.components.TextLabel;
import guiPractice8.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener{

	private TextLabel label;
	private TextArea paragraph;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(40,45,760,40,"Sample Text");
		paragraph = new TextArea(40,85,550,500,
				"This is a whole paragraph. Notice how "
				+ "as the paragraph gets to the edge"
				+ " of the page, a new line is created.");
		viewObjects.add(label);
		viewObjects.add(paragraph);
		
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent m) {
		label.setText("Mouse at" + m.getX()+", "+m.getY());
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

}









