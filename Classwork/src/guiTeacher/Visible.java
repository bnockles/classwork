package guiTeacher;

import java.awt.image.BufferedImage;

public interface Visible {

	public BufferedImage getImage();
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public void update();
	public boolean isDynamic();
	public boolean isAnimated();
}
