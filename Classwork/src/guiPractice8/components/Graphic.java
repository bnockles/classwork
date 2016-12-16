package guiPractice8.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiPractice8.components.Visible;

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
		loadImages(imageLocation, 0,0);
	}
	
	private void loadImages(String imageLocation, int w, int h) {
		try{
			//get the image from file (FULL SIZE)
			ImageIcon icon = new ImageIcon(imageLocation);
			
			if(w == 0 && h==0){
				//use original size
				image = new BufferedImage(icon.getIconWidth(),
						icon.getIconHeight(),
						BufferedImage.TYPE_INT_ARGB);
				//draw icon onto image
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
						
			}else{
				//use custom size (complete on Monday)
			}
			loadedImages = true;
		}catch(Exception e){
			//in case file is not found
			e.printStackTrace();
		}
	}

	private void loadImages(String imageLocation, double scale) {
		// TODO Auto-generated method stub
		
	}

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth();
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight();
	}

	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update() {
		// does nothing, image never changes
	}

}
