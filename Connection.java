/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.distributed.Simple;
import java.net.*;
import java.io.*; 

/**
 *
 * @author o
 */
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
	    try {
		clientSocket = aClientSocket;
		in = new DataInputStream( clientSocket.getInputStream());
		out =new DataOutputStream( clientSocket.getOutputStream());
		this.start();
	     
} catch(IOException e)  {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
	    try {			                 // an echo server
		String data = in.readUTF();	                 
		out.writeUTF(data);
	    } catch(EOFException e) {System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e) {System.out.println("IO:"+e.getMessage());}
	    
 finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
	}
}

