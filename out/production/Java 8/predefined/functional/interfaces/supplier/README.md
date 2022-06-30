# Supplier

- A function that does not takes any input but return something.
- function with single argument.
- Supplier interface is present in `java.util.function` package.
- It's a functional interface with single abstract method i.e.- get().
- Used to supply items(objects).
- Supplier won't take any input and it will always supply objects.
- Doesn't contains any default or static method.

```java
interface Supplier<R>{
    public R get();
}
```

Ex: Program to supply System date.
```java
import java.util.function.*;
import java.util.*;
class App
{
    public static void main(String[] args)
    {
        Supplier<Date> s=()->new Date();
        System.out.println(s.get());
    }
} 
```