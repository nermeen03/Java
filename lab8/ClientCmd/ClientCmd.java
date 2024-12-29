/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcmd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nerme
 */
public class ClientCmd {
    Socket server;
    DataInputStream ear;
    DataOutputStream mouth;
    public ClientCmd(){
        try {
            server = new Socket("127.0.0.1",1);
            ear = new DataInputStream(server.getInputStream());
            mouth = new DataOutputStream(server.getOutputStream());
            mouth.writeUTF("can you hear me?");
            String msg = ear.readUTF();
            System.out.println(msg);
        } catch (IOException ex) {
            Logger.getLogger(ClientCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClientCmd();
    }
    
}
