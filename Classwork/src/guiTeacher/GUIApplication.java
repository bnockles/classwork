package guiTeacher;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 390738816689963935L;
	private Screen currentScreen;
	private boolean scaleWithWindow; 
	
	//this method gets deleted once generalized
//	public static void main(String[] args){
//		Thread app = new Thread(new GUIApplication(500, 500));
//		app.start();
//	}
	
	public GUIApplication(int width, int height){
		super();
		scaleWithWindow = true;
		setBounds(20, 20, width, height);
		initScreen();
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//this method becomes abstract once generalized
//	public void initScreen() {
//		TextScreen startScreen= new TextScreen("Hi everyone",getWidth(), getHeight());
//		addMouseMotionListener(new CoordinateListener(startScreen));
//		setScreen(startScreen);
//		
//	}
	
	public abstract void initScreen();

	public void setScreen(Screen screen) {
		if(currentScreen.getMouseListener() != null) removeMouseListener(currentScreen.getMouseListener());
		currentScreen = screen;
		if(currentScreen.getMouseListener() != null)addMouseListener(currentScreen.getMouseListener());
	}
	
	public void paint(Graphics g){
		if(scaleWithWindow){
			g.drawImage(currentScreen.getImage(), 0, 0, getWidth(),getHeight(),null);
		}else{
			
			g.drawImage(currentScreen.getImage(), 0, 0, null);
		}
	}

	public void run() {
		while(true){
			currentScreen.update();
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
