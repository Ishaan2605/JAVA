interface Exam {
    void percentCall();
}

class Student {
    protected int rollNo;
    protected String name;
    protected double mark1;
    protected double mark2;

    public Student(int rollNo, String name, double mark1, double mark2) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }
}

class Result extends Student implements Exam {
    public Result(int rollNo, String name, double mark1, double mark2) {
        super(rollNo, name, mark1, mark2);
    }

    public void percentCall() {
        double totalMarks = mark1 + mark2;
        double percentage = (totalMarks / 200) * 100;
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
    }
}

public class PART2 {
    public static void main(String[] args) {
        Result studentResult = new Result(101, "John", 85.5, 90.0);
        studentResult.percentCall();
    }
}
