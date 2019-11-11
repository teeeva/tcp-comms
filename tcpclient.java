/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.distributed.Simple;
import java.awt.FlowLayout;
import java.net.*;
import java.io.*; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class tcpclient {
	public static void main (String args[]) {
	Socket s = null;
                JFrame frame = new JFrame("TCP Client");
                        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());     
         JTextArea text = new JTextArea("Connecting");

        JButton button = new JButton();
        
    button.setText("Close Connection");
        panel.add(text);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
	    try{ int serverPort = 6791; 
               s = new Socket("localhost", serverPort);    
		DataInputStream in = new DataInputStream(    
                                             s.getInputStream());
		DataOutputStream out =
			new DataOutputStream( s.getOutputStream());
		out.writeUTF("Message");        	// UTF is a string encoding
		String data = in.readUTF();	      
		System.out.println("Received: " + data ) ;  
                System.lineSeparator();
                text.append( "\n" + data);
       	    }catch (UnknownHostException e){
			System.out.println("Sock:"+e.getMessage()); 
	    }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
    	    }catch (IOException e){System.out.println("IO:"+e.getMessage());}
	 finally {if(s!=null) 
            try {s.close();
            }catch (IOException e){
                System.out.println("close:"+e.getMessage());}
            }
  	}
}
