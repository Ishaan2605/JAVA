import java.text.DecimalFormat;

abstract class Employee {
    private String name;
    private int hoursWorked;
    private double hourlyRate;

    public Employee(String name, int hoursWorked, double hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public abstract double calculateSalary();

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

class NormalEmployee extends Employee {
    public NormalEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    @Override
    public double calculateSalary() {
        return getHoursWorked() * getHourlyRate();
    }
}

class BonusEmployee extends Employee {
    private double bonusPercentage;

    public BonusEmployee(String name, int hoursWorked, double hourlyRate, double bonusPercentage) {
        super(name, hoursWorked, hourlyRate);
        this.bonusPercentage = bonusPercentage;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() {
        double baseSalary = getHoursWorked() * getHourlyRate();
        return baseSalary + (baseSalary * (bonusPercentage / 100));
    }
}

public class Main2 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        NormalEmployee normalEmployee = new NormalEmployee("John", 40, 15);
        System.out.println("Normal Employee Salary: ₹" + df.format(normalEmployee.calculateSalary()));

        BonusEmployee bonusEmployee = new BonusEmployee("Alice", 40, 20, 10);
        System.out.println("Bonus Employee Salary: ₹" + df.format(bonusEmployee.calculateSalary()));
    }
}
