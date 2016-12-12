package guiPractice8.sampleGames;

import java.util.ArrayList;

import guiPractice8.Screen;
import guiPractice8.components.TextArea;
import guiPractice8.components.TextLabel;
import guiPractice8.components.Visible;

public class CoordinateScreen extends Screen {

	private TextLabel label;
	private TextArea paragraph;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(40,45,760,40,"Sample Text");
		paragraph = new TextArea(40,85,760,500,
				"This is a whole paragraph. Notice how "
				+ "as the paragraph gets to the edge"
				+ " of the page, a new line is created.");
		viewObjects.add(label);
		viewObjects.add(paragraph);
		
	}

}









