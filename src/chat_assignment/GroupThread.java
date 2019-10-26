/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author T_TRUNG10
 */
public class GroupThread extends Thread {

    private BufferedReader buffered = null;
    private String message;

    private String Group_name;
    private JTextArea private_ChatGroup;
    private JTextArea public_ChatGroup;

    public GroupThread(Socket socket, JTextArea private_group, JTextArea public_group, String name) throws IOException {
        this.private_ChatGroup = private_group;
        this.public_ChatGroup = public_group;
        this.Group_name = name;
        buffered = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String header;
        String NAME_GROUP;
        boolean flag = true;
        while (flag) {
            try {
                message = buffered.readLine();
                header = message.substring(0, 2);
                if (header.equals("@g")) {
                    message = message.substring(message.indexOf("<"));
                    NAME_GROUP = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
                    if (NAME_GROUP.equals(Group_name)) {
                        message = message.substring(message.indexOf("<") + NAME_GROUP.length() + 2);
                        private_ChatGroup.append(message + "\n");
                        public_ChatGroup.setText(private_ChatGroup.getText());
                    }
                }
            } catch (IOException ex) {
                flag = false;
                interrupt();
            }

        }
    }
}
