package predefined_functional_interfaces.function;

/*
 *  Example demonstrating use of Function.
 */

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer,Double> complexFormula = i -> Math.sqrt(i*100);
        System.out.println(complexFormula.apply(20));

        System.out.println("==============");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Function<String, String> greet = s -> "Hello: " + s.toUpperCase();
        String []names = {"Anshuman", "Yuvraj", "Amay", "Ram"};
        for(String name: names){
            if(startsWithA.test(name)){
                System.out.println(greet.apply(name));
            }
        }

        System.out.println("==============");

        Function<String,String> removeSpaces = s -> s.replaceAll(" ","");
        System.out.println(removeSpaces.apply("Hello, have a nice day"));
    }
}

/*
 *   Output:
 *   44.721359549995796
 *   ==============
 *   Hello: ANSHUMAN
 *   Hello: AMAY
 *   ==============
 *   Hello,haveaniceday
 */