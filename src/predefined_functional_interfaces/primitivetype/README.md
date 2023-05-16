# Primitive Type Functional Interfaces

## Need:

>Autoboxing: Automatic Conversion from Primitive type to Object by compiler.<br>
>Autounboxing: Automatic Conversion from Object type to Primitive by compiler.<br>
>In case of generics, the type parameters is always Object type and can never ber primitive type.<br>Example:<br>
>`ArrayList&lt;Integer&gt; list = new ArrayList<> (); //valid `<br>
><code>~~ArrayList\<int\> list = new ArrayList<>();~~ //invalid</code>

In case of normal Predefined Functional Interfaces the input and return types are always Object types.

If Primitive types are passed to them, the Primitives will be converted to Object types (Autoboxing) and that Object types will further be converted to Primitive types (Autounboxing) for processing,
and finally the result (Primitive type) may finally be converted to Object type (Autoboxing). <br>
This to and fro conversion causes performance issues.


Example:

```java
import java.util.function.Predicate;

class App {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i % 2 == 0;
        // int -->Integer --> int --> i%2==0 --> boolean 
        System.out.println(p.test(10)); // true
    }
}
```

>In the above multiple autoboxing and autounboxing happens causing performance issues.<br>
>To overcome this problem Primitive type functional interfaces were introduced, which always take primitive type as input
> and return primitive type as result.<br>
> Hence, autoboxing and autounboxing won't be required leading to improved performance.

Above Example using Primitive type functional interface:

```java
import java.util.function.IntPredicate;

class App {
    public static void main(String[] args) {
        IntPredicate p = i -> i % 2 == 0;
        System.out.println(p.test(10)); // true
    }
}
```
> In this implementation Autoboxing and Autounboxing won't be performed. so, will provide better performance.

These Numeric type functional interfaces are present in `java.util.function` package.

## Primitive versions of Predicate

1. IntPredicate
2. LongPredicate
3. DoublePredicate

| Interface       | Purpose                                   | SAM                            |
|-----------------|-------------------------------------------|--------------------------------|
| IntPredicate    | Always accepts input value of int type    | public boolean test(int i);    |
| LongPredicate   | Always accepts input value of long type   | public boolean test(long l);   |
| DoublePredicate | Always accepts input value of double type | public boolean test(double d); |

```java
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*
 *  Example demonstrating use of IntPredicate to find even numbers
 */
class App {

    public static void main(String[] args) {
        int[] arr = {0, 5, 10, 15, 20, 25};

        //Predicate Implementation
        //Predicate<Integer> checkEven = i -> i % 2 ==0;

        //IntPredicate Implementation
        IntPredicate checkEven = i -> i % 2 == 0;
        for (int i : arr) {
            if (checkEven.test(i)) {
                System.out.println(i);
            }
        }
    }
}
```

## Primitive versions of Function

**Takes primitive input and returns any type:**
1. IntFunction
2. LongFunction
3. DoubleFunction

**Takes any type as input but returns primitive type:**
4. ToIntFunction
5. ToLongFunction
6. ToDoubleFunction

**Take and returns primitive type:**
7. IntToLongFunction
8. IntToDoubleFunction
9. LongToIntFunction
10. LongToDoubleFunction
11. DoubleToIntFunction
12. DoubleToLongFunction

**BiFunction, Takes any types as two inputs but always return primitive type:**
13. ToIntBiFunction
14. ToLongBiFunction
15. ToDoubleBiFunction

**UnaryOperator (Function that takes and return same type), Takes and returns primitive type:**
16. IntUnaryOperator
17. LongUnaryOperator
18. DoubleUnaryOperator

**BinaryOperator (BiFunction that takes and return same type), Takes and returns primitive type:**
19. IntBinaryOperator
20. LongBinaryOperator
21. DoubleBinaryOperator

| Interface            | Purpose                                                         | SAM                                                |
|----------------------|-----------------------------------------------------------------|----------------------------------------------------|
| IntFunction          | Always accepts int type as input, can return any type           | public R apply(int i);                             |
| LongFunction         | Always accepts long type as input, can return any type          | public R apply(long l);                            |
| DoubleFunction       | Always accepts double type as input, can return any type        | public R apply(double d);                          |
| ToIntFunction        | Can take any type as input but always returns int type          | public int applyAsInt(T t);                        |
| ToLongFunction       | Can take any type as input but always returns long type         | public long applyAsLong(T t);                      |
| ToDoubleFunction     | Can take any type as input but always returns double type       | public double applyAsDouble(T t);                  |
| IntToLongFunction    | Always takes int type as input and returns long type            | public long applyAsLong(int i);                    |
| IntToDoubleFunction  | Always takes int type as input and return double type           | public double applyAsDouble(int i);                |
| LongToIntFunction    | Always takes long type as input and return int type             | public int applyAsInt(long l);                     |
| LongToDoubleFunction | Always takes long type as input and return double type          | public double applyAsDouble(long l);               |
| DoubleToIntFunction  | Always takes double type as input and return int type           | public int applyAsInt(double d);                   |
| DoubleToLongFunction | Always takes double type as input and return long type          | public long applyAsLong(double d);                 |
| ToIntBiFunction      | Can take any types as two inputs but always returns int type    | public int applyAsInt(T t, U u);                   |
| ToLongBiFunction     | Can take any types as two inputs but always returns long type   | public long applyAsLong(T t, U u);                 |
| ToDoubleBiFunction   | Can take any types as two inputs but always returns double type | public double applyAsDouble(T t, U u);             |
| IntUnaryOperator     | Input type and Output type both are int                         | public int applyAsInt(int i);                      |
| LongUnaryOperator    | Input type and Output type both are long                        | public long applyAsLong(long l);                   |
| DoubleUnaryOperator  | Input type and Output type both are double                      | public double applyAsDouble(double e);             |
| IntBinaryOperator    | Both the Input types and a Output type are double               | public int applyAsInt(int i, int j);               |
| LongBinaryOperator   | Both the Input types and a Output type are double               | public long applyAsLong(long l1, long l2);         |
| DoubleBinaryOperator | Both the Input types and a Output type are double               | public double applyAsDouble(double d1, double d2); |

