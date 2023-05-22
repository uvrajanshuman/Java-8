package streams;

/*
 * Example demonstrating Stream methods: limit and skip
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitAndSkipExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> firstThreeSum = integerList
                .stream() // Stream<Integer> // all integers of integerList.
                .limit(3) // Stream<Integer> // limited to first three integers of integerList.
                .reduce(Integer::sum);
        firstThreeSum.ifPresent(integer -> System.out.println("Sum: " + integer));


        Optional<Integer> skipThreeSum = integerList
                .stream() // Stream<Integer> // all integers of integerList.
                .skip(3) // Stream<Integer> // first three integers of integerList will be skipped..
                .reduce(Integer::sum);

        skipThreeSum.ifPresent(integer -> System.out.println("Sum: " + integer));

    }
}

/*
 * Output:
 * Sum: 6
 * Sum: 15
 */