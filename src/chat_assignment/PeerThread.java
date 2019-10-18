
package chat_assignment;

import commom.User;
import java.awt.Color;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author dell
 */
public class PeerThread extends Thread{
    private BufferedReader buffered;
    private String message;
    //private JTextPane Texthistory;
    private User userInfo;
    String header;
    String My_IP;
    //private final String IP_Of_this_message;
    
    public PeerThread(Socket socket) throws IOException {
        buffered = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //Texthistory = chat;
        buffered = null;
        //this.IP_Of_this_message = IPOfThisMessage;
    }

    //
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                
                message = buffered.readLine();
                header = message.substring(0,2);
                message = message.substring(message.indexOf("<"));
                String IP_friend = message.substring(message.indexOf("<")+1,message.indexOf(">"));
                message = message.substring(message.indexOf("<")+IP_friend.length()+2);
                //if (IP_friend.equals())
                if (header.equals("@f"))
                {   
                    String friend_name  = message.substring(message.indexOf("<")+1,message.indexOf(">"));
                    message = message.substring(message.indexOf("<")+2+friend_name.length());
                    String fileName = message.substring(message.indexOf("<")+1,message.indexOf(">"));
                    message = message.substring(message.indexOf(">")+1);
                    FileWriter file = new FileWriter("d:\\Test\\"+fileName);
                    PrintWriter writeToFile;
                    writeToFile = new PrintWriter(file);
                    writeToFile.print(message);
                    writeToFile.close();
                    SendMessage("[" + friend_name +"]:\t I just sent you a file which located in (d:\\"+fileName+")");
                    //Texthistory.setText(Texthistory.getText()+"\n["+userName+"]:\t I just send you a file and the file located in (d:\\"+fileName+")");
                }
                else
                {
                    SendMessage(message);
                    //Texthistory.setText(Texthistory.getText()+"\n"+message);
                }
                    

            } catch (IOException e) {
                flag = false;
                interrupt();
            }
        }
    }
    
    private void SendMessage(String input) {
        Color color = Color.BLACK;
        Append_Message(input, color);
    }

    private void Append_Message(String content, Color color) {
        if (!content.isEmpty()) {
            Mess_content(content);
        }
    }

    private void Mess_content(String content) {
        //Texthistory.setEditable(true);
        //int len = Texthistory.getDocument().getLength();
        //Texthistory.setCaretPosition(len);
        //Texthistory.setCharacterAttributes(MessageStyle.styleMessageContent(Color.darkGray, "San Francisco", 16), false);
        //Texthistory.replaceSelection(content + "\n");
        //Texthistory.setEditable(false);
    }

}
