package chatApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadThread extends Thread{
	private ServerThread serverT;
	private Socket socket;
	private PrintWriter printWriter;
	public ServerThreadThread(Socket socket, ServerThread serverThread)
	{
		this.serverT = serverThread;
		this.socket = socket;
	}
        @Override
	public void run() {
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.printWriter = new PrintWriter(socket.getOutputStream(),true);
			while(true)
			{
				serverT.sendMessage(buffer.readLine());
			}
		} catch (IOException e) {
			serverT.getServerThread().remove(this);
		}
	}
	
	public PrintWriter getPrintWriter() {
		return printWriter;
	}
}
