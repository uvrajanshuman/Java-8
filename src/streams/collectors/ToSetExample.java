package streams.collectors;

/*
 * Example demonstrating Collectors method: toSet
 */

import streams.data.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToSetExample {

    //to retrieve all the available activities among students
    private static Set<String> getAllActivities() {
        return Student.getAllStudents() //List<Student>
                .stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .collect(Collectors.toSet());
    }
    public static void main(String[] args) {
        System.out.println("All available activities: "+getAllActivities());
    }
}

/*
 * Output:
 * All available activities: [Photography, Coding Club, Art, Music, Dance, Debate Club, Guitar Club, Robotics Club, Sports]
 */