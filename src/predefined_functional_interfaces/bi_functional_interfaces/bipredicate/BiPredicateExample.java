package predefined_functional_interfaces.bi_functional_interfaces.bipredicate;

/*
 *  Example demonstrating use of BiPredicate
 */

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, String> startsWithPredicate = (str, prefix) -> str.startsWith(prefix);

        String text = "Hello, World!";
        String prefix = "Hello";

        // Check if the text starts with the prefix
        boolean result = startsWithPredicate.test(text, prefix);

        System.out.println("Does the text start with the prefix? " + result);
    }
}

/*
 * Output:
 * Does the text start with the prefix? true
 */