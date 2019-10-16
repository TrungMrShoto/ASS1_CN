package chatApp;

import java.awt.TextArea;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread{
	private ServerSocket serverSocket;
	private Set<ServerThreadThread> serverTTs = new HashSet<ServerThreadThread>();
	//Make SocketServer for each peer

    /**
     *
     * @param portNumb
     * @throws IOException
     */
	public ServerThread(int portNumb, TextArea text) throws IOException {
		serverSocket = new ServerSocket(portNumb);
	}
	
        @Override
	public void run()
	{
		try {
			while (true)
			{
				ServerThreadThread serverTT = new ServerThreadThread(serverSocket.accept(), this);
				serverTTs.add(serverTT);
				serverTT.start();
			}
		} catch (IOException e) {
		}
	}
	
	void sendMessage(String message) {
		try {
			serverTTs.forEach(t-> t.getPrintWriter().println(message));
		} catch (Exception e) {
		}
	}
	//get all serverThread
	public Set<ServerThreadThread> getServerThread(){
		return serverTTs;
	}
	
}
