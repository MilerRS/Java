package ServerApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public static boolean ok=true;
    public GameServer() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
                Thread.sleep(10000);
                if(!ok)
                    serverSocket.close();
            }
        } catch (IOException | InterruptedException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
}
