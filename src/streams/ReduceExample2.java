package streams;

import streams.data.Student;

import java.util.Optional;

public class ReduceExample2 {

    private static Optional<Student> getStudentWithHighestGpa(){
        Optional<Student> highestGpaStudent = Student.getAllStudents()
                .stream()
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa())?s1:s2);
        return highestGpaStudent;
    }

    private static Optional<Student> maleStudentWithHighestGPA() {
        Optional<Student> maleHighestGpaStudent = Student.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("male"))
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
        return maleHighestGpaStudent;
    }

    public static void main(String[] args) {
        System.out.println("Highest GPA student: "+getStudentWithHighestGpa().get());
        System.out.println("Male student with GPA: "+maleStudentWithHighestGPA().get());

    }
}
