# Function

A functional interface that represents a function that take an input, processes it and produces some output.

It is a functional interface present in `java.util.function` package and has a single abstract method `apply()`.<br>
This method is generally meant for transforming or mapping values from one type to another.

```java
R apply(T t);
```
The `apply()` method takes an input of a specified type and returns a result of specified type.<br>
Here, **T** represents the type of the input parameter, and **R** represents the type of the result produced by the function. 
The apply method implementation should perform the desired computation or transformation on the input value and return the result.

**`Function<T,R>`**
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

### Ex: Program to check length of a string.

**Prior Java 8:**

```java
public class App {
    public static void main(String[] args) {
        System.out.println(App.findLength("RAnshuman"));
    }

    public static int findLength(String s) {
        return s.length();
    }
}
```

**Using Function:**

```java
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        Function<String, Integer> findLength = s -> s.length();
        System.out.println(findLength.apply("Anshuman"));
    }
}
```
[Example: Function](./FunctionExample.java)

## Function Chaining

Multiple functions can be combined to form more complex function. For this two default methods are provided.
- andThen()
  - `resultingFunction = f1.andThen(f2)`
  - First **f1** will be applied and then for the result **f2** will be applied.
- compose()
    - `resultingFunction = f1.compose(f2)`
    - First **f2** will be applied and then for the result **f1** will be applied.

Example:
```java
import java.util.function.Function;

/*
 *  Example demonstrating use of Function and Function Chaining.
 */
public class FunctionExample {
    //Function to find square of a number
    static Function<Integer, Integer> squareFn = i -> i * i;
    //Function to divide a number into half
    static Function<Integer, Integer> divFn = i -> i / 2;

    public static void main(String[] args) {

        System.out.printf("Squaring 2: %d\n", squareFn.apply(2)); //4
        System.out.printf("Halving 2: %d\n", divFn.apply(2)); //1

        //andThen()
        System.out.printf("Squaring 2 then Halving the result: %d\n", squareFn.andThen(divFn).apply(2)); //2
        //compose()
        System.out.printf("Halving 2 then Squaring the result: %d\n", squareFn.compose(divFn).apply(2)); //1
    }
}
```
Output:
```shell
Squaring 2: 4
Halving 2: 1
Squaring 2 then Halving the result: 2
Halving 2 then Squaring the result: 1
```
[Example: Function and Function chaining](./FunctionAndFunctionChainingExample.java)

## Function interface static Method : `identity()`

Returns a function that always returns its input arguments.

Example:

```java
import java.util.function.Function;

class App {
    public static void main(String[] args) {
        Function<String, String> f1 = Function.identity();
        String s2 = f1.apply("Anshuman");
        System.out.println(s2); //Anshuman
    }
}
```
[Example: Function identity()](./FunctionIdentityExample.java)

---
## UnaryOperator<T>

Functional interface that extends Function.

It represents an operation that accepts a parameter and returns the result of same type
as its input parameter.

It is a functional interface present in the `java.util.function` package and has a single abstract method `apply()`.

```java
T apply(T t);
```
The `apply()` method takes an input of a specified type and return result of same type.<br>
Here, **T** denotes the type of the input arguments and the return value of the operation.

If the input type and output type for [Function](#function) (Functional Interface) are same, UnaryOperator should be preferred.
It has same functionality as [Function](#function).

The SAM `apply()` method and default methods `andThen()` and `compose()` are inherited from Function interface.

**`UnaryOperator<T>`**
```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {

    //Returns a unary operator that always returns its input argument.
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}
```

Example:

```java
import java.util.function.Function;

class App {
    public static void main(String[] args) {
        Function<Integer, Integer> sqFn = i -> i * i;
        System.out.println(sqFn.apply(5)); //25
    }
}
```
>Since input type and output type are same. `UnaryOperator` should be used instead of `Function`

```java
import java.util.function.UnaryOperator;

class App {
    public static void main(String[] args) {
        UnaryOperator<Integer> sqFn = i -> i * i;
        System.out.println(sqFn.apply(5)); //25
    }
}
```
[Example: UnaryOperator](./UnaryOperatorExample.java)
