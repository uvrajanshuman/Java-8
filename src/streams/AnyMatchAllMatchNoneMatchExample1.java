package streams;

/*
 * Example demonstrating Stream methods: anyMatch(), allMatch() and noneMatch()
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnyMatchAllMatchNoneMatchExample1 {
    private static final Predicate<Integer> isEven = integer -> integer % 2 == 0;

    //allMatch() demo
    private static boolean checkIfAllEven(List<Integer> list){
        return list.stream()
                .allMatch(isEven);
    }

    //anyMatch() demo
    private static boolean checkIfAnyEven(List<Integer> list){
        return list.stream()
                .anyMatch(isEven);
    }

    //noneMatch() demo
    private static boolean checkIfNoneEven(List<Integer> list){
        return list.stream()
                .noneMatch(isEven);
    }

    public static void main(String[] args) {
        List<Integer> mixedList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenList = Arrays.asList(2,4,6,8,10);
        List<Integer> oddList = Arrays.asList(1,3,5,7,9);

        System.out.println("All match demo for mixedList: "+checkIfAllEven(mixedList)); // false
        System.out.println("All match demo for evenList: "+checkIfAllEven(evenList)); // true
        System.out.println("All match demo for oddList: "+checkIfAllEven(oddList)); // false
        System.out.println();
        System.out.println("Any match demo for mixedList: "+checkIfAnyEven(mixedList)); // true
        System.out.println("Any match demo for evenList: "+checkIfAnyEven(evenList)); // true
        System.out.println("Any match demo for oddList: "+checkIfAnyEven(oddList)); // false
        System.out.println();
        System.out.println("None match demo for mixedList: "+checkIfNoneEven(mixedList)); // false
        System.out.println("None match demo for evenList: "+checkIfNoneEven(evenList)); // false
        System.out.println("None match demo for oddList: "+checkIfNoneEven(oddList)); // true

    }
}

/*
 * Output:
 * All match demo for mixedList: false
 * All match demo for evenList: true
 * All match demo for oddList: false
 *
 * Any match demo for mixedList: true
 * Any match demo for evenList: true
 * Any match demo for oddList: false
 *
 * None match demo for mixedList: false
 * None match demo for evenList: false
 * None match demo for oddList: true
 */