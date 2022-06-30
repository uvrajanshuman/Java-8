package streams.collectors;

import streams.data.Student;

import java.util.*;
import java.util.stream.Collectors;

public class MinByMaxByExample {

    private static Optional<Student> minByGpa(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    private static Optional<Student> maxByGpa(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    private static List<Student> maxByGpaMultipleStudents(){
        Optional<Student> maxGpaFirstOccurance = Student
                .getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        List<Student> maxGpaStudents = new ArrayList<>();
        if(maxGpaFirstOccurance.isPresent()){
             maxGpaStudents= Student.getAllStudents()
                    .stream()
                    .filter(student -> student.getGpa() == maxGpaFirstOccurance.get().getGpa())
                    .collect(Collectors.toList());
        }
        return maxGpaStudents;
    }

    public static void main(String[] args) {
        System.out.println(minByGpa());
        System.out.println(maxByGpa());
        System.out.println(maxByGpaMultipleStudents());
    }
}
