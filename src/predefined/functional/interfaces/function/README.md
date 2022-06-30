# Functions

- Similar to Predicate except that Functions can return any type as result.
- But Function can return only one value and that value can be of any type.
- function with two arguments where first one represents input argument and second 
one represents return type.<br> Function<T,R>
- Function interface is present in `java.util.function` package.
- It's a functional interface with single abstract method i.e.- apply().

```java
@FunctionalInterface
public interface Function<T, R> {
    // SAM (Single Abstract Method)
    R apply(T t);
    
    // Function chaining
    default Function<V, R> compose(Function<? super V, ? extends T> before) {
        ...
    }
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        ...
    }
    
    //static method returns a Function that always returns it's input argument
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

Ex: Program to check length of a string.

- prior Java8
```java
public class App{
    public static void main(String[] args) {
        System.out.println(App.findLength("Anshuman"));
    }
    public static int findLength(String s){
        return s.length();
    }
}
```

- using Function
```java
import java.util.function.Function;
public class App{
    public static void main(String[] args) {
        Function<String,Integer> f = s -> s.length();
        System.out.println(f.apply("Anshuman"));
    }
}
```

## Function Chaining

- Multiple functions can be combined to form more complex function.
- For this two default methods are provided.
    - andThen()
        - `resultingFunction = f1.andThen(f2)`
        - First f1 will be applied and then for the result f2 will be applied.
    - compose()
        - `resultingFunction = f1.compose(f2)`
        - First f2 will be applied and then fo the result f1 will be applied.

Ex:
```java
import java.util.function.Function;
class App{
    public static void main(String[] args) {
        Function<Integer, Integer> squareFn = i -> i*i;
        Function<Integer, Integer> divFn = i -> i/2;

        System.out.println(squareFn.apply(2)); //4
        System.out.println(divFn(2)); //1

        System.out.println(squareFn.andThen(divFn).apply(2)); //2
        System.out.println(squareFn.compose(divFn).apply(2)); //1
    }
}
```

## Function interface Static Method : identity()
- Returns a function that always returns its input argument.
Ex:
```java
import java.util.function.Function;
class App
{
    public static void main(String[] args)
    {
        Function<String,String> f1= Function.identity();
        String s2= f1.apply("Anshuman");
        System.out.println(s2); //Anshuman
    }
}
```

----

## UnaryOperator<T>

- Functional interface that extends Function.
- It represents an operation that accepts a parameter and returns the result of same type
  as its input parameter.
- This functional interface which takes in one generic namely:-
  - T: denotes the type of the input arguments and the return value of the operation
- If the input type and output type for Function (Functional Interface) are same, UnaryOperator should be preferred.
- Same functionality as Function
- The SAM `apply()` method and default methods `andThen()` and `compose()` are inherited from Function interface.

```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {

    //Returns a unary operator that always returns its input argument.
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}

```

Ex:
```java
import java.util.function.Function;
class App{
    public static void main(String[] args) {
        Function<Integer,Integer> sqFn = i -> i*i;
        System.out.println(sqFn.apply(5));
    }
}
```
>Since input type and output type are same UnaryOperator should be used instead of
>Function

```java
import java.util.function.UnaryOperator
class App{
    public static void main(String[] args) {
        UnaryOperator<Integer> sqFn = i -> i*i;
        System.out.println(sqFn.apply(5));
    }
}
```