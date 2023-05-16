package predefined_functional_interfaces.consumer;

/*
 *  Example demonstrating Consumer chaining
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAndConsumerChainingExample {
    //Consumer(s) for printing student name, marks and grade
    static Consumer<Student> printName = s -> System.out.printf("Name: \"%s\" ", s.getName());
    static Consumer<Student> printMarks = s -> System.out.printf("Total Marks: \"%s\" ", s.getMarks());
    static Consumer<Student> printGrade = s -> System.out.printf("Grade: \"%s\" \n", s.getGrade());

    //consumer chaining: andThen()
    static Consumer<Student> printNameMarksGrade = printName.andThen(printMarks).andThen(printGrade);
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student(1, "Anshuman", 98, "A+"),
                new Student(2, "Yuvraj", 84, "B"),
                new Student(3, "Ram", 78, "C"));

        for(Student s: studentList) {
            printNameMarksGrade.accept(s);
        }
    }
}

class Student{
    int roll;
    String name;
    double marks;
    String grade;

    public Student(int roll, String name, double marks, String grade) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

/*
 * Output:
 * Name: "Anshuman" Total Marks: "98.0" Grade: "A+"
 * Name: "Yuvraj" Total Marks: "84.0" Grade: "B"
 * Name: "Ram" Total Marks: "78.0" Grade: "C"
 */