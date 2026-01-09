// TemperatureConverter.java

import java.util.Scanner;

public class TemperatureConverter{

    // Temperature Convertor
    public static void main(String[] args){
        // Create a Scanner object to read input
        try(Scanner sc = new Scanner(System.in)){

            //Input temperature
            System.out.print("Enter temperature value: ");
            double temperature = sc.nextDouble();

            //Input temperature unit
            System.out.print("Enter temperature unit (C for Celsius, F for Fahrenheit): ");
            char unit = sc.next().toUpperCase().charAt(0);

            // Convert temperature based on the unit
            switch (unit) {
                case 'C'->
                    System.out.printf("%.2f Celsius is %.2f Fahrenheit%n", temperature, celsiusToFahrenheit(temperature));
                case 'F'->
                    System.out.printf("%.2f Fahrenheit is %.2f Celsius%n", temperature, fahrenheitToCelsius(temperature));
                default ->
                    System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
            }
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    // Function to convert Celsius to Fahrenheit
    static double celsiusToFahrenheit(double celsius){
        return (celsius * 9/5) + 32;
    }

    // Function to convert Fahrenheit to Celsius
    static double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) * 5/9;
    }
}