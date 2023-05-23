package streams.collectors;

/*
 * Example demonstrating Collectors method: groupingBy(classificationFn, mapFactory, downstreamCollector)
 */

import streams.data.Student;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingByExample3 {
    private static LinkedHashMap<String, List<String>> genderStudentNameMap(){
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        LinkedHashMap::new,
                        Collectors.mapping(Student::getName,Collectors.toList()
                        )));
    }
    public static void main(String[] args) {
        System.out.println("Gender Name Map: "+genderStudentNameMap());
    }
}

/*
 * Output:
 * Gender Name Map: {Male=[Aarav, Rohan, Sahil, Rohan, Rishi, Aryan, Aryan, Ved, Varun, Arjun, Karan, Ravi, Raj, Rahul], Female=[Isha, Ishita, Sia, Nisha, Kavya, Anika, Neha, Tanvi, Diya, Prachi, Diya]}
 */