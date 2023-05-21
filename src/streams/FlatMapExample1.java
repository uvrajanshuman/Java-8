package streams;

/*
 * Example demonstrating Stream method: flatMap
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample1 {
    public static void main(String[] args) {
        List<Integer> subList1 = Arrays.asList(1, 2);
        List<Integer> subList2 = Arrays.asList(3, 4);
        List<Integer> subList3 = Arrays.asList(5, 6);

        List<List<Integer>> list = Arrays.asList(subList1, subList2, subList3);

        List<Integer> collectedList = list.stream() // Stream<List<Integer>>
                .flatMap(l -> l.stream()) // Stream<Integer>
                .collect(Collectors.toList()); // List<Integer>

        System.out.println("Flattened List: "+collectedList);
    }
}
