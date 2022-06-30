package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks(){
        return marks;
    }
}

public class StreamPipelineExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Anshuman",90),
                new Student("Yuvraj",98),
                new Student("Amay",85),
                new Student("Saurabh",55),
                new Student("Ankit",29),
                new Student("Archit",20),
                new Student("Aditya",30)
        );

        List<String> passStudents = students.stream()  //Stream<Student>
                .filter(student -> student.getMarks() >= 30) //Stream<Student>
                .map(Student::getName) // Stream<String>
                .collect(Collectors.toList()); // List<String>

        System.out.println("Pass Students: "+passStudents);
    }
}
