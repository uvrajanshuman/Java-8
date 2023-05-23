package streams.collectors;

/*
 * Example demonstrating Collectors method: averagingInt
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AveragingIntExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Double average = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("Average: " + average);
    }
}

/*
 * Output:
 * Average: 3.0
 */