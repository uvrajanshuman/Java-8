# BiFunction

BiFunction is a functional interface in Java that represent a [Function](../../function/README.md) accepting two parameters.

[Normal Function](../../function/README.md) can take only one input argument and perform required operation and return a result.<br>
BiFunction can take two inputs perform required operation and return a result.
BiFunction is exactly same as Function except it wll take 2 input arguments.

It is a functional interface present in `java.util.function` package and has a single abstract method `apply()`. <br>
```java
R apply(T t, U u);
```
Here, **T** and **U** represent the types of the input parameters, and **R** represents the type of the result that the function produces. 
The apply method implementation should define the logic to process the input arguments and generate the desired result.

**`BiFunction<T, U, R>`**
```java
@FunctionalInterface
public interface BiFunction<T, U, R> {
  //SAM (Single Abstract Method)
  R apply(T t, U u);
  
  //BiFunction Chaining
  // andThen 
  // Note: accepts Function not BiFunction
  default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        ...
  }
}
```

### Example: Program to concatenate two strings

```java
import java.util.function.BiFunction;

class App {
  public static void main(String[] args) {
      BiFunction<String, String, String> concatenateFunction = (str1, str2) -> str1 + str2;

      String text1 = "Hello, ";
      String text2 = "World!";

      // Concatenate the two strings
      String result = concatenateFunction.apply(text1, text2);

      System.out.println("Concatenated string: " + result);
  }
}
```
Output:
```shell
Concatenated string: Hello, World!
```

[Example: BiFunction and BiFunction chaining](BiFunctionExample.java)

---

## BinaryOperator<T>

Functional interface that extends [BiFunction](#bifunction).<br>
However, what distinguishes it from a normal BiFunciton is that both of its arguments and its return type are same.

It represents an operation which takes two operands of the same type and returns a result of the same type.

It is a functional interface present in `java.util.function` package and has a single abstract method `apply()`
```java
T apply(T t, T u);
```
Here, **T** represents the type of the operands and the result.
The apply method implementation should define the logic to perform the binary operation on the provided input values and generate the desired result.

If the input type and output type for BiFunction (Functional Interface) are same, BinaryOperator should be preferred.
It has same functionality as BiFunction

The SAM `apply()` method and default methods `andThen()` are inherited from BiFunction interface.

**`BinaryOperator<T>`**
```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {

  //This method returns a BinaryOperator which returns the lesser of the two elements based on a given comparator
  public static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
    Objects.requireNonNull(comparator);
    return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
  }

  // This methods return a BinaryOperator which returns the greater of the two elements based on a given comparator
  public static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator) {
    Objects.requireNonNull(comparator);
    return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
  }
}

```

Example:

```java
import java.util.function.BiFunction;

class App {
  public static void main(String[] args) {
    BiFunction<String, String, String> biFn = (s1, s2) -> s1 + s2;
    System.out.println(biFn.apply("Hello", "World")); // HelloWorld
  }
}
```

>Since both input type and the output type are same BinaryOperator should be used instead of
>BiFunction

```java
import java.util.function.BinaryOperator;

class App {
  public static void main(String[] args) {
    BinaryOperator<String> biFn = (s1, s2) -> s1 + s2;
    System.out.println(biFn.apply("Hello", "World")); // HelloWorld
  }
}
```

## `maxBy()`

```java
import java.util.Comparator;
import java.util.function.BinaryOperator;

class App {
  public static void main(String[] args) {
    Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    BinaryOperator<Integer> op = BinaryOperator.maxBy(comparator);
    System.out.println(op.apply(100, 10)); // 100
  }
}
```

## `minBy()`

```java
import java.util.Comparator;
import java.util.function.BinaryOperator;

class App {
  public static void main(String[] args) {
    Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    BinaryOperator<Integer> op = BinaryOperator.minBy(comparator);
    System.out.println(op.apply(100, 10)); // 10
  }
}
```


