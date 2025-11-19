import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(7080);
            System.out.println("Server is waiting for connection...");
            
            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Set up input and output streams
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Read and respond
            String message = reader.readLine();
            System.out.println("Client: " + message);
            writer.println("Hello from Server!");

            // Close resources
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
