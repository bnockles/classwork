package guiTeacher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class TextLabel implements Visible {

	private int x;
	private int y;
	private int w;
	private int h;
	private String text;
	private BufferedImage image;
	
	public TextLabel(int x, int y, int w, int h, String text){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		update();
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return y;
	}

	public int getHeight() {
		return h;
	}

	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.black);
		g.drawString(text, 4, h-5);

	}

	public boolean isDynamic() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

}
