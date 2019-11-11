/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.distributed.Simple;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TCPServer {

    public static void main (String args[]) throws IOException {
                 
      

		int serverPort = 6791; 
		ServerSocket listenSocket = new 
                                       ServerSocket(serverPort);
                JFrame frame = new JFrame("TCP Server");
                        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());     
         JTextArea text = new JTextArea("Awaiting Connection");

        JButton button = new JButton();
        
    button.setText("Close Connection");
        panel.add(text);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


		while(true) {  
		  Socket clientSocket = listenSocket.accept();
		  Connection c = new Connection(clientSocket);
                  text.append("\n" + "Connection Established on socket " + serverPort); 
                  
		}
        
}
}