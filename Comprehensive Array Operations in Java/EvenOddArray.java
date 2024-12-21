import java.util.Scanner;

public class EvenOddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Declare arrays for even and odd numbers
        int[] even = new int[size];
        int[] odd = new int[size];

        int evenCount = 0; // Counter for even numbers
        int oddCount = 0; // Counter for odd numbers

        // Accept numbers from the user and move them to respective arrays
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int num = scanner.nextInt();

            if (num % 2 == 0) {
                even[evenCount] = num;
                evenCount++;
            } else {
                odd[oddCount] = num;
                oddCount++;
            }
        }

        // Print even numbers
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(even[i] + " ");
        }
        System.out.println();

        // Print odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(odd[i] + " ");
        }
        System.out.println();

        scanner.close(); // Close the scanner
    }
}
