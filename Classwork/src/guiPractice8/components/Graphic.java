package guiPractice8.components;

import java.awt.image.BufferedImage;

import gui6.components.Visible;

public class Graphic implements Visible {

	
	//FIELDS
	private int x;
	private int y;
	private BufferedImage image;
	private boolean loadedImages;
	
	
	public Graphic(int x, int y, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, 0.0);
	}
	
	private void loadImages(String imageLocation, double d) {
		// TODO Auto-generated method stub
		
	}

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update() {
		// TODO Auto-generated method stub

	}

}
