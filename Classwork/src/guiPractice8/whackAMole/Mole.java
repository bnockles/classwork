package guiPractice8.whackAMole;

import guiPractice8.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements MoleInterface {

	private int appearanceTime;
	

	public Mole(int x, int y) {
		super(x, y, .50, "resources/sampleImages/mole.jpg");
	}

	public void setAppearanceTime(int d) {
		this.appearanceTime = d;

	}

	public int getAppearanceTime() {
		return appearanceTime;
	}

}
