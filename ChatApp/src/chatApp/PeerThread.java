package chatApp;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class PeerThread extends Thread {

    private BufferedReader buffered;
    private String message;
    private TextArea Texthistory;
    
    public PeerThread(Socket socket, TextArea chat) throws IOException {
        buffered = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Texthistory = chat;
    }

    //
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                message = buffered.readLine();
                Texthistory.setText(Texthistory.getText()+"\n"+message.toString());

            } catch (IOException e) {
                flag = false;
                interrupt();
            }
        }
    }
}
