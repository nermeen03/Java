/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nerme
 */
public class Server {
    ServerSocket server;
       Socket waiter;
       DataInputStream ear;
       DataOutputStream mouth;
       
       public Server(){
           try {
               server = new ServerSocket(1);
               waiter = server.accept();
               ear = new DataInputStream(waiter.getInputStream());
               mouth = new DataOutputStream(waiter.getOutputStream());
               String msg = ear.readUTF();
               System.out.println("Client say "+msg);
               mouth.writeUTF("I can hear you");
           } catch (IOException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
               try {
                   server.close();
               } catch (IOException ex) {
                   Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Server();
    }
    
}
