class FactorialException extends Exception {
    private int number;

    public FactorialException(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FactorialException: Invalid number for factorial calculation: " + number;
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                int n = Integer.parseInt(arg);
                if (n < 0 || n > 15) {
                    throw new FactorialException(n);
                }
                long factorial = factorial(n);
                System.out.println("Factorial of " + n + " is: " + factorial);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + arg + " is not a valid integer.");
            } catch (FactorialException e) {
                System.out.println(e);
            }
        }
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
