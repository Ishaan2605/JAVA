import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Factorial Calculator Menu:");
            System.out.println("1. Calculate Factorial");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to calculate its factorial: ");
                    int number = scanner.nextInt();
                    int factorial = calculateFactorial(number);
                    System.out.println("Factorial of " + number + " is: " + factorial);
                    break;
                case 2:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 to calculate factorial or 2 to exit.");
                    break;
            }
        } while (choice != 2);

        scanner.close();
    }

    public static int calculateFactorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * calculateFactorial(n - 1);
    }
}
