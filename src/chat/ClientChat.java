package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class ClientChat {
	
	public ClientChat() throws IOException
	{
		Socket echoSocket = new Socket("192.168.0.253", 8989);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput = null;
	
		while (userInput != "exit")
		{
			userInput = stdIn.readLine();
			out.println(userInput);
			// this reads in from the server
		    System.out.println("echo from the server: " + in.readLine());           
		}
	
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	
		/*Runnable server = new ConnectionServer();
		Thread thread = new Thread(server);
		thread.start();
		String serverAddress = JOptionPane.showInputDialog(
				"Enter IP Address of a machine that is\n" +
				"running the server.");
		Socket s = new Socket(serverAddress, 8989);
		
		BufferedReader input =
	            new BufferedReader(new InputStreamReader(s.getInputStream()));
	        String answer = input.readLine();
	        JOptionPane.showMessageDialog(null, answer);
	        System.exit(0);*/
	}
}
