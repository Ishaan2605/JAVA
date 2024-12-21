import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String prn;
    private String name;
    private String dob;
    private double marks;

    public Student(String prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public String getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String toString() {
        return "PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks;
    }
}

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void searchByPRN(String prn) {
        boolean found = false;
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student with name " + name + " not found.");
        }
    }

    public void searchByPosition(int position) {
        if (position < 0 || position >= students.size()) {
            System.out.println("Invalid position.");
            return;
        }
        System.out.println("Student at position " + position + ":");
        System.out.println(students.get(position));
    }

    public void updateStudentMarks(String prn, double marks) {
        boolean found = false;
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                student.setMarks(marks);
                System.out.println("Marks updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }

    public void deleteStudent(String prn) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPrn().equals(prn)) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student Marks");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter PRN: ");
                    String prn = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    management.addStudent(new Student(prn, name, dob, marks));
                    break;
                case 2:
                    management.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter PRN to search: ");
                    prn = scanner.nextLine();
                    management.searchByPRN(prn);
                    break;
                case 4:
                    System.out.print("Enter Name to search: ");
                    name = scanner.nextLine();
                    management.searchByName(name);
                    break;
                case 5:
                    System.out.print("Enter position to search: ");
                    int position = scanner.nextInt();
                    management.searchByPosition(position);
                    break;
                case 6:
                    System.out.print("Enter PRN of student to update marks: ");
                    prn = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    marks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    management.updateStudentMarks(prn, marks);
                    break;
                case 7:
                    System.out.print("Enter PRN of student to delete: ");
                    prn = scanner.nextLine();
                    management.deleteStudent(prn);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
