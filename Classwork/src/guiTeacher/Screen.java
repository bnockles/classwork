package guiTeacher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Screen {

	protected BufferedImage image;
	protected List<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects();
		initImage(width, height);
	}

	/**
	 * adds objects to viewObjects 
	 */
	public void initObjects() {
		
	}

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}

	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		g.drawString("Look! Text is printed!", 30, 60);
		//iterate through 
	}
	
	public Image getImage(){
		return image;
	}

}
