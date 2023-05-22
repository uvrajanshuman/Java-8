package streams;

/*
 * Example demonstrating Stream method: reduce(T identity,BinaryOperator<T> accumulator)
 * and reduce(BinaryOperator<T> accumulator)
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

    private static int performSumWithInitialValue(List<Integer> list) {
        return list.stream()
//                .reduce(0,(a,b) -> a+b);
                .reduce(0, Integer::sum);
    }

    private static Optional<Integer> performSumWithNoInitialValue(List<Integer> list) {
        return list.stream()
//                .reduce((a,b) -> a+b);
                .reduce(Integer::sum);
    }

    private static int performMultiplicationWithInitialValue(List<Integer> list) {
        return list.stream()
                .reduce(1, (a,b) -> a*b);
    }

    private static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> list) {
        return list.stream()
                .reduce((a,b) -> a*b);
    }

    private static void printSumAndProduct(List<Integer> integerList) {
        System.out.println("Multiplication with identity: "+performMultiplicationWithInitialValue(integerList));

        Optional<Integer> multiplicationWithoutIdentity = performMultiplicationWithNoInitialValue(integerList);
        if(multiplicationWithoutIdentity.isPresent()) {
            System.out.println("Multiplication without identity: "+multiplicationWithoutIdentity.get());
        }else {
            System.out.println("Multiplication without identity: Empty list, not able to perform multiplication");
        }

        System.out.println("Sum with identity: "+performSumWithInitialValue(integerList));

        Optional<Integer> sumWithoutIdentity = performSumWithNoInitialValue(integerList);
        if(sumWithoutIdentity.isPresent()) {
            System.out.println("Sum without identity: "+sumWithoutIdentity.get());
        }else {
            System.out.println("Sum without identity: Empty list, not able to perform sum");
        }
    }

    public static void main(String[] args) {

        System.out.println("Non-empty list");
        List<Integer> integerList = Arrays.asList(1,3,5,7);
        printSumAndProduct(integerList);

        System.out.println("\nEmpty list");
        List<Integer> integerList2 = Arrays.asList();
        printSumAndProduct(integerList2);
    }
}

/*
 * Output:
 * Non-empty list
 * Multiplication with identity: 105
 * Multiplication without identity: 105
 * Sum with identity: 16
 * Sum without identity: 16
 *
 * Empty list
 * Multiplication with identity: 1
 * Multiplication without identity: Empty list, not able to perform multiplication
 * Sum with identity: 0
 * Sum without identity: Empty list, not able to perform sum
 */