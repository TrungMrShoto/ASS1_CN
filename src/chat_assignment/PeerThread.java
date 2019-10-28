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

    private JTextArea private_chatHistory;
    private JTextArea public_chatHistory = null;
    private int ip_friend;
    private int ip_me;
    private String Group_name;
    private JTextArea private_ChatGroup;
    //private final String IP_Of_this_message;

    public PeerThread(Socket socket, JTextArea private_chat, JTextArea public_chat, int ip_friend, int my_ip, JTextArea private_group, String name) throws IOException {
        this.private_chatHistory = private_chat;
        this.public_chatHistory = public_chat;
        this.private_ChatGroup = private_group;
        this.ip_friend = ip_friend;
        this.ip_me = my_ip;
        this.Group_name = name;
        buffered = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //this.IP_Of_this_message = IPOfThisMessage;
    }

    //
    @Override
    public void run() {
        String ID_ME;
        String friend_ID;
        String friend_name;
        String fileName;
        String header;
        String NAME_GROUP;
        boolean flag = true;
        while (flag) {
            try {
                message = buffered.readLine();
                if (message != null) {
                    header = message.substring(0, 2);
                    //System.out.println(header);
                    if (!header.equals("@g")) {
                        message = message.substring(message.indexOf("<"));
                        ID_ME = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                        message = message.substring(message.indexOf("<") + ID_ME.length() + 2);
                        friend_ID = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                        message = message.substring(message.indexOf("<") + friend_ID.length() + 2);
                        if (ip_friend == Integer.valueOf(friend_ID) && ip_me == Integer.valueOf(ID_ME)) {
                            if (header.equals("@f")) {
                                friend_name = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                                message = message.substring(message.indexOf("<") + 2 + friend_name.length());
                                fileName = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                                message = message.substring(message.indexOf(">") + 1);
                                FileWriter file = new FileWriter("d:\\" + fileName);
                                PrintWriter writeToFile;
                                writeToFile = new PrintWriter(file);
                                writeToFile.print(message);
                                writeToFile.close();
                                private_chatHistory.append("[" + friend_name + "]:\t I just sent you a file which located in (d:\\" + fileName + ")" + "\n");
                                public_chatHistory.setText(private_chatHistory.getText());
                            } else {
                                private_chatHistory.append(message + "\n");
                                public_chatHistory.setText(private_chatHistory.getText());
                            }
                        }
                    } else {
                        message = message.substring(message.indexOf("<"));
                        NAME_GROUP = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                        if (NAME_GROUP.equals(Group_name)) {
                            message = message.substring(message.indexOf("<") + NAME_GROUP.length() + 2);
                            private_ChatGroup.append(message + "\n");
                            public_chatHistory.setText(private_ChatGroup.getText());
                        }
                    }
                }

            } catch (IOException e) {
                flag = false;
                interrupt();
            }
        }
    }

}
