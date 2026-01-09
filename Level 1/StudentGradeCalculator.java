// StudentGradeCalculator.java

import java.util.Scanner;

public class StudentGradeCalculator {
    
    // Function to calculate grade
    public static void main(String[] args) {
        // Create scanner object to read input
        try(Scanner sc = new Scanner(System.in)){
            // Input number of subjects
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            // Store subject marks
            double[] marks = new double[n];
            double sum = 0;

            for(int i = 0; i < n; i++){
                System.out.print("Enter mark of " + (i+1) + " subject: ");
                marks[i] = sc.nextDouble();
                sum += marks[i];
            }

            // Calculate average grade
            double avg = sum / n;

            // Display average grade
            System.out.println("Average grade: " + avg);
        } catch(Exception ex){
            System.out.println("Enter valid marks or subject count!");
        }
    }
}
