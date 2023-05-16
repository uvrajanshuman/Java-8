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

[Example: BiFunction and BiFunction chaining](BiFunctionExample.java) <br>

