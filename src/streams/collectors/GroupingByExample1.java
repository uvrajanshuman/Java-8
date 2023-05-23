package streams.collectors;

/*
 * Example demonstrating Collectors method: groupingBy(classificationFn)
 */

import streams.data.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample1 {
    //group by gender
    private static Map<String, List<Student>> groupingByGender() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    //group by department
    private static Map<String, List<Student>> groupingByDepartment() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
    }

    private static void printStudents(Map<String, List<Student>> groupedMap){
        // Printing the groups
        groupedMap.forEach((k,v)->{
            List<String> studentNames = v.stream().map(Student::getName).collect(Collectors.toList());
            System.out.println(k+" : "+studentNames);});
    }
    public static void main(String[] args) {
        System.out.println("Grouped by gender: ");
        Map<String, List<Student>> genderGrouped = groupingByGender();
        printStudents(genderGrouped);

        System.out.println();
        System.out.println("Grouped by department: ");
        Map<String,List<Student>> deptGrouped = groupingByDepartment();
        printStudents(deptGrouped);
    }
}

/*
 * Output:
 * Grouped by gender:
 * Female : [Isha, Ishita, Sia, Nisha, Kavya, Anika, Neha, Tanvi, Diya, Prachi, Diya]
 * Male : [Aarav, Rohan, Sahil, Rohan, Rishi, Aryan, Aryan, Ved, Varun, Arjun, Karan, Ravi, Raj, Rahul]
 *
 * Grouped by department:
 * Civil Engineering : [Arjun, Kavya, Karan, Anika]
 * Computer Science : [Aarav, Rohan, Isha, Ishita, Sahil]
 * Electronics and Communication Engineering : [Raj, Rahul, Prachi, Diya]
 * Mechanical Engineering : [Rohan, Sia, Rishi, Aryan, Diya]
 * Information Technology : [Neha, Ravi, Tanvi]
 * Electrical Engineering : [Aryan, Ved, Varun, Nisha]
 */