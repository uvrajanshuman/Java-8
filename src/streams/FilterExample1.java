package streams;

/*
 * Example demonstrating Stream method: filter
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample1 {
    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(5, 10, 15, 20);

        List<Integer> evenNumbers = numbersList.stream()
                .filter(i -> i %2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers in the list: "+evenNumbers);
    }
}

/*
 * Output:
 * Even numbers in the list: [10, 20]
 */