package predefined_functional_interfaces.bi_functional_interfaces.bifunction;

/*
 *  Example demonstrating use of minBy() and maxBy() methods of  BinaryOperator
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorMaxByMinByExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(Integer::compareTo);
        Integer min = numbers.stream().reduce(minBy).get();
        System.out.println("Minimum number: " + min); // 1

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(Integer::compareTo);
        Integer max = numbers.stream().reduce(maxBy).get();
        System.out.println("Maximum number: " + max); // 5
    }
}

/*
 * Output:
 * Minimum number: 1
 * Maximum number: 5
 */