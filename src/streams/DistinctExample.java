package streams;

/*
 * Example demonstrating Stream method: distinct
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {

    //get a list all the unique/distinct activities
    private static List<String> getAllDistinctActivities() {
        return Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Student activities: "+getAllDistinctActivities());
    }
}

/*
 * Output:
 * Student activities: [Sports, Coding Club, Music, Photography, Art, Dance, Debate Club, Robotics Club, Guitar Club]
 */