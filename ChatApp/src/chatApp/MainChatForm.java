package chatApp;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainChatForm extends JFrame {

    public MainChatForm() {
        initComponents();
    }
    private String username;
    private ServerThread serverThread;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        PortQues = new java.awt.TextField();
        ConnectPeer = new java.awt.TextField();
        ChatHistory = new java.awt.TextArea();
        UserName = new java.awt.TextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        NewMsg = new java.awt.TextField();
        Send = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setName("panel"); // NOI18N

        PortQues.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PortQues.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PortQues.setName("PortQues"); // NOI18N
        PortQues.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PortQuesKeyPressed(evt);
            }
        });

        ConnectPeer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ConnectPeer.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ConnectPeer.setName("ConnectPeer"); // NOI18N
        ConnectPeer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ConnectPeerKeyPressed(evt);
            }
        });

        ChatHistory.setEditable(false);

        UserName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        UserName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        UserName.setName("PortQues"); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("UserName");

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Your Port:");

        label3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label3.setText("Your port's friend (use comma to seperate):");

        NewMsg.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NewMsg.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NewMsg.setName("ConnectPeer"); // NOI18N
        NewMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NewMsgKeyPressed(evt);
            }
        });

        Send.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(NewMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Send))
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PortQues, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ChatHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConnectPeer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2346, 2346, 2346))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PortQues, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConnectPeer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 341, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChatHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NewMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );

        label1.getAccessibleContext().setAccessibleName("label1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectPeerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConnectPeerKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            if (ConnectPeer.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Connect Peer aren't empty");
            } else {
                try {
                    updateListenToPeer(username, serverThread);
                    //ConnectPeer.setEditable(false);
                    ConnectPeer.setEnabled(false);
                } catch (Exception ex) {
                    Logger.getLogger(MainChatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //String[] setupValues = bufferedReader.readLine().split(" ");
        }
    }//GEN-LAST:event_ConnectPeerKeyPressed

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        communicate();
    }//GEN-LAST:event_SendActionPerformed

    private void PortQuesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PortQuesKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            if (UserName.getText().isEmpty() || PortQues.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username, Port aren't empty");
            } else {
                int portNumber;
                try {
                    portNumber = Integer.parseInt(PortQues.getText().trim());
                    username = UserName.getText();
                    if (portNumber >= 1024 && portNumber < 65536) {
                        serverThread = new ServerThread(portNumber, ChatHistory);
                        serverThread.start();
                        PortQues.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Your server port must be greater than 1024 and less than 65536");
                    }
                } catch (NumberFormatException | NullPointerException nfe) {
                    JOptionPane.showMessageDialog(this, "You must be type all number");
                } catch (Exception ex) {
                    Logger.getLogger(MainChatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //String[] setupValues = bufferedReader.readLine().split(" ");
        }
    }//GEN-LAST:event_PortQuesKeyPressed

    private void NewMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NewMsgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            communicate();
    }//GEN-LAST:event_NewMsgKeyPressed
    
    private void updateListenToPeer(String username, ServerThread serverT) throws Exception {
        String[] inputValues = ConnectPeer.getText().trim().split(",");
        for (String address : inputValues) {
            Socket socket = null;
            try {
                socket = new Socket("localhost", Integer.valueOf(address));
                new PeerThread(socket,ChatHistory).start();
            } catch (IOException | NumberFormatException e) {
                if (socket != null) {
                    socket.close();
                } else {
                    JOptionPane.showMessageDialog(this, "invalid input");
                    System.exit(0);
                }
            }   
        }
        //communicate(username, serverT);
    }
    
    private void communicate() {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(new ByteArrayInputStream(NewMsg.getText().getBytes())));
        try {
            boolean flag = true;
            while (flag) {
                String message = buffer.readLine();
                if (message.equals("@e")){
                        break;
                }else if (message.equals("@c")){
                        ConnectPeer.setEnabled(true);
                        updateListenToPeer(username, serverThread);
                } else{
                        if (message.isEmpty())
                            message = " ";
                        StringWriter stringW = new StringWriter();
                        stringW.append("[" + username + "]:" + message);
                        serverThread.sendMessage(stringW.toString());
                        ChatHistory.setText(ChatHistory.getText()+"\n"+message.toString());
                        //ChatHistory.append(message.toString());
                        NewMsg.setText("");
                }
            }
            System.exit(0);
        } catch (Exception e) {
        }
    }
        /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame main = new MainChatForm();
                //main.setResizable(false);
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea ChatHistory;
    private java.awt.TextField ConnectPeer;
    private java.awt.TextField NewMsg;
    private java.awt.TextField PortQues;
    private javax.swing.JButton Send;
    private java.awt.TextField UserName;
    private java.awt.Canvas canvas1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
