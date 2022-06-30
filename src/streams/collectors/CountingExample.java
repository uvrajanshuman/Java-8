package streams.collectors;

import streams.data.Student;

import java.util.stream.Collectors;

public class CountingExample {
    private static long count(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() > 8.0)
                .collect(Collectors.counting());
                // can also be replaced with just .count();
    }

    public static void main(String[] args) {
        System.out.println("No. of student with GPA > 8.0 is : "+count());
    }
}
