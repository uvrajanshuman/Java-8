package streams;

/*
 * Example demonstrating Stream methods: min and max
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> minElement = integerList.stream()
                .min(Comparator.naturalOrder());
        Optional<Integer> maxElement = integerList.stream()
                .max(Comparator.naturalOrder());
        minElement.ifPresent(integer -> System.out.println("Minimum element in the list: " + integer));
        maxElement.ifPresent(integer -> System.out.println("Maximum element in the list: " + integer));
    }
}

/*
 * Output:
 * Minimum element in the list: 1
 * Maximum element in the list: 6
 */