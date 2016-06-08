package main;

//period 8
import java.awt.image.BufferedImage;

public interface Feature {

	BufferedImage getImage();
	int getX();
	int getY();
	void setX(int x);
	void setY(int y);
	
}
