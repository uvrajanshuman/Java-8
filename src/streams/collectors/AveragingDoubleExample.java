package streams.collectors;

import streams.data.Student;

import java.util.stream.Collectors;

public class AveragingDoubleExample {
    private static double averageGpa(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.averagingDouble(Student::getGpa));
    }

    public static void main(String[] args) {
        System.out.println("Average GPA of students: "+averageGpa());
    }
}
