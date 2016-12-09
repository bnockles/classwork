package guiTeacher.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class TextLabel implements Visible {

	private int x;
	private int y;
	private int w;
	private int h;
	private String text;
	private int size;
	private String font;
	private BufferedImage image;
	
	public TextLabel(int x, int y, int w, int h, String text){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		font = "Helvetica";
		size = 20;
		this.text = text;
		
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
		//when updating, delete previous image so no overlap is visible
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g = image.createGraphics();
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		g.setFont(new Font(font,Font.PLAIN,size));
		g.drawString(text, 4, h-5);

	}


	public void setSize(int size) {
		this.size = size;
	}
	
	public void setFont(String font){
		this.font = font;
	}
	
	public void setText(String text){
		this.text = text;
		update();
	}

	public boolean isAnimated() {
		return true;
	}

}
