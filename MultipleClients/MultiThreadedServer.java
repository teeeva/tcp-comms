/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.distributed;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author o
 */
public abstract class MultiThreadedServer implements Runnable{

    protected int          serverPort   = 8888;
    protected int          clientPort   = 8081;
    protected ServerSocket serverSocket = null;
    protected ServerSocket clientSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;
    protected Thread       thread2=null;
    public static final String MESSAGE = "MESSAGE THEREE";
    MultiThreadedServer obj;

    /**
     *
     * @param port
     * @throws java.rmi.RemoteException
     */
    public MultiThreadedServer(int port) throws RemoteException{
        this.serverPort = port;
        this.clientPort = 81;
    }   
    @Override
    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();    
        }
        openServerSocket();
        openClientSocket();
        while(! isStopped()){
            Socket serverSocket = null;
            Socket clientSocket = null;
            try {
                serverSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
               new Thread(
                new Client1(
                   serverSocket, "Multithreaded Server")
            ).start();    
            try {
               clientSocket = this.clientSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
            new Thread( 
                new Client2(
                clientSocket, "Sthelens Road")
            ).start();  
//            try {
//               webSocket = this.clientSocket.accept();
//            } catch (IOException e) {
//                if(isStopped()) {
//                    System.out.println("Server Stopped.") ;
//                    return;
//                }
//                throw new RuntimeException(
//                    "Error accepting client connection", e);
//            }
//            new Thread( 
//                new WebServ(
//                webSocket, "Sthelens Road")
//            ).start();      
        }
        System.out.println("Server Stopped.") ;
    }
    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8888", e);
        }
    }
     private void openClientSocket() {
        try {
            this.clientSocket = new ServerSocket(this.clientPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8081", e);
        }    }
}