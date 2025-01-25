/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servergui;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nerme
 */

public class ServerGUI{
        ServerSocket serverSocket;
        public ServerGUI()
        {
            try {
                serverSocket = new ServerSocket(2);
            } catch (IOException ex) {
                Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        while(true)
        {
            Socket s;
                try {
                    s = serverSocket.accept();
                    new ChatHandler(s);
                } catch (IOException ex) {
                    Logger.getLogger(ServerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
        public static void main(String[] args)
        {
            new ServerGUI();
        }
}
class ChatHandler extends Thread
{
    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
    public ChatHandler(Socket cs)
    {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            clientsVector.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try {
                String str = dis.readLine();
                sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    void sendMessageToAll(String msg)
    {
        for (ChatHandler client : clientsVector) {
                client.ps.println(msg);
        }
    }
}