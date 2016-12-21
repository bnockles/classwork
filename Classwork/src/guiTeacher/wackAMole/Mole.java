package guiTeacher.wackAMole;

public class Mole extends MoleDesign {

	private double appearanceTime;
	
	public Mole(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Mole(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Mole(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAppearanceTime(double d) {
		this.appearanceTime = d;

	}

	@Override
	public double getAppearanceTime() {
		return appearanceTime;
	}

}
