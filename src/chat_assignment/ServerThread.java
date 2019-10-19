package chat_assignment;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread{
	private ServerSocket serverSocket;
	private Set<ServerThreadThread> serverTTs = new HashSet<ServerThreadThread>();
	
	//Make SocketServer for the peer
	public ServerThread(int portNumb) throws NumberFormatException, IOException {
		serverSocket = new ServerSocket(portNumb);
	}
	
	public void run()
	{
		try {
			while (true)
			{
				ServerThreadThread serverTT = new ServerThreadThread(serverSocket.accept(), this);
                                //Thread.sleep(3000);
				serverTTs.add(serverTT);
				serverTT.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
        //send message for other peers
	void sendMessage(String message) {
		try {
			serverTTs.forEach(t-> t.getPrintWriter().println(message));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//get all serverThread
	public Set<ServerThreadThread> getServerThread(){
		return serverTTs;
	}
	
}
