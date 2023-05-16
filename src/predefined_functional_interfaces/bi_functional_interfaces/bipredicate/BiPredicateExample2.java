package predefined_functional_interfaces.bi_functional_interfaces.bipredicate;

/*
 *  Example demonstrating use of BiPredicate
 */

import java.util.function.BiPredicate;

public class BiPredicateExample2 {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> areBothEven = (x, y) -> (x % 2 == 0) && (y % 2 == 0);
        System.out.println(areBothEven.test(2, 4));
        System.out.println(areBothEven.test(2, 5));
    }
}

/*
 * Output:
 * true
 * false
 */