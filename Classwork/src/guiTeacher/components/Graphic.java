package guiTeacher.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Graphic implements Visible {

	private int x;
	private int y;
	
	public Graphic(int x, int y, int w, int h, String imageLocation){
		
		loadImages(imageLocation);
	}
	
	public Graphic(int x, int y, String imageLocation){
		
		loadImages(imageLocation);
	}
	
	private void loadImages(String imageLocation, int w, int h) {
		try{
			mario = new ImageIcon("resources/sampleImages/mario.png").getImage();
			imagesLoaded = true;
			update();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		if(imagesLoaded) {
			g.drawImage(mario, 0, 0, getWidth(), getHeight(), 0,0,mario.getWidth(null), mario.getHeight(null), null);
		}
//		g.fillOval(0, 0, getWidth(), getHeight());
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

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}


}
