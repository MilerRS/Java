package ServerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader fin = null; //client -> server stream
        String request = null;
        String response = null;
        PrintWriter fout = null;
        try {
            fin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fout = new PrintWriter(socket.getOutputStream()); //server -> client stream

            while (true) {
                fout.println("10 seconds to send message");
                fout.flush();
                request = fin.readLine();
                if (request.equals("exit")) {
                    response = "Client connection stoped";
                    fout.println(response);
                    fout.flush();
                    break;
                }
                if (request.equals("stop")) {
                    response = "Server stopped";
                    GameServer.ok = false;
                    fout.println(response);
                    fout.flush();
                    break;
                }
                response = "Server received the request ... " + request;
                fout.println(response);
                fout.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}