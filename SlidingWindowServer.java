import java.io.*;
import java.net.*;

public class SlidingWindowServer {
    public static void main(String[] args) {
        int windowSize = 4; // Sliding window size
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            int frameCount = input.readInt(); // Total number of frames
            System.out.println("Total frames to receive: " + frameCount);

            int expectedFrame = 0;
            while (expectedFrame < frameCount) {
                for (int i = 0; i < windowSize && expectedFrame < frameCount; i++) {
                    int frame = input.readInt(); // Receive frame
                    if (frame == expectedFrame) {
                        System.out.println("Frame " + frame + " received.");
                        output.writeInt(expectedFrame); // Acknowledge received frame
                        expectedFrame++;
                    } else {
                        System.out.println("Unexpected frame " + frame + ". Waiting for frame " + expectedFrame);
                        output.writeInt(expectedFrame - 1); // Re-send last acknowledgment
                    }
                }
            }

            System.out.println("All frames received successfully!");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
