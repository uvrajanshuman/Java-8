package streams.collectors;

import streams.data.Student;

import java.util.stream.Collectors;

public class SummingIntExample {
    private static int sumOfRollNo(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getRollNo));
    }

    public static void main(String[] args) {
        System.out.println("Sum of Roll No.: "+sumOfRollNo());
    }
}