**Examples:**

Input type: primitive, Return type: any 
```java
import java.util.function.IntFunction;

/*
 *  Example demonstrating use of IntFunction to find square of a number
 */
class App {
    public static void main(String[] args) {
        //Implementation using Function
        //Function<Integer, Integer> squareFn = i -> i * i;

        //Implementation using IntFunction
        IntFunction<Integer> squareFn = i -> i * i;
        System.out.println(squareFn.apply(5)); //25
    }
}
```

Input type: any, Return type: primitive
```java
import java.util.function.ToIntFunction;

/*
 *  Example demonstrating use of ToIntFunction to find length of a string
 */
class App {
    public static void main(String[] args) {
        //Implementation using Function
        //Function<String,Integer> lengthFn = s -> s.length();

        //Implementation using ToIntFunction
        ToIntFunction<String> lengthFn = s -> s.length();
        System.out.println(lengthFn.applyAsInt("Anshuman")); //8
    }
}
```
Input type: primitive, Return type: primitive
```java
import java.util.function.IntToDoubleFunction;

/*
 *  Example demonstrating use of IntToDoubleFunction to find squre root of a number
 */
class App {
    public static void main(String[] args) {
        //Implementation using Function
        //Function<Integer, Double> sqrtFn = i -> Math.sqrt(i);

        //Implementation using IntToDoubleFunction
        IntToDoubleFunction sqrtFn = i -> Math.sqrt(i);
        System.out.println(sqrtFn.applyAsDouble(9)); //3.0
    }
}
```

## Primitive versions of Consumer

1. IntConsumer
2. LongConsumer
3. DoubleConsumer

**Primitive versions of BiConsumer**
4. ObjIntConsumer\<T>
5. ObjLongConsumer\<T>
6. ObjDoubleConsumer\<T>

| Interface            | Purpose                                                                       | SAM                                    |
|----------------------|-------------------------------------------------------------------------------|----------------------------------------|
| IntConsumer          | Always accepts int type as a input                                            | public void accept(int value);         |
| LongConsumer         | Always accepts long type as a input                                           | public void accept(long value);        |
| DoubleConsumer       | Always accepts double type as a input                                         | public void accept(double value);      |
| ObjIntConsumer<T>    | Always accepts two value as input, one of int type and another of any type    | public void accept(T t, int value);    |
| ObjLongConsumer<T>   | Always accepts two value as input, one of long type and another of any type   | public void accept(T t, long value);   |
| ObjDoubleConsumer<T> | Always accepts two value as input, one of double type and another of any type | public void accept(T t, double value); |

Example:

```java
import java.util.function.IntConsumer;

/*
 *  Example demonstrating use of IntConsumer to print a string
 */
class App {
    public static void main(String[] args) {
        //Implementation using Consumer
        //Consumer<Integer> c = i -> System.out.printf("Square of %d: %d", i, i * i);

        //Implementation using IntConsumer
        IntConsumer c = i -> System.out.printf("Square of %d: %d", i, i * i);
        c.accept(10); //100
    }
}
```

## Primitive versions of Supplier

1. IntSupplier
2. LongSupplier
3. DoubleSupplier
4. BooleanSupplier

| Interface       | Purpose                         | SAM                            |
|-----------------|---------------------------------|--------------------------------|
| IntSupplier     | Always supplies a int value     | public int getAsInt();         |
| LongSupplier    | Always supplies a long value    | public long getAsLong();       |
| DoubleSupplier  | Always supplies a double value  | public double getAsDouble();   |
| BooleanSupplier | Always supplies a boolean value | public boolean getAsBoolean(); |

Ex:

```java
import java.util.function.IntSupplier;

/*
 *  Example demonstrating use of IntSupplier to get a random integer in range 0-9
 */
class App {
    public static void main(String[] args) {
        //Implementation using Supplier
        //Supplier<Integer> randomIntSupplier = () -> (int) (Math.random() * 10);

        //Implementation using IntSupplier
        IntSupplier randomIntSupplier = () -> (int) (Math.random() * 10);
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(randomIntSupplier.getAsInt());
        }
        System.out.println("The 6 digit OTP: " + otp);
    }
}
```
