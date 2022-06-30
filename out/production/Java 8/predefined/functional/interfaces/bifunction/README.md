# BiFunction

- Normal Function can take only one input argument and perform required operation and return a result.
- BiFunction can take two inputs perform required operation and return a result.
- BiFunction is exactly same as Function except it wll take 2 input arguments.

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

Ex: Program to find product of 2 given integers

```java
import java.util.function.BiFunction;
class App{
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> bFn = (a,b) -> a*b;
        System.out.println(bFn.apply(10,20)); // 200
        System.out.println(bFn.apply(100,200)); // 20000
    }
}
```
----

## BinaryOperator<T>

- Functional interface that extends BiFunction.
- It represents a binary operator which takes two operands and operates on them to produce a result. 
- However, what distinguishes it from a normal BiFunciton is that both of its arguments and its return type are same.
- This functional interface which takes in one generic namely:
  - T: denotes the type of the input arguments and the return value of the operation
- If the input type and output type for BiFunction (Functional Interface) are same, BinaryOperator should be preferred.
- Same functionality as BiFunction
- The SAM `apply()` method and default methods `andThen()` are inherited from BiFunction interface.

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
    
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

Ex:
```java
import java.util.function.BiFunction;
class App{
    public static void main(String[] args) {
        BiFunction<String, String, String> biFn = (s1, s2) -> s1+s2;
        System.out.println(biFn.apply("Hello", "World")); // HelloWorld
    }
}
```

>Since both input type and the output type are same BinaryOperator should be used instead of
>BiFunction

```java
import java.util.function.BinaryOperator
class App{
    public static void main(String[] args) {
        BinaryOperator<String> biFn = (s1, s2) -> s1+s2;
        System.out.println(biFn.apply("Hello","World")); // HelloWorld
    }
}
```

### maxBy()

```java
import java.util.Comparator;
import java.util.function.BinaryOperator;

class App {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a,b)-> a.compareTo(b);
        BinaryOperator<Integer> op = BinaryOperator.maxBy(comparator);
        System.out.println(op.apply(100,10)); // 100
    }
}
```

### minBy()

```java
import java.util.Comparator;
import java.util.function.BinaryOperator;

class App {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a,b)-> a.compareTo(b);
        BinaryOperator<Integer> op = BinaryOperator.minBy(comparator);
        System.out.println(op.apply(100,10)); // 10
    }
}
```


