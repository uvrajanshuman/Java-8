package streams;

import streams.data.Student;

import java.util.Optional;

public class FindFirstFindAnyExample {

    // will return first encountered Student which has GPA>9.0
    private static Optional<Student> findAnyStudent(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() > 9.0)
                .findAny();
    }

    // will return the first Student of the stream which has GPA>9.0
    private static Optional<Student> findFirstStudent(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() > 9.0)
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> findAnyStudent = findAnyStudent();
        if(findAnyStudent.isPresent())
            System.out.println("Student: "+findAnyStudent.get());

        Optional<Student> findFirstStudent = findFirstStudent();
        if(findFirstStudent.isPresent())
            System.out.println("Student: "+findFirstStudent.get());
    }
}
