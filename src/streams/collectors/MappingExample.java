package streams.collectors;

/*
 * Example demonstrating Collectors method: mapping
 */

import streams.data.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MappingExample {
    public static void main(String[] args) {

        Set<String> namesSet = Student.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toSet()));
        /*
         * Equivalent to:
         * Student.getAllStudents().stream()
         *  .map(Student::getName)
         *  .collect(Collectors.toSet());
         */

        List<String> namesList = Student.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toList()));
        /*
         * Equivalent to:
         * Student.getAllStudents().stream()
         *  .map(Student::getName)
         *  .collect(Collectors.toList());
         */

        System.out.println("Names Set: "+namesSet);
        System.out.println("Names List: "+namesList);
    }
}

/*
 * Output:
 * Names Set: [Isha, Rahul, Sahil, Ravi, Aarav, Kavya, Karan, Rishi, Varun, Sia, Nisha, Diya, Rohan, Ishita, Prachi, Ved, Neha, Anika, Tanvi, Raj, Arjun, Aryan]
 * Names List: [Aarav, Rohan, Isha, Ishita, Sahil, Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
 */