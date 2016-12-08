package guiTeacher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Ball extends Component {

	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		g.fillOval(0, 0, getWidth(), getHeight());
	}


}
