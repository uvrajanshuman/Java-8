package streams.data;

import java.util.Arrays;
import java.util.List;

public class Student {
    private int gradeLevel;
    private int rollNo;
    private String name;
    private String gender;
    private double gpa;
    private List<String> activities;

    public Student(int gradeLevel, int rollNo, String name, String gender, double gpa, List<String> activities) {
        this.gradeLevel = gradeLevel;
        this.rollNo = rollNo;
        this.name = name;
        this.gender = gender;
        this.gpa = gpa;
        this.activities = activities;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gradeLevel=" + gradeLevel +
                ", rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", gpa=" + gpa +
                ", activities=" + activities +
                "}\n";
    }

    public static List<Student> getAllStudents(){
        /**
         * 1st grade students
         */
        Student student1 = new Student(1,1,"Anshuman","male",9.0, Arrays.asList("cricket", "basketball","soccer"));
        Student student2 = new Student(1,2,"Dhriti","female", 8.4,Arrays.asList("swimming", "gymnastics","volleyball"));
        Student student3 = new Student(1,3,"Ishani","female", 4.6,Arrays.asList("volleyball", "gymnastics","soccer"));

        /**
         * 2nd grade students
         */
        Student student4 = new Student(2,1,"Yuvraj","male",9.0, Arrays.asList("cricket", "basketball","volleyball"));
        Student student5 = new Student(2,2,"Jenny","female", 6.2,Arrays.asList("swimming", "gymnastics","soccer"));
        /**
         * 3rd grade students
         */
        Student student6 = new Student(3,1,"Emily","female", 9.2,Arrays.asList("swimming", "gymnastics","aerobics"));
        Student student7 = new Student(3,2,"Amay","male", 8.4,Arrays.asList("swimming", "gymnastics","soccer"));
        /**
         * 4th grade students
         */
        Student student8 = new Student(4,1,"Aarohi","female",3.2, Arrays.asList("swimming", "dancing","football"));
        Student student9 = new Student(4,2,"Ujjwal","male", 9.0,Arrays.asList("swimming", "basketball","baseball","football"));

        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6,student7,student8,student9);
        return students;
    }
}
