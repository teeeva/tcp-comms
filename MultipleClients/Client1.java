package tcp.distributed;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import static tcp.distributed.trafficGenerator.randomNum;

/**

 */
public class Client1 implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public Client1(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }
    @Override
    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream(); 
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\nIts Alive: " +
        	this.serverText + " - " + time + " " + randomNum.nextInt() + "" ).getBytes()); 

          output.close();
          input.close();
          out.close();
          System.out.println("Request processed: " + time);

        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
