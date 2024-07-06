import java.io.*;
import java.net.*;

public class AreaServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(65432)) {
            System.out.println("Server is listening on port 65432");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    String[] dimensions = reader.readLine().split(",");
                    double length = Double.parseDouble(dimensions[0]);
                    double width = Double.parseDouble(dimensions[1]);

                    double area = length * width;

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println(area);
                } catch (IOException ex) {
                    System.out.println("Server exception: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
