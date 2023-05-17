package method_reference_and_constructor_reference;

/*
 * Example demonstrating use of method reference to print a list
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceExample2 {
    public static void main(String[] args) {
        Consumer<Integer> consumer = System.out::println;
        List<Integer> list = Arrays.asList(10, 30, 15, 25);
        list.forEach(consumer);
    }
}
