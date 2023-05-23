package streams.collectors;

/*
 * Example demonstrating Collectors method: groupingBy(classificationFn, downstreamCollector)
 */

import streams.data.Student;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByExample2 {
    //group by gender and then accumulate student in Set
    //1st arg of collect() : defines key to map
    //2nd arg of collect(): defines how values will be accumulated
    private static Map<String, Set<Student>> groupingByGender() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.toSet()));
    }

    //group by department then accumulate data in map in form of name:gender (key,value) pair
    private static Map<String, Map<Integer,String>> deptRollNameMap() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartment,Collectors.toMap(Student::getRollNo,Student::getName)));
    }

    //group by gender then perform count on accumulation of grouped data
    private static Map<String,Long> genderCountMap() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
    }
    public static void main(String[] args) {
        System.out.println("Set of Students grouped by gender: ");
        groupingByGender().forEach(
                (key, value) -> {
                    Set studentNames = value.stream().map(Student::getName).collect(Collectors.toSet());
                    System.out.println(key + " : " + studentNames);
                }
        );
        System.out.println();
        System.out.println("{Department : {Roll : Name}} Map \n"+deptRollNameMap());
        System.out.println();
        System.out.println("Gender Count Map: \n"+genderCountMap());

    }
}

/*
 * Output:
 * Set of Students grouped by gender:
 * Female : [Isha, Prachi, Neha, Anika, Kavya, Tanvi, Sia, Diya, Nisha, Ishita]
 * Male : [Rahul, Sahil, Ved, Ravi, Aarav, Karan, Varun, Rishi, Raj, Arjun, Aryan, Rohan]
 *
 * {Department : {Roll : Name}} Map
 * {Civil Engineering={401=Arjun, 402=Kavya, 403=Karan, 404=Anika}, Computer Science={101=Aarav, 102=Rohan, 103=Isha, 104=Ishita, 105=Sahil}, Electronics and Communication Engineering={601=Raj, 602=Rahul, 603=Prachi, 604=Diya}, Mechanical Engineering={504=Diya, 201=Rohan, 202=Sia, 203=Rishi, 204=Aryan}, Information Technology={501=Neha, 502=Ravi, 503=Tanvi}, Electrical Engineering={304=Nisha, 301=Aryan, 302=Ved, 303=Varun}}
 *
 * Gender Count Map:
 * {Female=11, Male=14}
 */