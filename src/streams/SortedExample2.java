package streams;

/*
 * Example demonstrating Stream method: sorted()
 */

import java.util.Arrays;
import java.util.List;

public class SortedExample2 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Mango", "Pineapple");

        System.out.println("Original List: " + fruits);

        List<String> sortedFruits = fruits.stream()
                .sorted()
                .toList();

        System.out.println("Sorted Fruits: " + sortedFruits);
    }
}

/*
 * Output:
 * Original List: [Apple, Orange, Banana, Mango, Pineapple]
 * Sorted Fruits: [Apple, Banana, Mango, Orange, Pineapple]
 */