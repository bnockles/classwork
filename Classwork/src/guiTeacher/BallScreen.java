package guiTeacher;

import java.util.List;

public class BallScreen extends Screen {

	private Ball ball;
	Mou
	
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
		
	}

}
