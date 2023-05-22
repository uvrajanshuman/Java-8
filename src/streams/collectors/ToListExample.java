package streams.collectors;

/*
 * Example demonstrating Collectors method: toList
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ToListExample {
    //list of Computer Science students
    private static List<Student> getAllComputerScienceStudents() {
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Student> computerScienceStudents = getAllComputerScienceStudents();
        System.out.println("Computer Science students: ");
        computerScienceStudents.forEach(student -> System.out.println(student.getName()));
    }
}

/*
 * Output:
 * Computer Science students:
 * Aarav
 * Rohan
 * Isha
 * Ishita
 * Sahil
 */
