package streams.collectors;

import streams.data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {

    private static String joining(List<String> list){
        return list.stream()
                .collect(Collectors.joining());
    }
    private static String joiningWithDelimiter(List<String> list){
        return list.stream()
                .collect(Collectors.joining(","));
    }
    private static String joiningWithDelimiterAndPrefixSuffix(List<String> list){
        return list.stream()
                .collect(Collectors.joining(",","[","]"));
    }
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango","Apple","Watermelon");
        System.out.println("Joining1: "+joining(fruits));
        System.out.println("Joining2: "+joiningWithDelimiter(fruits));
        System.out.println("Joining3: "+joiningWithDelimiterAndPrefixSuffix(fruits));

        List<String> students = Student.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Joining1: "+joining(students));
        System.out.println("Joining2: "+joiningWithDelimiter(students));
        System.out.println("Joining3: "+joiningWithDelimiterAndPrefixSuffix(students));

    }
}
