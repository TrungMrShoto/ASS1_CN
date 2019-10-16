/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.ITALIC;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Meep
 */
public class ChatMainForm extends JFrame {
    Socket socket;
    
    private static  int numOFriend=19;
    private static String  Accountid="Sub";
    private static String[] Friendslist;
    
    private static String final_sendUser="xx";
    /**
     * Creates new form ChatMainForm
     */
    public ChatMainForm(String id) {
setIcon();
        Accountid=id;        
        setTitle("Chat Room");
        this.getRootPane().setDefaultButton(btnSend);
        initComponents();
        AttributeSetup();
        setTabValue_Friends();     
        //JOptionPane.showMessageDialog(this,"Welcome" + Accountid);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMessage = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        btnClip = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMesslog = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMessageKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane2.addTab("Friends", jScrollPane1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel6);

        jTabbedPane2.addTab("Request", jScrollPane2);

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_send-01_186386.png"))); // NOI18N
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSendMouseClicked(evt);
            }
        });
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        btnSend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSendKeyPressed(evt);
            }
        });

        btnClip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_clip_115756.png"))); // NOI18N

        jScrollPane3.setViewportView(txtMesslog);

        jMenu1.setText("File");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_exit_2739118.png"))); // NOI18N
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Option");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_67_111124.png"))); // NOI18N
        jMenuItem1.setText("Search");
        jMenuItem1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_Artboard_7_3775353.png"))); // NOI18N
        jMenuItem2.setText("Contact Dev-Team");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
                    SendMessage();        
    }//GEN-LAST:event_btnSendActionPerformed
    private void SendMessage(){
        String input= txtMessage.getText();
        String sender=Accountid;
        Color color= Color.BLUE;
        Append_Message(sender,input,color);
//        txtMesslog.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        txtMesslog.setText(txtMesslog.getText()+"\n"+input);
////        txtMesslog.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        txtMessage.setText("");
    }
    private void btnSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnSendMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        SearchForm s= new SearchForm();
        s.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem1MenuKeyPressed
      
    }//GEN-LAST:event_jMenuItem1MenuKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        LogoutPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         JOptionPane.showMessageDialog(null,"If you want to support us, please contact at our email!!!");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnSendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSendKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            System.out.println("Ues");
            SendMessage();
        }
    }//GEN-LAST:event_btnSendKeyPressed

    private void txtMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMessageKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            System.out.println("Ues");
            SendMessage();
        }
    }//GEN-LAST:event_txtMessageKeyPressed
   
    private void LogoutPerformed(java.awt.event.ActionEvent evt){
        int confirm= JOptionPane.showConfirmDialog(null, "Logout?");
        if(confirm==0)
        {
            this.setVisible(false);
                LoginForm Login=new LoginForm();
                Login.setVisible(true);
//            try{
//                socket.close();
//                this.setVisible(false);
//                LoginForm Login=new LoginForm();
//                Login.setVisible(true);
//            }
//            catch(IOException e){
//                System.out.println(e.getMessage());
//                
//            }
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
            java.util.logging.Logger.getLogger(ChatMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame menu = new ChatMainForm(Accountid);
                menu.setVisible(true);
            }
        });
    }
    private void setTabValue_Friends(){
        String[] name={"Lulu","Relu","Closure","a","g","ag","wgaw,","wgawa","gawgwa","gawgwa","gawgwa","gawgaw","gawgwa","gawgwa","gawgwag,","awgwa","gawegaw123123"};
        boolean[] onl={true,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
        
//        jPanel1.setLayout( new FlowLayout() );
        int i=0;
        int co_x=10;
        int co_y=50*i;
        int panel_weight=220;
        int panel_height=50;
        numOFriend=name.length;
        for( i=0;i<name.length;i++)
        {
            co_y=50*i;
             String temp="JButton"+i;
             JButton btn= new JButton(temp);
             btn.setBounds(co_x, co_y, panel_weight, panel_height);
             if(onl[i]==true)
             {
             JLabel onl_icon=new JLabel();
             onl_icon.setText("");
             onl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_Icon_Element_Earth_02_513724.png")));
             onl_icon.setBounds(co_x+220+3, co_y, panel_weight, panel_height);             
             jPanel1.add(onl_icon);             
             }
             else
             {
                 JLabel onl_icon=new JLabel();
             onl_icon.setText("");
             onl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_b_4_2578285.png")));
             onl_icon.setBounds(co_x+220+8, co_y, panel_weight, panel_height);             
             jPanel1.add(onl_icon);                        
             }            
             btn.setText(name[i]);            
             jPanel1.add(btn);
        }
        
        
    }
    private void AttributeSetup(){
//        txtMesslog.setLineWrap(true);
//        txtMesslog.setWrapStyleWord(true);
        txtMessage.requestFocus();

        txtMesslog.setFont(new Font("Serif", ITALIC, 16));
        
//        jScrollPane1.setBounds(5,5,273,637);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jPanel1.setPreferredSize(new Dimension(273, 50*numOFriend));
        
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        
        this.setResizable(false);
//        jTabbedPane2.setBounds(10, 10, 267, 800);
    }
    /*Hiển thị tin nhán chat*/
    private void Append_Message(String header,String content,Color headCol){
        if(!content.isEmpty())
        {
            Mess_header( header,headCol);
            Mess_content( content);           
        }
    }
    private void Mess_header(String header,Color color){
       System.out.println("Last send: "+ final_sendUser);
        if(!header.equals(final_sendUser) )
        {
            int len = txtMesslog.getDocument().getLength();
            txtMesslog.setCaretPosition(len);       
            txtMesslog.setCharacterAttributes(MessageStyle.styleMessageContent(color, "San Francisco", 13), false);        
            txtMesslog.replaceSelection(header+":");
        }
        else
        {
            int len = txtMesslog.getDocument().getLength();
            txtMesslog.setCaretPosition(len);       
            txtMesslog.setCharacterAttributes(MessageStyle.styleMessageContent(Color.MAGENTA, "San Francisco", 13), false);  
            for(int i=0;i<header.length()+3;i++)
                txtMesslog.replaceSelection(" ");
        }
        System.out.println("Last send: "+ final_sendUser);
        final_sendUser=header;
    }
    private void Mess_content(String content){
        int len = txtMesslog.getDocument().getLength();
        txtMesslog.setCaretPosition(len);       
        txtMesslog.setCharacterAttributes(MessageStyle.styleMessageContent(Color.darkGray, "San Francisco", 16), false); 
        txtMesslog.replaceSelection(content+"\n");
    }
    private void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chat_assignment/res/iconfinder_flower_1055057.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClip;
    private javax.swing.JButton btnSend;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextPane txtMesslog;
    // End of variables declaration//GEN-END:variables
}
