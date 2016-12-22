package guiTeacher.wackAMole;

import guiTeacher.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements MoleDesign {

	private double appearanceTime;
	
	public Mole(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Mole(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Mole(int x, int y) {
		super(x, y, "resources/sampleImages/mole.jpg");
	}

	public void setAppearanceTime(double d) {
		this.appearanceTime = d;

	}

	public double getAppearanceTime() {
		return appearanceTime;
	}

}
