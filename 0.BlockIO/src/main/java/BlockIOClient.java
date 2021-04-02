import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BlockIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        System.out.println("Client start...");

        try (BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter socketOutput = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message;
            while ((message = clientInput.readLine()) != null) {
                if ("\\q".equals(message)) {
                    break;
                }
                socketOutput.println(message);
                System.out.println("Send: " + message);
                System.out.println("Receive: " + socketInput.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        socket.close();
        System.out.println("Client closed.");
    }
}
