import java.io.*;
import java.net.*;

public class StopAndWaitServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server is ready...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String receivedMessage = in.readLine();
            if (receivedMessage == null || receivedMessage.equalsIgnoreCase("exit")) {
                System.out.println("Client disconnected.");
                break;
            }
            System.out.println("Received: " + receivedMessage);

            try {
                Thread.sleep(1000); // Simulating processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            out.println("ACK: " + receivedMessage);
            System.out.println("Acknowledgment sent.");
        }

        socket.close();
        serverSocket.close();
    }
}
