# Consumer

- A function that takes an input and processes it and doesn't returns anything.
- function with single argument.
- Consumer interface is present in `java.util.function` package.
- It's a functional interface with single abstract method i.e.- accept().
- Used to consume object and perform certain operation.

```java
@FunctionalInterface
public interface Consumer<T> {
    // SAM(Single Abstract Method)
    void accept(T t);
    // Consumer chaining
    default Consumer<T> andThen(Consumer<? super T> after) {
        ...
    }
}
```

Ex:

```java
import java.util.function.Consumer;
class App
{
    public static void main(String[] args)
    {
        Consumer<String> c=s->System.out.println(s);
        c.accept("Hello");
        c.accept("world");
    }
}
```
>Output:<br>
> Hello
> world

## Consumer Chaining

- Multiple functions can be combined to form more complex function.
- For this a default methods is provided.
    - andThen()
    - `joinedConsumer = consumer1.andThen(consumer2).andThen(consumer3)`
    - `joinedConsumer.accept(s)`
    - First consumer1 wil be applied followed by consumer2 and consumer3.
