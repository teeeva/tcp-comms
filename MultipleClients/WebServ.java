/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.distributed;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author o
 */
public class WebServ implements Runnable {
protected Socket clientSocket = null;
    protected String serverText   = null;

    public WebServ(Socket webSocket) {
   
        this.clientSocket = webSocket;
    }    

    WebServ(Socket webSocket, String sthelens_Road) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
            PrintWriter out;
    try {
        out = new PrintWriter(clientSocket.getOutputStream());
        long time = System.currentTimeMillis();
            out.write("<p> Test</p> <p> Testy</p>" );
            clientSocket.getOutputStream();
            out.print(time);
          out.close();
            System.out.println("Request processed: " + time);
    } catch (IOException ex) {
        Logger.getLogger(WebServ.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    }
}


    

