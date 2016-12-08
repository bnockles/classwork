package guiTeacher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen {

	private BufferedImage image;
	private List<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initImage(width, height);
		initObjects();
	}

	/**
	 * adds objects to viewObjects 
	 */
	public abstract void initObjects();

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}

	public int getWidth(){
		return image.getWidth();
	}
	
	public int getHeight(){
		return image.getHeight();
	}
	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		//iterate through all fiew objects
		for(Visible v: viewObjects){
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
//		g.drawString("Look! Text is printed!", 30, 60);
	}
	
	public void remove(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(v);
		}
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(0, v);
		}
	}
	
	public Image getImage(){
		return image;
	}

}
