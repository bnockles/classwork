package Networking;

import javax.swing.JFrame;

public class ServerTest {

	public static void main(String[] arg){
		MyServer sally = new MyServer();
		sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sally.startRunning();
	}
}
