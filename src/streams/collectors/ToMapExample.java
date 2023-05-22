package streams.collectors;

/*
 * Example demonstrating Collectors method: toMap
 */

import streams.data.Student;

import java.util.Map;
import java.util.stream.Collectors;

public class ToMapExample {

    //get student roll and name map
    private static Map<Integer, String> getStudentRollNamesMap() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.toMap(Student::getRollNo,Student::getName));
    }
    public static void main(String[] args) {
        System.out.println("Student Roll and Name: "+getStudentRollNamesMap());
    }
}

/*
 * Output:
 * Student Roll and Name: {201=Rohan, 202=Sia, 203=Rishi, 204=Aryan, 401=Arjun, 402=Kavya, 403=Karan, 404=Anika, 601=Raj, 602=Rahul, 603=Prachi, 604=Diya, 101=Aarav, 102=Rohan, 103=Isha, 104=Ishita, 105=Sahil, 301=Aryan, 302=Ved, 303=Varun, 304=Nisha, 501=Neha, 502=Ravi, 503=Tanvi, 504=Diya}
 */