package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionServer implements Runnable {
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(8989);
			Socket clientConnection = server.accept();

			Scanner input = new Scanner(clientConnection.getInputStream());
			PrintWriter out = new PrintWriter(clientConnection.getOutputStream(), true); 
			
			String chatMessage;
			while (clientConnection.isConnected() && !clientConnection.isClosed()) {
				chatMessage = input.nextLine();
				//System.out.println("server said: "+ chatMessage);
				
				// this sends chatMessage out to the client
				out.println(chatMessage); 
				
				if (chatMessage.equals("exit")) {
					clientConnection.close();
					break;
				}
			}

			server.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
