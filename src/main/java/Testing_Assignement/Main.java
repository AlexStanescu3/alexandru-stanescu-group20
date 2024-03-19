package Testing_Assignement;

import java.util.Scanner;

import static Testing_Assignement.DistanceCalculator.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the expression
        System.out.print("Enter the distance expression: ");
        String expression = scanner.nextLine();

        // Prompt user to specify the output format
        System.out.print("Specify the output format (mm, cm, dm, m, km): ");
        String outputFormat = scanner.nextLine();

        // Calculate the result
        double result = calculate(expression);

        // Convert the result to the specified output format
        result = convertToOutputFormat(result, outputFormat);

        // Output result
        System.out.println("Result: " + result + " " + outputFormat);

        scanner.close();
    }
}