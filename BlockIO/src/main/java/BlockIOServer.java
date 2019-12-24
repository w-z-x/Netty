import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockIOServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 8080;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket socket = serverSocket.accept();


        String request, response;
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
        while ((request = socketIn.readLine()) != null) {
            if ("Over".equals(request)) {
                break;
            }
            response = processRequest(request);
            socketOut.println(response);
        }

        socketIn.close();
        socketOut.close();
        socket.close();
        serverSocket.close();
    }

    private static String processRequest(String request) {
        System.out.println("Received: " + request);
        return "Hello, " + request;
    }
}
