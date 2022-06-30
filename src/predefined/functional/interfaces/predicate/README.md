# Predicates

- A boolean valued function.
- function with single argument and returns a boolean value.
- Predicate interface is present in `java.util.function` package.
- It's a functional interface with single abstract method i.e.- test().

    ```java
    @FunctionalInterface
    interface Predicate<T>{
        // Single abstract method
        public boolean test(T t);
  
        // Predicate joining/chaining
        default Predicate<T> negate(){
            ...
        } 
        default Predicate<T> and(Predicate<T> p){
            ...
        } 
        default Predicate<T>  or(Predicate<T> p){
            ...
        } 
        // return a Predicate ment for equality check
        static Predicate<T> isEqual(T t){
            ...
        } 
    }
    ```

- A Predicate is a functional interface, so it can refer Lambda expression.

Ex: Program to check whether a number is even or not

- prior Java8
```java
public class App{
  public static void main(String[] args) {
    System.out.println(App.checkEven(10));
  }
  public static boolean checkEven(int i){
      return i%2==0;
  }
}
```

- using Predicate
```java
public class App{
  public static void main(String[] args) {
    Predicate<Integer> checkEven = integer -> i%2==0;
    System.out.println(checkEven.test(10));
  }
}
```

## Predicate joining

- It is possible to join predicates into a single predicate using following methods
  - and()
    - `joinedPredicate = prediacate1.and(predicate2)`
    - returns a composed Predicate that represent logical AND operation between supplied Predicated.
  - or()
    - `joinedPredicate = prediacate1.or(predicate2)`
    - returns a composed Predicate that represent logical OR operation between supplied Predicated..
  - negate()
    - `negatedPredicate = prediacate1.negate`
    - returns a Predicate that represent negation of supplied Predicate.
  
- These are similar to logical AND, OR and compliment operators.


Ex:

```java
import java.util.function.Predicate;
public class App {
    
  public static void main(string[] args) {
    int[] x = {0, 5, 10, 15, 20, 25, 30};
    // Predicate to check a number is greater than 10 or not.
    Predicate<integer> checkGreaterThanTen = i->i>10;
    // Predicate to check a number is even or not
    Predicate<integer> checkEven=i -> i%2==0;
    
    System.out.println("The Numbers Greater Than 10:");
    printConditionally(checkGreaterThanTen, x);
    
    System.out.println("The Even Numbers Are:");
    printConditionally(checkEven, x);
    
    //negate() -- reverses the conditon of predicate
    System.out.println("The Numbers Not Greater Than 10:");
    printConditionally(checkGreaterThanTen.negate(), x);
    
    //and()
    System.out.println("The Numbers Greater Than 10 And Even Are:");
    printConditionally(checkGreaterThanTen.and(checkEven), x);
    
    //or()
    System.out.println("The Numbers Greater Than 10 OR Even:");
    printConditionally(checkGreaterThanTen.or(checkEven), x);

  }
  
  public static void printConditionally(Predicate<Integer>p, int[] x) {
    for(int x1:x) {
      if(p.test(x1))
      System.out.println(x1);
    }
  }
}
```
## Predicate interface static method: isEqual()

-  Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).

```java
import java.util.function.Predicate;

class App {
    public static void main(String[] args) {
        Predicate<String> p = Predicate.isEqual("Anshuman");
        System.out.println(p.test("Anshuman")); //true
        System.out.println(p.test("Yuvraj"));  //false
    }
} 
```

