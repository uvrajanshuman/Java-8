package streams;

/*
 * Example demonstrating Stream factory methods.
 */

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamFactoryMethodsExample {
    public static void main(String[] args) {

        // of()
        Stream<String> fruitStream = Stream.of("apple", "oranges", "banana","pineapple","guava","apple","mango");
        fruitStream.forEach(System.out::println);

        // iterate()
        Stream<Integer> integerStream = Stream.iterate(1, x -> x * 2) //infinite stream 1,2,4,....Integer.MAX_VALUE, 0, 0,...
                .limit(10); //infinite stream gets limited to first 10 elements
        integerStream.forEach(System.out::println);

        // generate
        Supplier<Integer> intSupplier = new Random()::nextInt;
        Stream<Integer> randomIntStream = Stream.generate(intSupplier) //infinite stream
                .limit(5); //infinite stream get limited to first 5 elements
        randomIntStream.forEach(System.out::println);
    }
}
