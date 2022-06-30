package streams;

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {
    private static List<Student> capitalizeStudentNames(){
        return Student.getAllStudents()
                .stream()
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println("Transformed student data: \n"+capitalizeStudentNames());
    }
}
