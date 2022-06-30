package streams.collectors;

import streams.data.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample1 {

    private static Map<String, List<Student>> groupingByGender(){
        Map<String, List<Student>> genderStudentMap = Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        return genderStudentMap;
    }

    private static Map<String,List<Student>> groupingByGradeCategory(){
        Map<String, List<Student>> gradeCategoryStudentMap = Student.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >7.0 ? "Outstanding" : "Average"));
        return gradeCategoryStudentMap;
    }
    public static void main(String[] args) {
        System.out.println("Grouping by Gender: \n"+groupingByGender());
        System.out.println("Grouping by Grade category: \n"+groupingByGradeCategory());
    }
}
