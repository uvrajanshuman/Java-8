package streams;

import streams.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

    private static List<Student> sortStudentsByName(){
        return Student.getAllStudents()
                .stream()
            //  .sorted((student1,student2)->student1.getName().compareTo(student2.getName()))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    private static List<Student> sortStudentsByGpa(){
        return Student.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    private static List<Student> sortStudentsByGpaDesc(){
        return Student.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Students sorted by name: ");
        sortStudentsByName().forEach(System.out::println);
        System.out.println("Students sorted by GPA: ");
        sortStudentsByGpa().forEach(System.out::println);
        System.out.println("Students sorted by GPA in descending order:");
        sortStudentsByGpaDesc().forEach(System.out::println);

    }
}
