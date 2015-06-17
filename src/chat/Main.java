package chat;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Main{
	
	public static void main(String[] args) throws IOException
	{
		
		//ChatFrame chat = new ChatFrame();
	
		Runnable server = new ConnectionServer();
		Thread thread = new Thread(server);
		thread.start();
		
		ClientChat client = new ClientChat();
	}

}
