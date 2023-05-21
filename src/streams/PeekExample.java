package streams;

/*
 * Example demonstrating Stream method: peek
 * peek method is usually used to debug streams.
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {
    public static void main(String[] args) {
        List<String> computerScienceStudents = Student.getAllStudents().stream()
                .peek(System.out::println) // prints the stream at this position
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .peek(System.out::println) // prints the stream at this position (after filter operation)
                .map(Student::getName)
                .peek(System.out::println) // prints the stream at this position (after map operation)
                .collect(Collectors.toList());
    }
}
