# Introduction to Java 8 

- Java 8 introduced functional programming paradigms, enabling developers to write code in a more concise and declarative manner.
- Java 8 introduced a more declarative approach to programming, enabling developers to focus on what needs to be done rather than how to do it. 
This declarative programming style is primarily facilitated by the Stream API and lambda expressions.

<details>
  <summary><b> Table of Contents:</b> click to expand/collapse</summary>

1. [Functional Interfaces](./functional_interfaces/README.md)
2. [Lambda Expressions](./lambda_expressions/README.md)
3. [Predefined Functional Interfaces](./predefined_functional_interfaces/README.md)
4. [Method References and Constructor References](./method_reference_and_constructor_reference/README.md)
5. [Stream API](./streams/README.md)
6. [Default and Static Methods in Interfaces]()
7. [Optional](./optional/README.md)
8. [Comparator Enhancements](./comparator_enhancements/README.md)
9. [Date and Time API]()

</details>

## Declarative Programming vs. Imperative Programming:

### Imperative Programming:
Imperative programming is the traditional programming paradigm where code consists of a sequence of statements that explicitly define 
how to achieve a task. <br>
The focus is on providing step-by-step instructions to the computer on how to execute a particular task. 

**Example: To find sum of the first 10 natural numbers using imperative approach**
```java
public class ImperativeExample {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
```

### Declarative Programming:
Declarative programming, on the other hand, emphasizes what needs to be achieved rather than how to achieve it. <br>
It focuses on expressing the desired outcome rather than providing detailed instructions.

This approach is analogous to SQL (Structured Query Language) and allows developers to write more concise and expressive code. 

**Example: To find sum of the first 10 natural numbers using declarative approach**
```java
import java.util.stream.IntStream;

public class DeclarativeExample {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum: " + sum);
    }
}
```


## Enhancements in Java 8:

### [1. Functional Interfaces:](./functional_interfaces/README.md)
Java 8 introduced functional interfaces, which are interfaces with a single abstract method. <br>
Functional interfaces form the foundation of lambda expressions and enable developers to leverage the power of functional programming.

[Functional Interfaces](./functional_interfaces/README.md)

   ### [Predefined Functional Interfaces: ](./predefined_functional_interfaces/README.md)
   Java 8 introduces several predefined functional interfaces, that enables the functional programming.
   
   [Predefined Functional Interfaces](./predefined_functional_interfaces/README.md)

### [2. Lambda Expressions:](./lambda_expressions/README.md)
   Java 8 introduced lambda expressions, allowing developers to write more concise and functional code. <br>
   Lambdas enable the use of functional interfaces and facilitate functional programming practices.

[Lambda Expressions](./lambda_expressions/README.md)

### [3. Method References and Constructor References:](./method_reference_and_constructor_reference)
Method references and Constructor references provide a concise way to refer to methods or constructors using their names. <br>
They can be used in conjunction with lambda expressions to further simplify code.

[Method References and Constructor References](./method_reference_and_constructor_reference)

### [4. Stream API:](./streams/README.md)
   The Stream API provides a powerful and efficient way to process collections of objects. 
   It allows developers to perform operations such as filtering, mapping, and reducing on collections in a declarative manner.
   
   [Stream API](./streams/README.md)

   #### Parallel and Asynchronous Programming: 
   Java 8 introduced features for efficient parallel and asynchronous programming. <br>
   The Stream API supports parallel execution of stream operations, harnessing the power of multi-core processors. 

   [Parallel Streams](./streams/parallel_streams/README.md)

### [5. Default and Static Methods in Interfaces:]()
   Java 8 introduced the ability to define default and static methods in interfaces. <br>
   Default methods provide a way to add new functionality to interfaces without breaking existing implementations, 
   while static methods allow interfaces to have utility methods.

### [6. Optional Class:](./optional/README.md)
   The Optional class provides a way to represent values that may or may not be present. <br>
   It helps eliminate null pointer exceptions and encourages more robust and defensive programming practices.

[Optional](./optional/README.md)

### [7. Comparator Enhancements:](./comparator_enhancements/README.md)
Java 8 enhanced the Comparator interface with several default and static methods. <br>
These methods include comparing, reversed, and thenComparing, which simplify the creation and composition of comparators.
The Comparator interface now offers more flexibility and readability when sorting and comparing objects.

[Comparator Enhancements](./comparator_enhancements/README.md)

### [8. Date and Time API:]()
   Java 8 introduced a new Date and Time API that addresses many of the shortcomings of the old java.util.Date and java.util.Calendar classes.<br>
   The new API is more intuitive, immutable, and thread-safe.


### Conclusion:
Java 8 brought a significant evolution to the Java programming language. With the introduction of functional programming paradigms, 
developers can now write more concise, expressive, and declarative code. <br>
The new features, such as lambda expressions, the Stream API, and the Optional class, provide powerful tools to enhance productivity and maintainability. 
