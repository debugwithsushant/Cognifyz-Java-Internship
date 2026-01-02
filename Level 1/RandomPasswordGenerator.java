// RandomPasswordGenerator.Java

import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {
    
    // Function to generate random password
    public static void main(String[] args) {
        // Create scanner object to read input
        try(Scanner sc = new Scanner(System.in)){
            // Create random object to get random number
            Random random = new Random();

            // Set password length
            System.out.print("Enter password length: ");
            int length = sc.nextInt();

            // Select character types
            System.out.print("Include uppercase letters? (Y/N): ");
            boolean useUpper = sc.next().equalsIgnoreCase("Y");

            System.out.print("Include lowercase letters? (Y/N): ");
            boolean useLower = sc.next().equalsIgnoreCase("Y");

            System.out.print("Include numbers? (Y/N): ");
            boolean useNumber = sc.next().equalsIgnoreCase("Y");

            System.out.print("Include special characters? (Y/N): ");
            boolean useSpecial = sc.next().equalsIgnoreCase("Y");

            // Define character sets
            String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lower = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String special = "@#$&";

            String characters = "";

            // Build character set based on user choice
            if(useUpper) characters += upper;
            if(useLower) characters += lower;
            if(useNumber) characters += numbers;
            if(useSpecial) characters += special;

            // Check if at least one character type is selected           
            if(characters.isEmpty()){
                throw new Exception("No character types selected");
            }

            // Generate password
            String password = "";

            // Create password of given length
            for(int i = 0; i < length; i++){
                int index = random.nextInt(characters.length());
                password += characters.charAt(index);
            }

            // Display password
            System.out.println("Generated Password: " + password);
        } catch(Exception ex){
            System.out.println("At least one character type must be selected!");
        }
    }
}
