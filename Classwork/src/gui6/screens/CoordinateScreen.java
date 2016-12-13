package gui6.screens;



import java.util.ArrayList;

import gui6.Screen;
import gui6.components.TextLabel;
import gui6.components.Visible;

public class CoordinateScreen extends Screen {

	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		TextLabel text = 
				new TextLabel(20, 200, 500, 40, "Some text");
		viewObjects.add(text);
	}


	
	
	
	
	
	
	
	
	
	
	
}
