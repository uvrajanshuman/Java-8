# Numeric Streams

Numeric streams (IntStream, LongStream, DoubleStream) are specialized stream designed specifically for 
working with primitive numeric types (int, long, double). 

They provide a set of operations and methods optimized for numerical computations, offering improved performance and 
convenience when dealing with numeric data.

## Need of Numeric Streams

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using Stream<Integer>
        int sumOfSquares1 = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares using Stream<Integer>: " + sumOfSquares1);

        // Using IntStream
        int sumOfSquares2 = numbers.stream()
                .mapToInt(Integer::intValue)
                .map(n -> n * n)
                .sum();
        System.out.println("Sum of squares using IntStream: " + sumOfSquares2);
    }
}
```

Output:
```shell
Sum of squares using Stream<Integer>: 55
Sum of squares using IntStream: 55
```

In the first approach using a regular stream (Stream\<Integer>), we use map() to square each number and then use reduce() 
to calculate the sum. <br>
However, map() converts boxed Integer values to int primitive then performs the square of it and again
returns a stream of boxed Integer objects, which further needs to be unboxed before performing 
the reduction operation. This introduces additional overhead due to the boxing and unboxing operations.

In the second approach using an IntStream, we use mapToInt() to convert the stream of Integer to an IntStream directly. 
This eliminates the need for boxing and unboxing operations, resulting in more efficient code. 
We can then perform the square calculation using map(), followed by the sum() method to obtain the sum of squares directly as an int.

By using the IntStream and avoiding the unnecessary boxing and unboxing, we achieve a more efficient solution for performing numerical computations. 
Numeric streams like IntStream provide specialized operations that eliminate the overhead of working with boxed objects, 
making them ideal for numerical calculations.