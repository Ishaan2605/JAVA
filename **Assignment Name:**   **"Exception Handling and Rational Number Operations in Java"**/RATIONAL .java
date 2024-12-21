import java.util.Scanner;

class Rational {
    private int num, den;

    Rational() {
        num = 0;
        den = 1;
    }

    Rational(int n, int d) {
        num = n;
        den = d;
    }

    public void display() {
        System.out.println(num + "/" + den);
    }

    public Rational add(Rational r) {
        Rational temp = new Rational();
        temp.num = num * r.den + den * r.num;
        temp.den = den * r.den;
        return temp;
    }

    public Rational subtract(Rational r) {
        Rational temp = new Rational();
        temp.num = num * r.den - den * r.num;
        temp.den = den * r.den;
        return temp;
    }

    public Rational multiply(Rational r) {
        Rational temp = new Rational();
        temp.num = num * r.num;
        temp.den = den * r.den;
        return temp;
    }

    public Rational divide(Rational r) {
        Rational temp = new Rational();
        if (r.num != 0) { // Check for division by zero
            temp.num = num * r.den;
            temp.den = den * r.num;
        } else {
            System.out.println("Error: Division by zero.");
            temp.num = 0;
            temp.den = 1; // Assigning default values
        }
        return temp;
    }

    public float toFloat() {
        return (float) num / den;
    }

    public int compareTo(Rational r) {
        if (num * r.den > den * r.num)
            return 1;
        else if (num * r.den < den * r.num)
            return -1;
        else
            return 0;
    }

    public int abs() {
        if (num < 0)
            return -num;
        else
            return num;
    }
}

class RationalDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two rational numbers in the form a/b:");
        int n1 = sc.nextInt();
        int d1 = sc.nextInt();
        int n2 = sc.nextInt();
        int d2 = sc.nextInt();

        if (d1 == 0 || d2 == 0) { // Check for division by zero
            System.out.println("Error: Denominator cannot be zero.");
            return;
        }

        Rational r1 = new Rational(n1, d1);
        Rational r2 = new Rational(n2, d2);
        Rational r3 = new Rational();
        System.out.println("The two rational numbers are:");
        r1.display();
        r2.display();
        r3 = r1.add(r2);
        System.out.println("Addition:");
        r3.display();
        r3 = r1.subtract(r2);
        System.out.println("Subtraction:");
        r3.display();
        r3 = r1.multiply(r2);
        System.out.println("Multiplication:");
        r3.display();
        r3 = r1.divide(r2);
        System.out.println("Division:");
        r3.display();
        System.out.println("In floating point:");
        System.out.println(r3.toFloat());
        int comp = r1.compareTo(r2);
        if (comp == 1)
            System.out.println("First rational number is greater");
        else if (comp == -1)
            System.out.println("Second rational number is greater");
        else
            System.out.println("Both rational numbers are equal");
        System.out.println("Absolute value of the first rational number:");
        System.out.println(r1.abs());
    }
}
