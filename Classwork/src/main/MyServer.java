package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.net.*;
import java.io.*;

import feature.BasicFeature;
import feature.CustomGraphics;
import feature.MouseFollower;

public class MyServer extends JFrame{

	private int windowWidth;
	private int windowHeight;
	private ArrayList<Feature> features;
	private String message;
	private String lastMessage;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;



	public MyServer() {
		applySettings();
		message = "You are running the server!";
		lastMessage ="";
		setVisible(true);
		features = new ArrayList<Feature>();
		addMouseMotionListenerObjects();
		Timer t = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyServer.this.repaint();
			}
		});
		t.start();
	}

	public void showMessage(String s){
		//TODO make messages display
	}

	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100);
			//6789 is the port for this Java application
			//100 is the backlog (number of people to be in line
			//at this port)
			while(true){
				try{
					waitForAConnection();
					setupStreams();
					whileConnected();
				}catch(EOFException eof){
					showMessage("\nServer ended the connection");
				}finally{
					close();
				}
			}

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void waitForAConnection() throws IOException{
		showMessage("Waiting for someone to connect...");
		connection = server.accept();
		showMessage("Now connected to "+
		connection.getInetAddress().getHostName());
	}
	
	
	private void addMouseMotionListenerObjects() {
		MouseFollower follower = new MouseFollower(300, 300);
		features.add(follower);//to make visible
		addMouseMotionListener(follower);//to make active
	}


	public void paint(Graphics screen){
		BufferedImage imageOnTheSide = new BufferedImage(
				getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = imageOnTheSide.createGraphics();


		for(Feature f : features){
			g2.drawImage(f.getImage(),
					f.getX(), 
					f.getY(),null);
		}

		screen.drawImage(imageOnTheSide,0,0,null);
	}

	protected void applySettings() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
		windowWidth = 1000;
		windowHeight = 800;
		setSize(windowWidth,windowHeight);
		setLocation((monitorWidth-windowWidth)/2, (monitorHeight-windowHeight)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//so that the game terminates after the windo is closed
		setUndecorated(false);//windowBar
		setResizable(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyServer();
	}

















}
