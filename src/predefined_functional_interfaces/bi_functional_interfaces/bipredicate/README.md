# BiPredicate

BiPredicate is a functional interface in Java that represents a [predicate](../../predicate/README.md) (a boolean-valued function) of two arguments.

[Normal Predicate](../../predicate/README.md) can take only one input argument and perform some conditional check and return a boolean result.<br>
BiPredicate can take two inputs perform some conditional check and return a boolean result.
BiPredicate is exactly same as Predicate except it wll take 2 input arguments.

It is a functional interface present in `java.util.function` package and has a single abstract method `test()`.<br>
```java
boolean test(T t, U u);
```
Here, **T** and **U** represent the types of the input parameters. The test method implementation should define the logic 
to evaluate the predicate condition based on the provided input arguments.

**`BiPredicate<T, U>`**
```java
@FunctionalInterface
public interface BiPredicate<T, U> {
    //SAM (Single Abstract Method)
    boolean test(T t, U u);

    //BiPredicate Joining
    //and
    default BiPredicate<T, U> and(BiPredicate<? super T, ? super U> other) {
        ...
    }

    //or
    default BiPredicate<T, U> or(BiPredicate<? super T, ? super U> other) {
        ...
    }

    //negate
    default BiPredicate<T, U> negate() {
        ...
    }
}
```

### Example: Program to check sum of 2 given integers is even or not

```java
import java.util.function.BiPredicate;
/*
 * Example demonstrating the use of BiPredicate       
 */
class App {
    public static void main(String[] args) {
      BiPredicate<Integer, Integer> divisibleByPredicate = (num, divisor) -> num % divisor == 0;

      int number = 12;
      int divisor = 4;

      // Check if the number is divisible by the divisor
      boolean result = divisibleByPredicate.test(number, divisor);

      System.out.println("Is " + number + " divisible by " + divisor + "? " + result);
    }
}
```
Output:
```shell
Is 12 divisible by 4? true
```

[Example: BiPredicate](./BiPredicateExample.java) <br>
[Example 2: BiPredicate](./BiPredicateExample2.java)