package ClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {

            while (true) {
                String serverr = in.readLine();
                System.out.println(serverr);
                // Send a request to the server
                String request;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                request = br.readLine();
                out.println(request);
                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);
                System.out.println("AICI");
                if (request.equals("stop") || request.equals("exit"))
                    System.exit(1);
            }
        } catch (
                UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}