# Predefined Functional Interfaces

Java 1.8 onwards defines few Pre-defined Functional interfaces to deal with
functional programming using lambda expressions and method references.

These Functional Interfaces are:
- [Predicate](./predicate/README.md)
- [Function](./function/README.md)
    - [UnaryOperator](./function/README.md#unaryoperatort)
- [Consumer](./consumer/README.md)
- [Supplier](./supplier/README.md)
- [Bi-Functional Interfaces](./bi_functional_interfaces/README.md)
    - [BiPredicate](./bi_functional_interfaces/bipredicate/README.md)
    - [BiFunction](./bi_functional_interfaces/bifunction/README.md)
        - [BinaryOperator](./bi_functional_interfaces/bifunction/README.md#binaryoperatort)
    - [BiConsumer](./bi_functional_interfaces/biconsumer/README.md)
- [Primitive Type Functional Interfaces](./primitivetype/README.md) (to work with primitive types.)

## Comparison b/w Predicate, Function, Consumer and Supplier

| Property                     | Predicate                                                    | Function                                                                | Consumer                                                                          | Supplier                                                     |
|------------------------------|--------------------------------------------------------------|-------------------------------------------------------------------------|-----------------------------------------------------------------------------------|--------------------------------------------------------------|
| Purpose                      | To take some input and perform some conditional checks       | To take some input and perform required operation and return the result | To consume some input and perform required operation. It doesn't returns anything | To supply some value based on requirements.                  |
| Interface declaration        | <pre>interface Predicate\<T\>{ <br> ... <br> ... <br>}</pre> | <pre>interface Function\<T,R\>{ <br> ... <br> ... <br> }</pre>          | <pre>interface Consumer\<T\>{ <br> ... <br> ... <br> }</pre>                      | <pre>interface Supplier\<R\>{ <br> ... <br> ... <br> }</pre> |
| SAM (Single Abstract Method) | `public boolean test(T t);`                                  | `public R apply(T t);`                                                  | `public void accept(T t);`                                                        | `public R get();`                                            |
| Default Method(s)            | `and()`, `or()`, `negate()`                                  | `andThen()`, `compose()`                                                | `andThen()`                                                                       | -                                                            |
| Static Method(s)             | `isEqual()`                                                  | `identity()`                                                            | -                                                                                 |                                                              |

---

## Two-Argument (Bi) Functional Interfaces

Normal Functional Interfaces (Predicate, Function, Consumer) can accept only one input argument.
But, sometimes Programming requirement is to accept two input arguments, for this Bi Functional Interfaces are present.

These are same as One Argument Functional Interfaces in functionality; these just accept two input parameters instead of one.<br>
Following are the Bi Functional Interfaces present in `java.util.function` package.
1. BiPredicate
2. BiFunction
3. BiConsumer

### Comparison b/w One argument and Two arguments Functional Interfaces

| One Argument Functional Interface                                                                                                                                                                                                                                                                                                                                  | Two Argumet Functional Interface                                                                                                                                                                                                                                                                                        |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <pre>@FunctionalInterface <br>interface Predicate\<T\>{ <br>&nbsp;&nbsp;&nbsp;public boolean test(T t); <br>&nbsp;&nbsp;&nbsp;default Predicate and(Predicate p){...} <br>&nbsp;&nbsp;&nbsp;default Predicate or(Predicate p){...} <br>&nbsp;&nbsp;&nbsp;default Predicate negate(){...} <br>&nbsp;&nbsp;&nbsp;static Predicate isEqual(Object o){...} <br>}</pre> | <pre>@FunctionalInterface <br>interface BiPredicate\<T,U\>{ <br>&nbsp;&nbsp;&nbsp;public boolean test(T t, U u); <br>&nbsp;&nbsp;&nbsp;default BiPredicate and(BiPredicate p){...} <br>&nbsp;&nbsp;&nbsp;default BiPredicate or(BiPredicate p){...} <br>&nbsp;&nbsp;&nbsp;default BiPredicate negate(){...} <br>}</pre> |
| <pre>@FunctionalInterface <br>interface Function\<T,R\>{ <br>&nbsp;&nbsp;&nbsp;public R apply(T t); <br>&nbsp;&nbsp;&nbsp;default Function andThen(Function f){...} <br>&nbsp;&nbsp;&nbsp;default Function compose(Function f){...} <br>&nbsp;&nbsp;&nbsp;static Function identity() <br>}</pre>                                                                   | <pre>@FunctionalInterface <br>interface BiFunction\<T,U,R\>{ <br>&nbsp;&nbsp;&nbsp;public R apply(T t, U u); <br>&nbsp;&nbsp;&nbsp;default BiFunction andThen(Function f){...} <br>}</pre>                                                                                                                              |
| <pre>@FunctionalInterface <br>interface Consumer\<T\>{ <br>&nbsp;&nbsp;&nbsp;public void accept(T t); <br>&nbsp;&nbsp;&nbsp;default Consumer andThen(Consumer c){...} <br>}</pre>                                                                                                                                                                                  | <pre>@FunctionalInterface <br>interface BiConsumer\<T,U\>{ <br>&nbsp;&nbsp;&nbsp;public void accept(T t, U u); <br>&nbsp;&nbsp;&nbsp;default BiConsumer andThen(BiConsumer c){...} <br>}</pre>                                                                                                                          |

----
## Primitive type Functional Interfaces

In case of normal Predefined Functional Interfaces the input and return types are always Object types.

If Primitive types are passed to them, the Primitives will be converted to Object types (Autoboxing) and that Object types will further be converted to Primitive types (Autounboxing) for processing,
and finally the result (Primitive type) may finally be converted to Object type (Autoboxing). <br>
This to and fro conversion causes performance issues.

To overcome this issue Primitive functional interfaces are present to work on Primitive types.

### Primitive versions of Predicate

1. IntPredicate
2. LongPredicate
3. DoublePredicate

| Interface       | Purpose                                   | SAM                              |
|-----------------|-------------------------------------------|----------------------------------|
| IntPredicate    | Always accepts input value of int type    | `public boolean test(int i);`    |
| LongPredicate   | Always accepts input value of long type   | `public boolean test(long l);`   |
| DoublePredicate | Always accepts input value of double type | `public boolean test(double d);` |


### Primitive versions of Function

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

| Interface            | Purpose                                                         | SAM                                                  |
|----------------------|-----------------------------------------------------------------|------------------------------------------------------|
| IntFunction          | Always accepts int type as input, can return any type           | `public R apply(int i);`                             |
| LongFunction         | Always accepts long type as input, can return any type          | `public R apply(long l);`                            |
| DoubleFunction       | Always accepts double type as input, can return any type        | `public R apply(double d);`                          |
| ToIntFunction        | Can take any type as input but always returns int type          | `public int applyAsInt(T t);`                        |
| ToLongFunction       | Can take any type as input but always returns long type         | `public long applyAsLong(T t);`                      |
| ToDoubleFunction     | Can take any type as input but always returns double type       | `public double applyAsDouble(T t);`                  |
| IntToLongFunction    | Always takes int type as input and returns long type            | `public long applyAsLong(int i);`                    |
| IntToDoubleFunction  | Always takes int type as input and return double type           | `public double applyAsDouble(int i);`                |
| LongToIntFunction    | Always takes long type as input and return int type             | `public int applyAsInt(long l);`                     |
| LongToDoubleFunction | Always takes long type as input and return double type          | `public double applyAsDouble(long l);`               |
| DoubleToIntFunction  | Always takes double type as input and return int type           | `public int applyAsInt(double d);`                   |
| DoubleToLongFunction | Always takes double type as input and return long type          | `public long applyAsLong(double d);`                 |
| ToIntBiFunction      | Can take any types as two inputs but always returns int type    | `public int applyAsInt(T t, U u);`                   |
| ToLongBiFunction     | Can take any types as two inputs but always returns long type   | `public long applyAsLong(T t, U u);`                 |
| ToDoubleBiFunction   | Can take any types as two inputs but always returns double type | `public double applyAsDouble(T t, U u);`             |
| IntUnaryOperator     | Input type and Output type both are int                         | `public int applyAsInt(int i);`                      |
| LongUnaryOperator    | Input type and Output type both are long                        | `public long applyAsLong(long l);`                   |
| DoubleUnaryOperator  | Input type and Output type both are double                      | `public double applyAsDouble(double e);`             |
| IntBinaryOperator    | Both the Input types and a Output type are double               | `public int applyAsInt(int i, int j);`               |
| LongBinaryOperator   | Both the Input types and a Output type are double               | `public long applyAsLong(long l1, long l2);`         |
| DoubleBinaryOperator | Both the Input types and a Output type are double               | `public double applyAsDouble(double d1, double d2);` |

### Primitive versions of Consumer

1. IntConsumer
2. LongConsumer
3. DoubleConsumer

**Primitive version of BiConsumer**
4. ObjIntConsumer<T>
5. ObjLongConsumer<T>
6. ObjDoubleConsumer<T>

| Interface            | Purpose                                                                       | SAM                                      |
|----------------------|-------------------------------------------------------------------------------|------------------------------------------|
| IntConsumer          | Always accepts int type as a input                                            | `public void accept(int value);`         |
| LongConsumer         | Always accepts long type as a input                                           | `public void accept(long value);`        |
| DoubleConsumer       | Always accepts double type as a input                                         | `public void accept(double value);`      |
| ObjIntConsumer<T>    | Always accepts two value as input, one of int type and another of any type    | `public void accept(T t, int value);`    |
| ObjLongConsumer<T>   | Always accepts two value as input, one of long type and another of any type   | `public void accept(T t, long value);`   |
| ObjDoubleConsumer<T> | Always accepts two value as input, one of double type and another of any type | `public void accept(T t, double value);` |

### Primitive versions of Supplier

1. IntSupplier
2. LongSupplier
3. DoubleSupplier
4. BooleanSupplier

| Interface       | Purpose                         | SAM                              |
|-----------------|---------------------------------|----------------------------------|
| IntSupplier     | Always supplies a int value     | `public int getAsInt();`         |
| LongSupplier    | Always supplies a long value    | `public long getAsLong();`       |
| DoubleSupplier  | Always supplies a double value  | `public double getAsDouble();`   |
| BooleanSupplier | Always supplies a boolean value | `public boolean getAsBoolean();` |