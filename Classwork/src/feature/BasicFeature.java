package feature;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.Feature;

public class BasicFeature implements Feature {

	public static final int DEFAULT_WIDTH=50;
	public static final int DEFAULT_HEIGHT=50;
	public static final Color DEFAULT_BACKGROUND=Color.white;
	public static final Color DEFAULT_FOREGROUND=Color.black;
	
	protected BufferedImage image;
	protected int x;
	protected int y;
	protected Color backgroundColor;
	protected Color foregroundColor;
	protected CustomGraphics customizer;
	
	
	public BasicFeature(int x, int y) {
		image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, 
				BufferedImage.TYPE_INT_ARGB);
		this.x = x;
		this.y = y;
		this.backgroundColor = DEFAULT_BACKGROUND;
		this.foregroundColor = DEFAULT_FOREGROUND;
		customizer = null;
		draw();
	}
	
	public BasicFeature(int x, int y, CustomGraphics custom) {
		image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, 
				BufferedImage.TYPE_INT_ARGB);
		this.x = x;
		this.y = y;
		this.backgroundColor = DEFAULT_BACKGROUND;
		this.foregroundColor = DEFAULT_FOREGROUND;
		customizer = custom;
		draw();
	}

	
	
	private void draw() {
		if(customizer == null){
			Graphics2D g2 = image.createGraphics();
			g2.setColor(foregroundColor);
			g2.fillOval(0, 0, image.getWidth(), image.getHeight());			
		}else{
			Graphics2D g2 = image.createGraphics();
			g2.setColor(foregroundColor);
			customizer.drawCustomImage(g2,
					image.getWidth(),
					image.getHeight());
		}
	}



	@Override
	public BufferedImage getImage() {
		return image;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
