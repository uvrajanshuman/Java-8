# Primitive Type Functional Interfaces

## Need:

>Autoboxing: Automatic Conversion from Primitive type to Object by compiler.<br>
>Autounboxing: Automatic Conversion from Object type to Primitive by compiler.<br>
>In case of generics, the type parameters is always Object type and can never ber primitive type.<br>
>Ex: ArrayList\<Integer\> list = new ArrayList<> (); //valid <br>
>    ~~ArrayList\<int\> list = new ArrayList<>();~~ //invalid

- In case of normal Predefined Functional Interfaces the input and return types are always Object types.
- If Primitive types are passed to them,the Primitives will be converted to Object types (Autoboxing) and that Object types may further be converted to Primitive types (Autounboxing), which causes performance issues.
- So, Multiple Autoboxing and Autounboxing creates performance issues.
Ex:

```java
import java.util.function.Predicate;

class App {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i%2==0;
        // int --> p.test(Integer) --> int%2==0 --> boolean 
        System.out.println(p.test(10)); // true
    }
}
```

>In the above multiple autoboxing and autounboxing happens causing performance issues.<br>
>To overcome this problem Primitive type functional interfaces were introduced, which always take primitive type as input
> and return primitive type as result.<br.
> Hence, autoboxing and autounboxing won't be required leading to improved performance.

Above Ex. using Primitive type functional interface:

```java
import java.util.function.IntPredicate;

class App {
    public static void main(String[] args) {
        IntPredicate p = i -> i%2==0;
        System.out.println(p.test(10)); // true
    }
}
```


>Primitive versions of Predicate
1. IntPredicate
2. LongPredicate
3. DoublePredicate

| Interface       | Purpose                                   | SAM                            |
|-----------------|-------------------------------------------|--------------------------------|
| IntPredicate    | Always accepts input value of int type    | public boolean test(int i);    |
| LongPredicate   | Always accepts input value of long type   | public boolean test(long l);   |
| DoublePredicate | Always accepts input value of double type | public boolean test(double d); |


>Primitive versions of Function
1. IntFunction
2. LongFunction
3. DoubleFunction
4. ToIntFunction
5. ToLongFunction
6. ToDoubleFunction
7. IntToLongFunction
8. IntToDoubleFunction
9. LongToIntFunction
10. LongToDoubleFunction
11. DoubleToIntFunction
12. DoubleToLongFunction
13. ToIntBiFunction
14. ToLongBiFunction
15. ToDoubleBiFunction
16. IntUnaryOperator
17. LongUnaryOperator
18. DoubleUnaryOperator
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

>Primitive versions of Consumer
1. IntConsumer
2. LongConsumer
3. DoubleConsumer
4. ObjIntConsumer<T>
5. ObjLongConsumer<T>
6. ObjDoubleConsumer<T>

| Interface            | Purpose                                                                       | SAM                                    |
|----------------------|-------------------------------------------------------------------------------|----------------------------------------|
| IntConsumer          | Always accepts int type as a input                                            | public void accept(int value);         |
| LongConsumer         | Always accepts long type as a input                                           | public void accept(long value);        |
| DoubleConsumer       | Always accepts double type as a input                                         | public void accept(double value);      |
| ObjIntConsumer<T>    | Always accepts two value as input, one of int type and another of any type    | public void accept(T t, int value);    |
| ObjLongConsumer<T>   | Always accepts two value as input, one of long type and another of any type   | public void accept(T t, long value);   |
| ObjDoubleConsumer<T> | Always accepts two value as input, one of double type and another of any type | public void accept(T t, double value); |

>Primitive versions of Supplier

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
