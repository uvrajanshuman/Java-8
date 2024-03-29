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

## Numeric Stream Operations:

### Numeric Stream - Ranges

Numeric streams (IntStream, LongStream, DoubleStream) provide methods to generate a sequence of consecutive numbers within a specific range.

1. `range(start, end)`
    - Generates a sequential range of numbers from starting value (inclusive) to the ending value (exclusive).
    - Ex: `IntStream.range(1,50)` returns an IntStream of 49 elements from 1 to 49.
2. `rangeClosed(start, end)`
    - Similar to `range()`, generates a range of numbers from starting value (inclusive) to the ending value (inclusive) 
    - Ex: `IntStream.rangeClosed(1,50)` returns an IntStream of 50 elements from 1 to 50.
3. `iterate(seed, condition, operator)`
    - Generates an infinite stream of numbers starting from the seed value, with subsequent values computed based on the given
   condition and operator. The condition specifies when to stop generating numbers.
    - Ex: `IntStream.generate(1, n -> n<=10, n -> n+2)` generates an infinite stream of odd numbers starting from 1 and stopping
   when the number exceeds 10.

Note:<br>
DoubleStream does not support the range() and rangeClosed().<br>
But IntStream and LongStream can be converted into double stream using `asDoubleStream()` method.
  Ex:<br>
  `DoubleStream doubleStream = IntStream.range(1,50).asDoubleStream();`

[Example: Numeric stream - ranges](./RangesExample.java)

<details>
  <summary>click to expand/collapse</summary>

```java
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
```
Output:
```shell
IntStream.range(1,6) : 1 2 3 4 5 
IntStream.rangeClosed(1,5) : 1 2 3 4 5 
LongStream.range(1L,6L) : 1 2 3 4 5 
LongStream.rangeClosed(1L,5L) : 1 2 3 4 5 
IntStream.range(1,50).asDoubleStream() : 1.0 2.0 3.0 4.0 5.0 
DoubleStream.iterate(0.0, n -> n + 0.5).limit(5) : 0.0 0.5 1.0 1.5 2.0 
```
</details>

### Numeric Stream - Aggregate Functions.

Numeric streams provide a set of aggregate functions that allows to perform calculations and obtain aggregate results on numeric data. <br>
These aggregate functions are specifically designed for numeric types (int, long, double) and are available in the IntStream, LongStream, and DoubleStream classes.

1. `sum()`

```java
// sum of integers in IntStream
int sum = IntStream.rangeClosed(1,5).sum();
System.out.println(sum); //10
```

2. `max()`

```java
// max integers in IntStream
OptionalInt maxNo = IntStream.of(5,3,9,1,7).max(); 
if(maxNo.isPresent())
    System.out.println(maxNo.getAsInt()); //9
```

#### min()

```java
// min integers in IntStream
OptionalInt minNo = IntStream.rangeClosed(1,50).min(); //1
if(maxNo.isPresent())
    System.out.println(maxNo.getAsInt()); // 1
```

#### average()

```java
// max integers in IntStream
OptionalDouble avg = IntStream.rangeClosed(1,5).average;
System.out.println(avg.isPresent()?avg.getAsDouble():0); //3.0
```
> Above operations can also be performed on LongStream and DoubleStream.


### Numeric Steam - Mapping Functions

