package streams;

/*
 * Example demonstrating Stream method: sorted(Comparator<? super T> comparator)
 */

import streams.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    //sort all students by name
    private static List<Student> sortStudentsByName() {
        return Student.getAllStudents()
                .stream()
//                .sorted((student1, student2) -> student1.getName().compareTo(student2.getName()))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    private static String getStudentNames(List<Student> students){
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",","[","]"));
    }

    public static void main(String[] args) {
        List<Student> studentsSortedByName = sortStudentsByName();
        System.out.println("Students sorted by name: "+getStudentNames(studentsSortedByName));
    }
}

/*
 * Output:
 * Students sorted by name: [Aarav,Anika,Arjun,Aryan,Aryan,Diya,Diya,Isha,Ishita,Karan,Kavya,Neha,Nisha,Prachi,Rahul,Raj,Ravi,Rishi,Rohan,Rohan,Sahil,Sia,Tanvi,Varun,Ved]
 */
