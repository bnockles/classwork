package Networking;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyServer extends JFrame{

	//Java Tutorial 38
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;//In JAva, connections are called "sockets"
	
	public MyServer(){
		super("Mr. Nockles' Instant Messenger");
		userText = new JTextField();
		userText.setEditable(false);//sets to false until a connection is made
		userText.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				sendMessage(e.getActionCommand());//sends the text typed into the field
				userText.setText("");
			}
		});
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	
	//set up and run the server
	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100);//port number (6789 is a dummy number) 
			//every computer has multiple applications, so whenever I connect to a server, we have to find the application that we want to interact with
			//this lets "the boat" with the information entering the computer find the port number for the application
			//100 is the backlog, which tells how many people can be waiting to wait at the port
			//from the client side application, you must also use the port number
			while(true){
				try{
					//connect and have conversation with someone else
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException eofException){
					showMessage("\n Server ended the connection!");
				}finally{
					close();
				}
			}
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
