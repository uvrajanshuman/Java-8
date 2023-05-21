package streams;

/*
 * Example demonstrating Stream method: map
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class MapExample2 {
    //get student names
    private static List<String> getStudentNames() {
        List<String> names = Student.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        return names;
    }

    public static void main(String[] args) {
        System.out.println("Student Names: " + getStudentNames());
    }
}

/*
 * Output:
 * Student Names: [Aarav, Rohan, Isha, Ishita, Sahil, Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
 */