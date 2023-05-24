package streams.collectors;

/*
 * Example demonstrating Collectors method: partitionBy(predicate), partitionBy(predicate, downstreamCollector)
 */

import streams.data.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitionByExample {

    private static Predicate<Student> csePredicate = student -> student.getDepartment().equals("Computer Science");

    private static Map<Boolean, List<Student>> oneArgPartitioningBy() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(csePredicate));
    }

    private static Map<Boolean, List<String>> twoArgPartitioningBy() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(
                        csePredicate,
                        Collectors.mapping(Student::getName, Collectors.toList()
                        )));
    }

    public static void main(String[] args) {
        System.out.println("PartitionByGrade: ");
        oneArgPartitioningBy().forEach(
                (key, value) -> {
                    List<String> studentNames = value.stream().map(Student::getName).collect(Collectors.toList());
                    System.out.println(key + " : " + studentNames);
                }
        );
        System.out.println();
        System.out.println("PartitionByGrade StudentName Map:");
        twoArgPartitioningBy().forEach((key, value) -> {System.out.println(key+" : "+value);});
    }
}

/*
 * Output:
 * PartitionByGrade:
 * false : [Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
 * true : [Aarav, Rohan, Isha, Ishita, Sahil]
 *
 * PartitionByGrade StudentName Map:
 * false : [Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
 * true : [Aarav, Rohan, Isha, Ishita, Sahil]
 */