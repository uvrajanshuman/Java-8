# Supplier

A functional interface that represents a function acting as supplier of values. It has no input arguments and provides a
result of specified type.

It is a functional interface present in `java.util.function` package and has a single abstract method `get()`.<br>
The method is generally for providing a result without taking any input.
```java
T get();
```
Here, T represents the type of the result that the supplier provides. The get method implementation should define 
the logic to generate or supply the desired result.

Supplier doesn't contain any default or static method.

**`Supplier<R>`**
```java
interface Supplier<R> {
    // SAM (Single Abstract Method)
    public R get();
}
```

### Example: Program to supply System date.

```java
import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<Date> dateSupplier = () -> new Date();

    public static void main(String[] args) {
        System.out.println("Current date: " + dateSupplier.get());
    }
}
```

[Example: Supplier](./SupplierExample1.java) <br>
[Example 2: Supplier](./SupplierExample2.java)