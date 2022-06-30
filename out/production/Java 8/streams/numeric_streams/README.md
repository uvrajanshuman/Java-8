# Numeric Streams

- Streams API provides Stream to work with numbers.
- Represents the primitive values in a Stream
    - IntStream
    - LongStream
    - DoubleStream

## Need of Numeric Streams:

Sample program to find sum of integers using normal streams.

```java
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        
        int sum = integerList
                .stream()
                .reduce(0,(a,b) -> a+b); // unboxing to convert the Integer to int.
        
        System.out.println("Sum: "+sum); // 21
    }
}
```
> Herein, unboxing happens to convert Integer to int for each stream value.<br>
> This is unwanted and reduces the efficiency of program.

Sample program to find sum of integers using numeric stream.

```java
import java.util.stream.IntStream;

class App {
    public static void main(String[] args) {
        int result = IntStream
                .rangeClosed(1,6) // IntStream //1,2,3,4,5,6
                .sum();
                
        System.out.println("Sum: " + result); // 21
    }
}
```
## Numeric Stream Operations:

---
### Numeric Stream - Ranges

#### IntStream:
1. `IntStream.range(1,50)` 
    - Returns an IntStream of 49 elements from 1 to 49.
2. `IntStream.rangeClosed(1,50)`
    - Returns an IntStream of 50 elements from 1 to 50.

#### LongStream:
1. `LongStream.range(1,50)`
    - Returns a LongStream of 49 elements from 1 to 49.
2. `LongStream.rangeClosed(1,50)`
    - Returns a LongStream of 50 elements from 1 to 50.

#### DoubleStream:
- It does not support the range() and rangeClosed().
- But IntStream and LongStram can be converted into double stream using `asDoubleStream()` method.
Ex:<br>
`DoubleStream doubleStream = IntStream.range(1,50).asDoubleStream();`

---
### Numeric Stream - Aggregate Functions.

#### sum()

```java
// sum of integers in IntStream
int sum = IntStream.rangeClosed(1,50).sum();
```

#### max()

```java
// max integers in IntStream
OptionalInt maxNo = IntStream.rangeClosed(1,50).max; 
if(maxNo.isPresent())
    System.out.println(maxNo.getAsInt()); // 50
```

#### min()

```java
// min integers in IntStream
OptionalInt minNo = IntStream.rangeClosed(1,50).max; //1
if(maxNo.isPresent())
    System.out.println(maxNo.getAsInt()); // 1
```

#### average()

```java
// max integers in IntStream
OptionalDouble avg = IntStream.rangeClosed(1,50).average;
System.out.println(avg.isPresent()?avg.getAsDouble():0);
```
> Above operations can also be performed on LongStream and DoubleStream.

----
### Numeric Streams - Boxing and UnBoxing

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

####