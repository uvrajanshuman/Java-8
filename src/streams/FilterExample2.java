package streams;

/*
 * Example demonstrating Stream method: filter
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class FilterExample2 {
    //filter all male students
    private static List<Student> getAllMaleStudents() {
        List<Student> maleStudents = Student.getAllStudents().stream()
                .filter(student -> student.getGender().equals("Male"))
                .collect(Collectors.toList());
        return maleStudents;
    }

    //filter all female students
    private static List<Student> getAllFemaleStudents() {
        List<Student> femaleStudents = Student.getAllStudents().stream()
                .filter(student -> student.getGender().equals("Female"))
                .collect(Collectors.toList());

        return femaleStudents;
    }

    //filter all student who participate in coding club or photography club
    public static List<Student> getAllCodingOrPhotographyClubStudents() {
        List<Student> codingOrPhotographyStudents = Student.getAllStudents().stream()
                .filter(student ->
                        student.getActivities().contains("Coding Club")
                                || student.getActivities().contains("Photography")).collect(Collectors.toList());
        return codingOrPhotographyStudents;
    }

    private static String getStudentNames(List<Student> students) {
        String names = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "[", "]"));
        return names;
    }

    public static void main(String[] args) {
        List<Student> maleStudents = getAllMaleStudents();
        List<Student> femaleStudents = getAllFemaleStudents();
        List<Student> codingOrPhotographyStudents = getAllCodingOrPhotographyClubStudents();

        System.out.println("Male Students: "+getStudentNames(maleStudents));
        System.out.println("Female Students: "+getStudentNames(femaleStudents));
        System.out.println("Coding or Photography Students: "+getStudentNames(codingOrPhotographyStudents));
    }
}

/*
 * Output
 * Male Students: [Aarav,Rohan,Sahil,Rohan,Rishi,Aryan,Aryan,Ved,Varun,Arjun,Karan,Ravi,Raj,Rahul]
 * Female Students: [Isha,Ishita,Sia,Nisha,Kavya,Anika,Neha,Tanvi,Diya,Prachi,Diya]
 * Coding or Photography Students: [Aarav,Rohan,Isha,Ishita,Sahil,Rohan,Sia,Aryan,Varun,Arjun,Kavya,Ravi]
 */