package method_reference_and_constructor_reference;

import java.util.function.BiFunction;
import java.util.function.Supplier;

class Student{
    private int roll;
    private String name;

    Student(){
        System.out.println("No args. constructor");
    }

    Student(int roll, String name){
        this.roll = roll;
        this.name = name;
        System.out.println("Args. constructor");
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Example4 {
    static Supplier<Student> studentSupplier = Student::new;
    static BiFunction<Integer,String,Student> studentFunction = Student::new;
    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply(1, "Anshuman"));
    }
}
