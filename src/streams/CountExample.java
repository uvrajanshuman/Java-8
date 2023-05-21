package streams;

/*
 * Example demonstrating Stream method: count
 */
import streams.data.Student;

import java.util.List;

public class CountExample {
    //get activities count
    private static long getActivitiesCount() {
        return Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .count();
    }

    //get computer science students count
    private static long getCseStudentsCount(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .count();
    }

    public static void main(String[] args) {
        System.out.println("Total activities count: "+getActivitiesCount());
        System.out.println("CSE students count: "+getCseStudentsCount());
    }
}
