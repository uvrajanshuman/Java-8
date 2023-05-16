# BiConsumer

BiConsumer is a functional interface that represents a [Consumer](../../consumer/README.md) accepting two parameters.

[Normal Consumer](../../consumer/README.md) can take only one input argument and perform required operation and won't return any result.
BiConsumer can take two inputs perform required operation and won't return any result.
It is exactly same as Consumer except it wll take 2 input arguments.

It is a functional interface present in `java.util.function` pacckage and has a single abstract method `accept()`.
```java
void accept(T t, U u);
```
Here, **T** and **U** represent the types of the input parameters. 
The accept method implementation defines the action to be performed on the input arguments.
    
```java
@FunctionalInterface
public interface BiConsumer<T, U> {
    //SAM (Single Abstract Method)
    void accept(T t, U u);

    //BiConsumer chaining
    //andThen
    default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
        ...
    }
}
```

### Example: Program to accept 2 String values and print their concatenation.

```java
import java.util.function.BiConsumer;

class App {
    public static void main(String[] args) {
        BiConsumer<String, String> biCon = (s1, s2) -> System.out.println(s1 + s2);
        biCon.accept("Hello", "World"); 
    }
}
```
Output:
```shell
HelloWorld
```

[Example: BiConsumer](./BiConsumerExample.java)