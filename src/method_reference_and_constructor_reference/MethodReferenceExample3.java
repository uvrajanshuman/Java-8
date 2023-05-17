package method_reference_and_constructor_reference;

/*
 * Example demonstrating use of method reference
 */

import java.util.function.Function;

public class MethodReferenceExample3 {
    //using lambda expression
    static Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase();

    //using methodReference
    static Function<String,String> toUpperCaseMethodRefernce = String::toUpperCase;

    public static void main(String[] args) {

        System.out.println(toUpperCaseLambda.apply("java8"));   // JAVA8

        System.out.println(toUpperCaseMethodRefernce.apply("java8"));   // JAVA8

    }
}

/*
 * Output:
 * JAVA8
 * JAVA8
 */