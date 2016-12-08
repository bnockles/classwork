package guiTeacher;


public class TextScreen extends Screen implements MessageDisplayer{

	private TextLabel label;
	
	public TextScreen(String text, int width, int height) {
		super(width, height);
		label.setText(text);
		update();
	}

	@Override
	public void initObjects() {
		label = new TextLabel(40, getHeight()-45, getWidth()-80, 40, "");
		label.setSize(40);
		addObject(label);
	}

	public void displayMessage(String message) {
		label.setText(message);
		update();
	}

}
