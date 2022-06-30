package streams;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamFactoryMethodsExample {
    public static void main(String[] args) {

        //of()
        Stream<String> stringStream = Stream.of("Anshuman", "Yuvraj", "Amay", "Ankit");
        stringStream.forEach(System.out::println);

        //iterate()
        Stream<Integer> integerStream = Stream.iterate(1, x->x*2) //infinite stream 1,2,4,...Integer.Max_VALUE, 0, 0...
                .limit(10);
        integerStream.forEach(System.out::println);

        //generate()
        Supplier<Integer> intSupplier = new Random()::nextInt;
        Stream<Integer> randomIntStream = Stream.generate(intSupplier)
                .limit(5);
        randomIntStream.forEach(System.out::println);

    }
}
