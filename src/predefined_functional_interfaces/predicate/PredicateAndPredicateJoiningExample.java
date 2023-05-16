package predefined_functional_interfaces.predicate;

/*
 *  Example demonstrating use of Predicates and Predicate Joining.
 */

import java.util.function.Predicate;

public class PredicateAndPredicateJoiningExample {

    // Predicate to check a number is greater than 10 or not.
    static Predicate<Integer> checkGreaterThanTen = i -> i>10;

    // Predicate to check a number is even or not
    static Predicate<Integer> checkEven = i -> i%2==0;

    public static void main(String[] args) {

        int[] arr = {0, 5, 10, 15, 20, 25, 30};

        System.out.println("Numbers greater than 10:");
        printConditionally(checkGreaterThanTen, arr);

        System.out.println("Even numbers:");
        printConditionally(checkEven, arr);

        //negate() -- reverses the condition of predicate
        System.out.println("Numbers NOT greater than 10:");
        printConditionally(checkGreaterThanTen.negate(), arr);

        //and()
        System.out.println("Numbers greater than 10 AND Even:");
        printConditionally(checkGreaterThanTen.and(checkEven), arr);

        //or()
        System.out.println("Numbers greater than 10 OR Even:");
        printConditionally(checkGreaterThanTen.or(checkEven), arr);

    }

    public static void printConditionally(Predicate<Integer>p, int[] arr) {
        System.out.print("[");
        for(int i : arr) {
            if(p.test(i))
                System.out.print(i+",");
        }
        System.out.println("]");
    }
}

/*
 * Output:
 * Numbers greater than 10:
 * [15,20,25,30,]
 * Even numbers:
 * [0,10,20,30,]
 * Numbers NOT greater than 10:
 * [0,5,10,]
 * Numbers greater than 10 AND Even:
 * [20,30,]
 * Numbers greater than 10 OR Even:
 * [0,10,15,20,25,30,]
 */