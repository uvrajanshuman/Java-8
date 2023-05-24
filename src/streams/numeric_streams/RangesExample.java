package streams.numeric_streams;

/*
 * Example demonstrating numeric stream range methods
 */

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RangesExample {
    public static void main(String[] args) {
        // range(start, end)
        System.out.print("IntStream.range(1,6) : ");
        IntStream.range(1, 6)
                .forEach(i -> System.out.print(i +" ")); // 1 2 3 4 5
        System.out.println();

        // rangeClosed(start, end)
        System.out.print("IntStream.rangeClosed(1,5) : ");
        IntStream.rangeClosed(1, 5)
                .forEach(i -> System.out.print(i +" ")); // 1 2 3 4 5
        System.out.println();

        // range(start, end)
        System.out.print("LongStream.range(1L,6L) : ");
        LongStream.range(1L, 6L)
                .forEach(i -> System.out.print(i +" ")); // 1 2 3 4 5
        System.out.println();

        // rangeClosed(start, end)
        System.out.print("LongStream.rangeClosed(1L,5L) : ");
        LongStream.rangeClosed(1L, 5L)
                .forEach(i -> System.out.print(i +" ")); // 1 2 3 4 5
        System.out.println();

        //DoubleStream does not directly support range() or rangeClosed()
        System.out.print("IntStream.range(1,50).asDoubleStream() : ");
        IntStream.range(1,6).asDoubleStream()
                .forEach(i -> System.out.print(i +" ")); // 1.0 2.0 3.0 4.0 5.0
        System.out.println();

        // range using iterate and limit
        System.out.print("DoubleStream.iterate(0.0, n -> n + 0.5).limit(5) : ");
        DoubleStream.iterate(0.0, n -> n + 0.5)
                .limit(5)
                .forEach(i -> System.out.print(i +" ")); // 0.0 0.5 1.0 1.5 2.0

    }
}

/*
 * Output:
 * IntStream.range(1,6) : 1 2 3 4 5
 * IntStream.rangeClosed(1,5) : 1 2 3 4 5
 * LongStream.range(1L,6L) : 1 2 3 4 5
 * LongStream.rangeClosed(1L,5L) : 1 2 3 4 5
 * IntStream.range(1,50).asDoubleStream() : 1.0 2.0 3.0 4.0 5.0
 * DoubleStream.iterate(0.0, n -> n + 0.5).limit(5) : 0.0 0.5 1.0 1.5 2.0
 */