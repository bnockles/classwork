package guiTeacher.sampleGames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.MovingComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.components.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.Screen;

public class AnimationScreen extends ClickableScreen {

	private AnimatedComponent a;
	private MovingComponent m;
	private Button restart;

	public AnimationScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		int w = 165;
		int h = 293;
		int numberInRow =12;
		int rows = 5;
		a = new AnimatedComponent(40, 40, w, h);
		m = new MovingComponent(0, 20, 40, 40);
		m.setVy(3);
		m.setVx(5);
		restart = new Button(20, getHeight()-70, 190, 40, "Restart Animation", new Color(200, 210,150), new Action(){

			public void act() {
				if(!a.isRunning()){
					a.setX(40);
					Thread animation = new Thread(a);
					animation.start();
				}
			}
			
		
		});
		try{
			ImageIcon icon = new ImageIcon("resources/sampleImages/sprite2.png");
			for(int i = 0; i < numberInRow * rows; i++){
				
				BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				int leftMargin = 0;
				int topMargin = 0;
				int x1 = leftMargin+w*(i%numberInRow);
				int y1 = topMargin+h*(i/numberInRow);
				g.drawImage(icon.getImage(), 0,0,w, h, x1, y1,x1+w, y1+h, null);
				a.addFrame(image, 20);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		TextLabel text = new TextLabel(40,300,350,50,"Animation should appear above");
		a.setVx(2);
		a.setRepeat(false);
		viewObjects.add(a);
		
		
		Thread movingFigure = new Thread(a);
		movingFigure.start();
		Thread ball = new Thread(m);
		ball.start();
		
		viewObjects.add(text);
		viewObjects.add(restart);
		viewObjects.add(m);
	}

}
