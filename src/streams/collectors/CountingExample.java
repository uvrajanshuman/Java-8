package streams.collectors;

/*
 * Example demonstrating Collectors method: joining and its overloaded versions
 */

import streams.data.Student;

import java.util.stream.Collectors;

public class CountingExample {
    //to get count of Computer Science students
    private static long countCseStudents(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .collect(Collectors.counting());
                // can also be replaced with just .count
    }
    public static void main(String[] args) {
        System.out.println("No. of CSE students: "+countCseStudents());
    }
}

/*
 * Output:
 * No. of CSE students: 5
 */