package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BlockIOClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8080;
        Socket socket = new Socket(host, port);

        String message;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((message = systemIn.readLine()) != null) {
            if ("Quit".equals(message)) {
                break;
            }
            socketOut.println(message);
            System.out.println("From Server: " + socketIn.readLine());
        }

        systemIn.close();
        socketOut.close();
        socketIn.close();
        socket.close();
    }
}
