package streams.collectors;

import streams.data.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitioningByExample {

    private static Predicate<Student> gradePredicate = student -> student.getGpa()>8.0;

    private static Map<Boolean, List<Student>> oneArgPartitioningBy(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gradePredicate));
    }

    private static Map<Boolean, List<String>> twoArgPartitioningBy(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(
                            gradePredicate,
                            Collectors.mapping(Student::getName,Collectors.toList()
                            )));
    }

    public static void main(String[] args) {
        System.out.println("PartitionByGrade: "+oneArgPartitioningBy());
        System.out.println("PartitinByGrade StudentName Map:"+twoArgPartitioningBy());
    }
}
