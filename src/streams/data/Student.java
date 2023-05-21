package streams.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private String gender;
    private String department;
    private int rollNo;
    private List<String> activities;

    public Student(String name, String gender, String department, int rollNo, List<String> activities) {
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.rollNo = rollNo;
        this.activities = activities;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", rollNo=" + rollNo +
                ", activiteis=" + activities +
                '}';
    }

    public static List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        // Computer Science students
        students.add(new Student("Aarav", "Male", "Computer Science", 101, Arrays.asList("Sports", "Coding Club")));
        students.add(new Student("Rohan", "Male", "Computer Science", 102, Arrays.asList("Music", "Coding Club")));
        students.add(new Student("Isha", "Female", "Computer Science", 103, Arrays.asList("Sports", "Coding Club")));
        students.add(new Student("Ishita", "Female", "Computer Science", 104, Arrays.asList("Photography", "Coding Club")));
        students.add(new Student("Sahil", "Male", "Computer Science", 105, Arrays.asList("Art", "Coding Club")));

        // Mechanical Engineering students
        students.add(new Student("Rohan", "Male", "Mechanical Engineering", 201, Arrays.asList("Dance", "Photography")));
        students.add(new Student("Sia", "Female", "Mechanical Engineering", 202, Arrays.asList("Photography", "Debate Club")));
        students.add(new Student("Rishi", "Male", "Mechanical Engineering", 203, Arrays.asList("Dance", "Robotics Club")));
        students.add(new Student("Aryan", "Male", "Mechanical Engineering", 203, Arrays.asList("Guitar Club", "Photography")));

        // Electrical Engineering Students
        students.add(new Student("Aryan", "Male", "Electrical Engineering", 301, Arrays.asList("Music", "Robotics Club")));
        students.add(new Student("Ved", "Male", "Electrical Engineering", 302, Arrays.asList("Music", "Robotics Club")));
        students.add(new Student("Varun", "Male", "Electrical Engineering", 303, Arrays.asList("Photography", "Debate Club")));
        students.add(new Student("Nisha", "Female", "Electrical Engineering", 304, Arrays.asList("Music", "Debate Club")));

        // Civil Engineering Students
        students.add(new Student("Arjun", "Male", "Civil Engineering", 401, Arrays.asList("Photography", "Guitar Club")));
        students.add(new Student("Kavya", "Female", "Civil Engineering", 402, Arrays.asList("Photography", "Photography")));
        students.add(new Student("Karan", "Male", "Civil Engineering", 403, Arrays.asList("Sports", "Robotics Club")));
        students.add(new Student("Anika", "Female", "Civil Engineering", 404, Arrays.asList("Sports", "Guitar Club")));

        // Information Technology Students
        students.add(new Student("Neha", "Female", "Information Technology", 501, Arrays.asList("Music", "Art")));
        students.add(new Student("Ravi", "Male", "Information Technology",502, Arrays.asList("Coding Club", "Guitar Club")));
        students.add(new Student("Tanvi", "Female", "Information Technology", 503, Arrays.asList("Dance", "Robotics Club")));
        students.add(new Student("Diya", "Female", "Mechanical Engineering", 504, Arrays.asList("Robotics Club", "Debate Club")));


        // Electronics and Communication Engineering students
        students.add(new Student("Raj", "Male", "Electronics and Communication Engineering", 601, Arrays.asList("Sports", "Guitar Club")));
        students.add(new Student("Rahul", "Male", "Electronics and Communication Engineering", 602, Arrays.asList("Sports", "Music")));
        students.add(new Student("Prachi", "Female", "Electronics and Communication Engineering", 603, Arrays.asList("Dance", "Debate Club")));
        students.add(new Student("Diya", "Female", "Electronics and Communication Engineering", 604, Arrays.asList("Robotics Club", "Debate Club")));


        return students;
    }
}
