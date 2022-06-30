package streams.collectors;

import streams.data.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByExample2 {

    private static Map<String, Set<Student>> groupingByGender(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.toSet()));
    }


    private static Map<String, List<String>> genderNameMap(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.mapping(Student::getName,Collectors.toList())));
    }

    private static Map<String, Long> genderCountMap(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
    }

    private static Map<String, Long> customGpaLevelStudentCount(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        student -> student.getGpa() >7.0 ? "Outstanding" : "Average",
                        Collectors.counting()
                ));
    }

    public static void main(String[] args) {
        System.out.println("Set of Students grouped by gender: "+groupingByGender());
        System.out.println("Gender Name Map: "+genderNameMap());
        System.out.println("Gender Count Map: "+genderNameMap());
        System.out.println("Gender Count Map: "+genderCountMap());
        System.out.println("GPA student count map: "+customGpaLevelStudentCount());
    }
}
