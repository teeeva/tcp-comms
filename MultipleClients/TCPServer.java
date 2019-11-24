package tcp.distributed;

public class TCPServer {

    public static void main (String args[]) throws Exception {
                 
        MultiThreadedServer server = new MultiThreadedServer(8888) {
        };
            new Thread(server).start();
        try {
                System.out.println("Server Started"); 
                System.out.println();

        Thread.sleep(200 * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
}
    server.runningThread.checkAccess();
    System.out.println("Stopping Server");
    server.stop();
    }
}