These mapping functions work same like the [`map`](../README.md#map) method of normal stream.
And is used to transform elements of stream from one type to another. The primitive versions are more efficient and optimized
for numeric values. so, should be preferred over noram map method of stream in case of primitives.

Certainly! Here are the revised summaries of the mapping functions of numeric streams with examples:

1. `mapToObj()`:
    - Available in: IntStream, LongStream, DoubleStream
    - Syntax: `<U> Stream<U> mapToObj(<primitive>ToObjFunction<? super T, ? extends U> mapper)`
    - Parameter:
        - `mapper`: A functional interface that accepts a primitive value and returns an object of type `U`.
    - Return Type: `Stream<U>`
    - Description: Maps each element of the numeric stream to an object of a different type using the provided mapping function.

   Example (mapToObj()):
   ```java
   IntStream.rangeClosed(1, 5)
            .mapToObj(i -> "Number " + i)
            .forEach(System.out::println);
   ```
   Output:
   ```shell
   Number 1
   Number 2
   Number 3
   Number 4
   Number 5
   ```

2. `mapToInt()`:
    - Available in: Stream, LongStream, DoubleStream
    - Syntax: `IntStream mapToInt(<primitive>ToIntFunction<? super T> mapper)`
    - Parameter:
        - `mapper`: A functional interface that accepts an element of type `T` and returns an `int` value.
    - Return Type: `IntStream`
    - Description: Maps each element of the stream to an `int` value using the provided mapping function.

   Example (mapToInt()):
   ```java
   Stream.of("apple", "banana", "cherry")
         .mapToInt(String::length)
         .forEach(System.out::println);
   ```
   Output:
   ```
   5
   6
   6
   ```

3. `mapToLong()`:
    - Available in: Stream, IntStream, DoubleStream
    - Syntax: `LongStream mapToLong(<primitive>ToLongFunction<? super T> mapper)`
    - Parameter:
        - `mapper`: A functional interface that accepts an element of type `T` and returns a `long` value.
    - Return Type: `LongStream`
    - Description: Maps each element of the stream to a `long` value using the provided mapping function.

   Example (mapToLong()):
   ```java
   DoubleStream.of(1.5, 2.5, 3.5)
               .mapToLong(value -> (long) value)
               .forEach(System.out::println);
   ```
   Output:
   ```shell
   1
   2
   3
   ```

4. `mapToDouble()`:
    - Available in: Stream, IntStream, LongStream
    - Syntax: `DoubleStream mapToDouble(<primitive>ToDoubleFunction<? super T> mapper)`
    - Parameter:
        - `mapper`: A functional interface that accepts an element of type `T` and returns a `double` value.
    - Return Type: `DoubleStream`
    - Description: Maps each element of the stream to a `double` value using the provided mapping function.

   Example (mapToDouble()):
   ```java
   LongStream.rangeClosed(1, 5)
             .mapToDouble(value -> Math.sqrt(value))
             .forEach(System.out::println);
   ```
   Output:
   ```
   1.0
   1.4142135623730951
   1.7320508075688772
   2.0
   2.23606797749979
   ```

5. `map()`:
    - Available in: Stream, IntStream, LongStream, DoubleStream
    - Syntax: `<U> Stream<U> map(<primitive>Function<? super T, ? extends U> mapper)`
- Parameter:
    - `mapper`: A functional interface that accepts an element of type `T` and returns an element of type `U`.
- Return Type: `Stream<U>`
- Description: Maps each element of the stream to a new element using the provided mapping function.

Example (map()):
   ```java
   IntStream.range(1, 6)
            .map(i -> i * 2)
            .forEach(System.out::println);
   ```
Output:
   ```
   2
   4
   6
   8
   10
   ```

Note:<br>
\<primitive> refers to the respective primitive type: int, long, or double.

### Numeric Stream - Boxing and UnBoxing

- Boxing: converting a primitive type to wrapper class type.
    - Ex: int to Integer
    - `boxed()`
- UnBoxing: converting a wrapper class type to primitive type.
    - Ex: Integer to int

```java
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    // Primitive to wrapper
    private static List<Integer> boxing() {
        List<Integer> integerList = IntStream
                .rangeClosed(1, 10) // IntStream of 10 elements
                .boxed() // int -> Integer
                .collect(Collectors.toList());
        
        return  integerList;
    }

    // Wrapper to primitive
    private static int unBoxing(List<Integer> integerList){
        return integerList.stream()
                .mapToInt(Integer::intValue) // IntStream(intValue of wrapper class)
                .sum();
    }
    
    public static void main(String[] args) {
        System.out.println("Boxing: "+boxing()); // [1,2,3,4,5,6,7,8,9,10]
        List<Integer> integerList = boxing();
        System.out.println("Unboxing: "+unBoxing(integerList)); // 55
    }
}
```
