package streams;

/*
 * Example demonstrating Stream methods: anyMatch(), allMatch() and noneMatch()
 */

import streams.data.Student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnyMatchAllMatchNoneMatchExample2 {

    // anyMatch
    private static boolean anyMatch(List<Student> students, Predicate<Student> predicate){
        return students.stream()
                .anyMatch(predicate);
    }

    // allMatch
    private static boolean allMatch(List<Student> students, Predicate<Student> predicate){
        return students.stream()
                .allMatch(predicate);
    }

    // noneMatch
    private static boolean noneMatch(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .noneMatch(predicate);
    }

    public static void main(String[] args) {
        List<Student> itStudents = Student.getAllStudents().stream()
                .filter(student -> student.getDepartment().equals("Information Technology"))
                .collect(Collectors.toList());

        List<Student> cseStudents = Student.getAllStudents().stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .collect(Collectors.toList());

        List<Student> civilStudents = Student.getAllStudents().stream()
                .filter(student -> student.getDepartment().equals("Civil Engineering"))
                .collect(Collectors.toList());

        Predicate<Student> codingClub = student -> student.getActivities().contains("Coding Club");

        //to check if any Information Technology student participates in coding club
        System.out.println("Any Information Technology student participates in coding club: "+anyMatch(itStudents,codingClub));
        //to check whether all the computer science student participate in coding club
        System.out.println("All Computer Science students participate in coding club: "+allMatch(cseStudents,codingClub));
        //to check if none of the Civil Engineering student participate in coding club
        System.out.println("None of the Civil Engineering students participate in coding club: "+noneMatch(civilStudents,codingClub));
    }
}

/*
 * Output:
 * Any Information Technology student participates in coding club: true
 * All Computer Science students participate in coding club: true
 * None of the Civil Engineering students participate in coding club: true
 */