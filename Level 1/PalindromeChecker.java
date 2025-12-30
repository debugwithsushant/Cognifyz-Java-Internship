// PalindromeChecker.java

import java.util.Scanner;

public class PalindromeChecker{

    // Function to check if a string is a palindrome
    public static void main(String[] args){
        // Create scanner object to read input
        try(Scanner sc = new Scanner(System.in)){

            // Input string
            System.out.print("Enter a string: ");
            String str = sc.nextLine();
                
            // Remove spaces and convert to lowercase
            String cleanedStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

            // Reverse string
            String reversedStr = new StringBuilder(cleanedStr).reverse().toString();

            // Check string is palindrome
            checkPalindrome(str, cleanedStr, reversedStr);
        
        } catch(Exception ex){
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }

    // Check string is palindrome
    static void checkPalindrome(String str, String cleanedStr, String reversedStr){
    if(cleanedStr.equals(reversedStr)){
        System.out.println(str + " is a palindrome.");
        } else {
        System.out.println(str + " is not a palindrome.");
        }
    }
}