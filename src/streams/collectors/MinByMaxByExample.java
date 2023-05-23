package streams.collectors;

/*
 * Example demonstrating Collectors method: minBy, maxBy
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinByMaxByExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> maxElement = integerList
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        /*
         * Equivalent to:
         * Optional<Integer> maxElement = integerList
         *       .stream().max(Comparator.naturalOrder());
         */

        Optional<Integer> minElement = integerList
                .stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        /*
         * Equivalent to:
         * Optional<Integer> minElement = integerList
         *       .stream().min(Comparator.naturalOrder());
         */

        maxElement.ifPresent(integer -> System.out.println("Max element in list: " + integer)); // 10
        minElement.ifPresent(integer -> System.out.println("Min element in list: " + integer)); // 1
    }
}

/*
 * Output:
 * Max element in list: 10
 * Min element in list: 1
 */