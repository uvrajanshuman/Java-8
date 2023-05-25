package streams.parallel_streams;

/*
 * Example demonstrating the efficiency of parallel stream over normal stream for large data sets
 */

import java.util.stream.LongStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        long sumSequential = LongStream.rangeClosed(1, 10_000_000)
                .sum();

        long endTimeSequential = System.currentTimeMillis();

        long sumParallel = LongStream.rangeClosed(1, 10_000_000)
                .parallel()
                .sum();

        long endTimeParallel = System.currentTimeMillis();

        System.out.println("Sum (Sequential): " + sumSequential);
        System.out.println("Time taken (Sequential): " + (endTimeSequential - startTime) + "ms");

        System.out.println("Sum (Parallel): " + sumParallel);
        System.out.println("Time taken (Parallel): " + (endTimeParallel - endTimeSequential) + "ms");
    }
}
