package fixedGUI;

import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.components.Visible;

public class Demo extends GUIApplication {

	public Demo(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		setScreen(new DemoScreen(500, 500));
	}

	public static void main(String[] args) {
		new Demo(500,500);
	}
	
	public class DemoScreen extends Screen{

		/**
		 * 
		 */
		private static final long serialVersionUID = -2096083233624854764L;

		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initObjects(List<Visible> viewObjects) {
			viewObjects.add(new TextLabel(40, 40, 500, 25, "This is a label."));
		}
		
	}

}
