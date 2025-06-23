import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        System.out.println("\n===== Basic Calculator =====");
        
        do {

            double num1 = getValidNum(scanner, "Input the first number: ");
            char operator = getValidOperator(scanner);
            double num2 = getValidNum(scanner, "Enter the second number: ");

            if (operator == '/' && num2 == 0) {
                System.out.println("Error: Cannot divide by zero.");
            }
             else {
                double result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);
            }

            System.out.print("Would you like to perform another calculation?  ");
            choice = scanner.next().trim().toLowerCase().charAt(0);

        } while (choice == 'y');

        System.out.println("Thank you for using the calculator.");
        scanner.close();
    }

    public static double getValidNum(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
                scanner.next(); // clear the invalid input
            }
        }
    }

    public static char getValidOperator(Scanner scanner) {
        while (true) {
            System.out.print("Enter operator (+, -, *, /): ");
            String input = scanner.next().trim();

            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                return input.charAt(0);
            }

            System.out.println("Invalid operator. Please enter one of +, -, *, /.");
        }
    }

    public static double calculate(double num1, double num2, char op) {
        switch (op) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return 0;
        }
    }
}

