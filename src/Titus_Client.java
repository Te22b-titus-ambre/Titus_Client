import java.io.*;
import java.net.*;

public class Titus_Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (
                Socket socket = new Socket(host, port);
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.print("Skriv ett additionstal (t.ex. 4+7): ");
            String input = consoleInput.readLine();

            out.println(input);

            String response = in.readLine();
            System.out.println("Svar från servern: " + response);

        } catch (UnknownHostException e) {
            System.out.println("Fel: Kan inte hitta servern på adressen " + host);
        } catch (IOException e) {
            System.out.println("Fel: Kunde inte ansluta till servern eller skicka/ta emot data.");
        }
    }
}
