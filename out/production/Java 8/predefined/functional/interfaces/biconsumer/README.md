# BiConsumer

- Normal Consumer can take only one input argument and perform required operation and won't return any result.
- BiConsumer can take two inputs perform required operation and won't return any result.
- BiConsumer is exactly same as Consumer except it wll take 2 input arguments.

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

Ex: Program to accept 2 String values and print their concatenation.

```java
import java.util.function.BiConsumer;
class App{
    public static void main(String[] args) {
        BiConsumer<String,String> biCon = (s1, s2) -> System.out.println(s1+s2);
        biCon.accept("Hello", "World"); // HelloWorld
    }
}
```
