# Parallel Streams

Parallel Streams allows to perform stream operations concurrently on multiple threads, harnessing the full potential of multi-core processors. <br>
While normal streams execute operations sequentially on a single thread, parallel streams divide the workload into smaller tasks and distribute them across multiple threads, 
leading to potentially significant performance improvements.

## Creating Parallel Streams:

1. Using `parallelStream()` Method: 
- The easiest way to convert a sequential stream into a parallel stream is by invoking the `parallelStream()` method 
on a collection.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> doubledNumbers = numbers.parallelStream()
    .map(n -> n * 2)
    .collect(Collectors.toList());
```



2. Using `parallel()` Method: 
- Parallel stream can also be explicitly created by invoking the `parallel()` method on an existing sequential stream.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> doubledNumbers = numbers.stream()
    .parallel()
    .map(n -> n * 2)
    .collect(Collectors.toList());
```


3. Using `Arrays.parallelStream()` Method: 
- For arrays, Java provides the `parallelStream()` method directly on the `Arrays` class.

```java
int[] numbers = {1, 2, 3, 4, 5};

int sum = Arrays.parallelStream(numbers)
    .sum();
```


## Advantages of Parallel Streams:
### Enhanced Performance: 
By leveraging multiple threads and cores, parallel streams can process large datasets faster than their sequential counterparts. 
This can be particularly beneficial when dealing with computationally intensive or time-consuming operations.

[Exmple: to calculate the sum of all numbers from 1 to 10 million](./ParallelStreamExample.java)

```java
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
```

In this example, we calculate the sum of all numbers from 1 to 10 million using both sequential and parallel streams. 
The time taken for each approach is measured and compared.

When the workload is relatively small, the sequential stream approach may outperform the parallel stream due to 
the overhead of thread management and synchronization.<br> 
However, as the dataset size increases, the parallel stream can take advantage of multiple threads and cores, leading to faster processing times.

Sample output:

```shell
Sum (Sequential): 50000005000000
Time taken (Sequential): 26ms
Sum (Parallel): 50000005000000
Time taken (Parallel): 9ms
```

In this case, the parallel stream approach took less time compared to the sequential stream, showcasing the performance benefits of parallel processing.

### Automatic Parallelism: 
One of the key advantages of parallel streams is that they provide automatic parallelization. <br>
Unlike traditional multithreading, where we need to manually create and manage threads, parallel streams abstract away the complexities of thread management. 

Java's Stream API automatically handles the distribution of tasks and the synchronization of results, making parallelization more accessible and less error-prone.

### Simplified Implementation:
Parallel streams seamlessly integrate with Java's Stream API, which means you can easily convert your existing 
sequential stream code to parallel streams by invoking the appropriate methods. 

This allows developers to unlock the performance benefits of parallel processing without having to rewrite their entire codebase.

## Scenarios Where Parallel Streams May Not Be Suitable:
While parallel streams offer impressive performance improvements, there are certain scenarios where they may not be the best choice:

### Limited Dataset Size: 
Parallel stream processing involves the overhead of thread management and synchronization.<br>
For small datasets or simple operations, the cost of parallelization may outweigh the performance benefits. Sequential streams are typically more efficient in such cases.

### Non-Thread-Safe Operations:
If your stream operations involve non-thread-safe operations, such as modifying shared mutable state, parallel streams can introduce race conditions and inconsistent results.
In such cases, it's best to use sequential streams or explicitly handle synchronization.


### I/O Bound Operations: 
If your stream operations are primarily I/O bound, such as reading from or writing to a file or a network socket, the benefits of parallel streams may be limited. 
The bottlenecks will likely be the I/O operations themselves rather than CPU-bound processing, making sequential streams more suitable.

## Working of Parallel Streams:
- Parallel Streams uses the Fork/Join Framework that got introduced in Java7.
- No. of Threads created == No. of processors available in the machine.
- `System.out.println("Total Availaible Processors in the Machine: "+ Runtime.getRuntime().availableProcessors());`