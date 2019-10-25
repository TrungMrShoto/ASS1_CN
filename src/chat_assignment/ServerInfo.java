/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import java.net.InetAddress;

/**
 *
 * @author dell
 */
public class ServerInfo {

    /**
     *
     */
    private static ParseRoute pr = ParseRoute.getInstance();
    public static String IP = "10.28.8.144";
    public static String getIP()
    {
        return pr.getLocalIPAddress();
    }
   
     
    //public static String IP = ;
}
