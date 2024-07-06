import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AreaClient {

    public static void main(String[] args) {
        

        try (Socket socket = new Socket("localhost", 65432)) {

            // Get dimensions from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter the width: ");
            double width = scanner.nextDouble();

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println(length + "," + width);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String area = reader.readLine();
            System.out.println("Area of the rectangle: " + area);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
