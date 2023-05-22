package streams;

/*
 * Example demonstrating Stream methods: findFirst, findAny
 */


import streams.data.Student;

import java.util.Optional;

public class FindFirstFindAnyExample {
    // will return first encountered Student with activity as Robotics Club
    private static Optional<Student> findAny(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getActivities().contains("Robotics Club"))
                .findAny();
    }

    // will return first encountered Student with activity as Robotics Club
    private static Optional<Student> findFirst(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getActivities().contains("Robotics Club"))
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> findFirstResult = findFirst();
        findFirstResult.ifPresent(student -> System.out.println("Find First: "+student.getName()));

        Optional<Student> findAnyResult = findAny();
        findAnyResult.ifPresent(student -> System.out.println("Find Any: "+student.getName()));
    }
}

/*
 * Output:
 * Find First: Rishi
 * Find Any: Rishi
 */