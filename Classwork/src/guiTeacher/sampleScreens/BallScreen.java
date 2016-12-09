package guiTeacher.sampleScreens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import guiTeacher.components.Visible;
import guiTeacher.sampleObjects.Ball;
import guiTeacher.userInterfaces.Screen;

public class BallScreen extends Screen implements MouseMotionListener{

	private Ball ball;
	
	public BallScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		ball = new Ball(40,40,50,50); 
		viewObjects.add(ball);
	}

	public void setBallPosition(int x, int y) {
		ball.setX(x);
		ball.setY(y);
		update();
	}

	@Override
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent m) {
		setBallPosition(m.getX(), m.getY());
	}

}
