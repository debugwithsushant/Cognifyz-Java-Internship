// ChatClient.java

import java.io.*;
import java.net.*;

public class ChatClient{

    // Client implementation
    public static void main(String[] args){
        // Assign port and host
        String host = "localhost";
        int port = 5000;

        // Client connection
        try(Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){

            String clientMessage, serverMessage;

            // Chat loop
            while(true){
                // Client message
                System.out.print("Client: ");
                clientMessage = console.readLine();
                out.println(clientMessage);

                // Check for exit command
                if(clientMessage == null || clientMessage.equalsIgnoreCase("exit")){
                    System.out.println("Client closed the chat.");
                    break;
                }

                // Server response
                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);

                // Check for exit command
                if(serverMessage == null || serverMessage.equalsIgnoreCase("exit")){
                    System.out.println("Server close chat.");
                    break;
                }
            } 
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}