import java.util.Scanner;

class NOMATCHEXCP extends Exception {
    private String input;

    public NOMATCHEXCP(int lineNumber, String input) {
        super("NOMATCHEXCP at line " + lineNumber + ": Input '" + input + "' does not match 'India'");
        this.input = input;
    }
}

public class Part3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        scanner.close();

        try {
            if (!userInput.equals("India")) {
                throw new NOMATCHEXCP(15, userInput); // Assuming line number 15
            } else {
                System.out.println("Input matches 'India'.");
            }
        } catch (NOMATCHEXCP e) {
            System.out.println(e.getMessage());
        }
    }
}
