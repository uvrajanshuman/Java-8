# Predicate

A functional interface that represents a boolean valued function.

It's a functional interface present in `java.util.function` package, and has a single abstract method `test()`. <br>
This method is meant to define a condition or criteria that can further be used to test objects or values.

```java
    public boolean test(T t);
```
The `test()` method takes an input of specified type and returns a boolean value indication whether the input satisfies the
condition defined by the predicate.

**`Predicate<T>`**
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
  
    // return a Predicate meant for equality check
    static Predicate<T> isEqual(T t){
        ...
    } 
}
```

- A Predicate is a functional interface, so it can refer a Lambda expression (as implementation of its SAM `test()`).

### Example: Program to check whether a given number is even or not

**Prior Java 8 :**

```java
public class App {
    public static void main(String[] args) {
        System.out.println(App.checkEven(10)); //true
    }

    public static boolean checkEven(int i) {
        return i % 2 == 0;
    }
}
```

**Using Predicate:**

```java
import java.util.Predicate;

public class App {
    public static void main(String[] args) {
        Predicate<Integer> checkEven = i -> i % 2 == 0;
        System.out.println(checkEven.test(10)); //true
    }
}
```

## Predicate joining

It is possible to join predicates into a single predicate using following methods
- and()
  - `joinedPredicate = prediacate1.and(predicate2)`
  - returns a composed Predicate that represents the **logical AND operation** between the supplied Predicates.
- or()
    - `joinedPredicate = prediacate1.or(predicate2)`
    - returns a composed Predicate that represents the **logical OR operation** between the supplied Predicates.
- negate()
    - `negatedPredicate = prediacate1.negate()`
    - returns a Predicate that represents the **negation** of supplied Predicate.

These are similar to **Logical AND**, **Logical OR** and **Compliment** operators.

Example:

```java
import java.util.function.Predicate;

/*
 *  Example demonstrating use of Predicates and Predicate Joining.
 */
public class PredicateExample {

    // Predicate to check a number is greater than 10 or not.
    static Predicate<Integer> checkGreaterThanTen = i -> i > 10;

    // Predicate to check a number is even or not
    static Predicate<Integer> checkEven = i -> i % 2 == 0;

    public static void main(String[] args) {

        int[] arr = {0, 5, 10, 15, 20, 25, 30};

        System.out.println("Numbers greater than 10:");
        printConditionally(checkGreaterThanTen, arr);

        System.out.println("Even numbers:");
        printConditionally(checkEven, arr);

        //negate() -- reverses the condition of predicate
        System.out.println("Numbers NOT greater than 10:");
        printConditionally(checkGreaterThanTen.negate(), arr);

        //and()
        System.out.println("Numbers greater than 10 AND Even:");
        printConditionally(checkGreaterThanTen.and(checkEven), arr);

        //or()
        System.out.println("Numbers greater than 10 OR Even:");
        printConditionally(checkGreaterThanTen.or(checkEven), arr);

    }

    public static void printConditionally(Predicate<Integer> p, int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            if (p.test(i))
                System.out.print(i + ",");
        }
        System.out.println("]");
    }
}

```
Output:
```shell
Numbers greater than 10:
[15,20,25,30,]
Even numbers:
[0,10,20,30,]
Numbers NOT greater than 10:
[0,5,10,]
Numbers greater than 10 AND Even:
[20,30,]
Numbers greater than 10 OR Even:
[0,10,15,20,25,30,]
```
[Example: Predicate and Predicate Joining](./PredicateAndPredicateJoiningExample.java)

## Predicate interface static method: `isEqual()`

Returns a predicate, that tests if two arguments are equal according to `Objects.equals(Object, Object)`.

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

[Example: Predicate isEqual()](./PredicateIsEqualExample.java)
