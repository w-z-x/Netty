import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server start...");

        Socket socket;
        while ((socket = serverSocket.accept()) != null) {
            System.out.println("Client connected...");
            try (BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true)) {
                String request;
                while ((request = socketIn.readLine()) != null) {
                    System.out.println("Receive: " + request);
                    String response = request.toUpperCase();
                    socketOut.println(response);
                    System.out.println("Send: " + response);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            socket.close();
            System.out.println("Client disconnected.");
        }

        serverSocket.close();
        System.out.println("Server closed.");
    }
}
