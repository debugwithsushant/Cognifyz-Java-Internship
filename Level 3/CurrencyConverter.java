// CurrencyConverter.java

import java.util.Scanner;

public class CurrencyConverter{

    public static void main(String[] args){

        // Create Scanner object for user input
        try(Scanner sc = new Scanner(System.in)){

            // Enter amount to convert
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            // Enter base currency
            System.out.print("Enter base currency (e.g., USD): ");
            String base = sc.nextLine().toUpperCase();

            // Enter target currency
            System.out.print("Enter target currency (e.g., INR): ");
            String target = sc.nextLine().toUpperCase();

            double rate = 83.29;
            double converted = amount * rate;

            System.out.printf("%.2f %s = %.2f %s%n", amount, base, converted, target);
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}