package streams;

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    // to collect all the activities of all the students into a list

    private static List<String> getAllActivities(){
        return Student.getAllStudents() // List<Student>
                .stream()// Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>>
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Student Activities: "+getAllActivities());
    }
}
