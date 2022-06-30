package streams.collectors;

import streams.data.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MappingExample {
    public static void main(String[] args) {
        Set<String> namesSet = Student.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));

        List<String> namesList = Student.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toList()));

        System.out.println("Names Set: "+namesSet);
        System.out.println("Names List: "+namesList);
    }
}
