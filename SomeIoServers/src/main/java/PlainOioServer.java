import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {
    public void server(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            for (; ; ) {
                final Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket);
                new Thread(() -> {
                    OutputStream os;
                    try {
                        os = socket.getOutputStream();
                        os.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        os.flush();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                        }
                    }
                }
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
