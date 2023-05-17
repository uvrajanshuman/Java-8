package method_reference_and_constructor_reference;

/*
 * Example demonstrating use of constructor reference
 */

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
public class ConstructorReferenceExample {

    /*
     * maps the`Student get();` method of Supplier<Student> to the no-arg constructor of Student.
     */
    static Supplier<Student> studentSupplier = Student::new;

    /*
     * maps the `Student apply(Integer t, String u);` method of BiFunction<Integer,String,Student>
     * to the two-arg constructor of Student.
     */
    static BiFunction<Integer,String,Student> studentFunction = Student::new;

    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println("===========");
        System.out.println(studentFunction.apply(1, "Anshuman"));
    }
}

/*
 * Output:
 * No args. constructor
 * Student{roll=0, name='null'}
 * ===========
 * Args. constructor
 * Student{roll=1, name='Anshuman'}
 */