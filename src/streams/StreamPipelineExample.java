package streams;

/*
 * Example demonstrating the Stream pipeline
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StreamPipelineExample {
    public static void main(String[] args) {

        List<String> computerScienceStudents = Student.getAllStudents().stream() //Stream<Student>
                .filter(student -> student.getDepartment().equals("Computer Science")) //Stream<Student>
                .map(Student::getName) //Stream<String>
                .collect(Collectors.toList());

        System.out.println("Computer Science students: " + computerScienceStudents);
    }
}

/*
 * Output:
 * Computer Science students: [Aarav, Rohan, Isha, Ishita, Sahil]
 */