package guiPractice8.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.Component;

public class AnimatedComponent extends Component {

	private ArrayList<BufferedImage> frame; //the images that can be displayed
	private ArrayList<Integer> time; //the time each image is displayed
	private long displayTime; //the time when the last image switched
	private int currentFrame; //the frame that is currently being displayed
	private double vx; //the horizontal velocity
	private double vy; //the vertical velocity
	private double posx; //the actual x-coordinate of the object
	private double posy; //the actual y-coordinate of the object
	
	public AnimatedComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		displayTime = System.currentTimeMillis();
		frame = new ArrayList<BufferedImage>();
		time = new ArrayList<Integer>();
		currentFrame = 0;
		vx = 0;
		vy = 0;
		posx= x;
		posy=y;
	}

	public boolean isAnimated(){
		return true;
	}
	
	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
