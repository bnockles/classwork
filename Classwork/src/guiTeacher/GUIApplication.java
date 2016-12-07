package guiTeacher;

import java.awt.Graphics;

import javax.swing.JFrame;

public class GUIApplication extends JFrame{
	private Screen currentScreen;
	private boolean scaleWithWindow; 
	
	public static void main(String[] args){
		new GUIApplication(500, 500);
	}
	
	public GUIApplication(int width, int height){
		super();
		scaleWithWindow = true;
		setBounds(20, 20, width, height);
		initScreen();
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void initScreen() {
		Screen startScreen= new Screen(getWidth(), getHeight());
		setScreen(startScreen);
		
	}

	public void setScreen(Screen startScreen) {
		currentScreen = startScreen;
	}
	
	public void paint(Graphics g){
		if(scaleWithWindow){
			g.drawImage(currentScreen.getImage(), 0, 0, getWidth(),getHeight(),null);
		}else{
			
			g.drawImage(currentScreen.getImage(), 0, 0, null);
		}
	}
}
