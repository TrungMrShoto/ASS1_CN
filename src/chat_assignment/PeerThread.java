package chat_assignment;

import commom.User;
import java.awt.Color;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author dell
 */
public class PeerThread extends Thread {

    private BufferedReader buffered = null;
    private String message;
    //private JTextPane Texthistory;
    private User userInfo;
    String header;
    String My_IP;
    private JTextArea private_chatHistory;
    private JTextArea public_chatHistory = null;
    private String myID;
    private String myfriend_ID;
    //private final String IP_Of_this_message;

    public PeerThread(Socket socket, JTextArea private_chat, JTextArea public_chat) throws IOException {
        this.private_chatHistory = private_chat;
        this.public_chatHistory = public_chat;
        System.out.println(public_chat.getText());
        buffered = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //this.IP_Of_this_message = IPOfThisMessage;
    }

    //
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                message = buffered.readLine();

                header = message.substring(0, 2);
                message = message.substring(message.indexOf("<"));
                String ID_ME = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                message = message.substring(message.indexOf("<") + ID_ME.length() + 2);
                String friend_ID = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                message = message.substring(message.indexOf("<") + friend_ID.length() + 2);
                if (header.equals("@f")) {
                    String friend_name = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                    message = message.substring(message.indexOf("<") + 2 + friend_name.length());
                    String fileName = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                    message = message.substring(message.indexOf(">") + 1);
                    FileWriter file = new FileWriter("d:\\Test\\" + fileName);
                    PrintWriter writeToFile;
                    writeToFile = new PrintWriter(file);
                    writeToFile.print(message);
                    writeToFile.close();

                    private_chatHistory.append("[" + friend_name + "]:\t I just sent you a file which located in (d:\\" + fileName + ")" + "\n");
                    public_chatHistory.setText(public_chatHistory.getText());
                } else {
                    private_chatHistory.append(message + "\n");
                    public_chatHistory.setText(public_chatHistory.getText());
                }

            } catch (IOException e) {
                flag = false;
                interrupt();
            }
        }
    }

}
