package streams;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import streams.data.Student;

public class MapExample {

    private static List<String> getStudentsNamesUpperCase(){
        return Student.getAllStudents() //List<Student>
                .stream() //Stream<Student>
                //student -> student.getName()
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String>
                .collect(Collectors.toList()); // List<String>
    }

    private static List<Student> capitalizeStudentNames(){
        return Student.getAllStudents() // List<Student>
                .stream() // Stream<Student>
                .map(student -> {
                    student.setName(student.getName().toUpperCase());
                    return student;
                }) // Stream<Student>
                .collect(Collectors.toList()); // List<Student>
        /*
        `* Such type of operations should be done using peek()
         * .peek(student -> student.setName(student.getName().toUpperCase()))
         */
    }

    //TODO: move to Collectors Example
    private static Map<String, List> getNameActivityMap(){
        Map<String,List> nameActivityMap = Student.getAllStudents()
                .stream()
                .collect(Collectors.toMap(Student::getName,Student::getActivities));
        return nameActivityMap;
    }

    public static void main(String[] args) {
        System.out.println("Names UpperCase List: "+getStudentsNamesUpperCase());
//        System.out.println("Names and Activity Map: "+getNameActivityMap());
        System.out.println("Transformed students: "+capitalizeStudentNames());
    }
}
