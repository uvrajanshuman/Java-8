package streams;

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class DistinctAndCountExample {

    private static List<String> getStudentUniqueActivites(){
        return Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private static long getStudentActivitiesCount(){
        long totalActivities = Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        return totalActivities;
    }
    public static void main(String[] args) {
        System.out.println("All unique activities: "+ getStudentUniqueActivites());
        System.out.println("All unique activities count: "+getStudentActivitiesCount());
    }
}
