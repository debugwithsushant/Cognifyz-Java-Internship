// PasswordStrengthChecker.java

import java.util.Scanner;

public class PasswordStrengthChecker {

    // Function to check password strength
    public static void main(String[] args){
        // Create scanner class object to read input
        try(Scanner sc = new Scanner(System.in)){

            // Enter password
            System.out.print("Enter your password: ");
            String password = sc.nextLine();

            // Decide score
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            // Check each character in the password
            for(int i = 0; i < password.length(); i++){
                char ch = password.charAt(i);

                if(Character.isUpperCase(ch)){
                    hasUpper = true;
                } else if(Character.isLowerCase(ch)){
                    hasLower = true;
                } else if(Character.isDigit(ch)){
                    hasDigit = true;
                } else{
                    hasSpecial = true;
                }
            }

            int score = 0;

            // Calculate score
            if(hasUpper) score++;
            if(hasLower) score++;
            if(hasDigit) score++;
            if(hasSpecial) score++;

            // Check score
            if(password.length() < 6 || score < 2){
                System.out.println("Password strength: Weak");
            } else if(password.length() >= 8 && score == 4){
                System.out.println("Password Strength: Strong");
            } else{
                System.out.println("Password strength: Medium");
            }
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
