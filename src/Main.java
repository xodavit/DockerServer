import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (
                final var serverSocket = new ServerSocket(9999)
        ) {
            while (true) {
                try (
                        final var socket = serverSocket.accept(); // пришёл клиент
                        final var out = socket.getOutputStream()
                ) {
                    final var message = "Hello world";

                    out.write((
                            "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/plain\r\n" +
                                    "Content-Length: " + message.length() + "\r\n" +
                                    "Connection: close\r\n" +
                                    "\r\n" +
                                    message
                    ).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}