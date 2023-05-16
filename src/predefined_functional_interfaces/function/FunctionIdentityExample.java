package predefined_functional_interfaces.function;

/*
 *  Example demonstrating identity() method of Function.
 *  It returns a Function that always returns it's input arguments.
 */

import java.util.function.Function;

public class FunctionIdentityExample {
    public static void main(String[] args) {
        Function<String,String> f1= Function.identity();
        String s2 = f1.apply("Anshuman");
        System.out.println(s2); //Anshuman
    }
}

/*
 * Output:
 * Anshuman
 */