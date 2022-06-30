package streams;

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    //filter all male students
    public static List<Student> getAllMaleStudents(){

        List<Student> maleStudents = Student.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("male"))
                .collect(Collectors.toList());
        return maleStudents;
    }

    //filter all female students
    public static List<Student> getAllFemaleStudents(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("female"))
                .collect(Collectors.toList());
    }

    //filter all students who play cricket
    public static List<Student> getAllCricketPlayers(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getActivities().contains("cricket"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Male Students: "+getAllMaleStudents());
        System.out.println("Female Students: "+getAllFemaleStudents());
        System.out.println("Cricket Players: "+getAllCricketPlayers());
    }
}
