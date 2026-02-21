// ChatSever.java

import java.io.*;
import java.net.*;

public class ChatServer{

    // Server implementation
    public static void main(String[] args){
        // Assign port
        int port = 5000;

        // Client connection
        try (ServerSocket server = new ServerSocket(port)){
            // Wait for client
            System.out.println("Server started. Waiting for client...");
            try(Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){

            System.out.println("Client connected!");

            String clientMessage, serverMessage;

            // Chat loop
            while(true){
                // Client message
                clientMessage = in.readLine();

                // Check for exit command
                if(clientMessage == null ||clientMessage.equalsIgnoreCase("exit")){
                    System.out.println("Client disconnected.");
                    break;
                }

                // Display client message
                System.out.println("Client: " + clientMessage);

                // Server response
                System.out.print("Server: ");
                serverMessage = console.readLine();
                out.println(serverMessage);

                // Check for exit command
                if(serverMessage == null || serverMessage.equalsIgnoreCase("exit")){
                    System.out.println("Server closed the chat.");
                    break;
                }
            }
        }
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}