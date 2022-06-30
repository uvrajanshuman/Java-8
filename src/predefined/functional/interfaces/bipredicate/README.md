# BiPredicate

- Normal Predicate can take only one input argument and perform some conditional check and return a boolean result.
- BiPredicate can take two inputs perform some conditional check and return a boolean result.
- BiPredicate is exactly same as Predicate except it wll take 2 input arguments.


```java
@FunctionalInterface
public interface BiPredicate<T, U> {
    //SAM (Single Abstract Method)
    boolean test(T t, U u);
    
    //BiPredicate Joining
    //and
    default BiPredicate<T, U> and(BiPredicate<? super T, ? super U> other) {
        ...
    }
    //or
    default BiPredicate<T, U> or(BiPredicate<? super T, ? super U> other) {
        ...
    }
    //negate
    default BiPredicate<T, U> negate() {
        ...
    }
}

```

Ex: Program to check sum of 2 given integers is even or not
```java
import java.util.function.BiPredicate;
class App{
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> bp = (a,b) -> (a+b)%2==0;
        System.out.println(bp.test(10,20)); // true
        System.out.println(bp.test(15,20)); // false
    }
}
```