package streams;

/*
 * Example demonstrating Stream method: flatMap
 */

import streams.data.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample2 {
    // to collect all the activities of all the students
    private static Set<String> getAllActivities() {
        return Student.getAllStudents() // List<Student>
                .stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println("Student Activities: "+getAllActivities());
    }
}

/*
 * Output:
 * Student Activities: [Photography, Coding Club, Art, Music, Dance, Debate Club, Guitar Club, Robotics Club, Sports]
 */