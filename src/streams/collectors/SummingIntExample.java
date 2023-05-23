package streams.collectors;

/*
 * Example demonstrating Collectors method: summingInt
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SummingIntExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum: " + sum);
    }
}

/*
 * Output:
 * Sum: 15
 */