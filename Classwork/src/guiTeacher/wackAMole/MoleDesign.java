package guiTeacher.wackAMole;

import guiTeacher.components.ClickableGraphic;

public abstract class MoleDesign extends ClickableGraphic {

	
	
	public MoleDesign(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public MoleDesign(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public MoleDesign(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public static MoleDesign getAMole(int widthOfScreen, int heightOfScreen) {
		return new Mole((int)(Math.random()*widthOfScreen), 50+(int)(Math.random() * heightOfScreen),40,30, "resources/sampleImages/mole.jpg");
	}

	public abstract void setAppearanceTime(double d);

	public abstract double getAppearanceTime();

}
