// FileEncryptionDecryption.java

import java.util.Scanner;
import java.io.*;

public class FileEncryptionDecryption {
    
    // Encryption key
    static final int KEY = 3;

    // Function to encrypt & decrypt file
    public static void main(String[] args) {

        int choice = 0;
        String inputFile = "";

        // Create scanner class object to read input
        try(Scanner sc = new Scanner(System.in))
        {
            // Enter choice
            System.out.print("Choose option (1-Encrypt, 2-Decrypt): ");
            choice = sc.nextInt();
            sc.nextLine();

            // Enter file name
            System.out.print("Enter input file name (with .txt): ");
            inputFile = sc.nextLine();
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }

        // Encrypt & decrypt file
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"))){
                int ch;

                // Perform operation based on user choice
                switch(choice){
                    case 1 -> {
                        while((ch = reader.read()) != -1){
                            writer.write(ch + KEY);
                        }
                        break;
                    }
                    case 2 -> {
                        while((ch = reader.read()) != -1){
                            writer.write(ch - KEY);
                        }
                        break;
                    }
                    default -> System.out.println("Wrong choice, Please select coorect option!");
                }

            System.out.print("Operation completed successfully!");
        } catch(IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
