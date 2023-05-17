# Method Reference and Constructor Reference

Method reference and Constructor reference provides a concise way to refer to existing methods or constructors as lambda expressions.

## Method Reference: Refer method of a class

Using the Method Reference the Single Abstract Method of Functional Interface can be mapped to a specific pre-existing method using :: (double colon) operator.

Sometimes, a lambda expression only calls an existing method. In those cases, we can simply refer the existing method by name.<br>
A method reference is the shorthand syntax for a lambda expression that contains just one method call.

The method being mapped to Functional Interface SAM can be either static or instance method.

Functional Interface SAM and the mapped method must have same number and types of argument,
the return type can be a subtype of the specified return type (SAM return type), or a type that can be implicitly converted to the expected return type.
The remaining things like modifiers etc. need not to match.

[Example: Method reference with different but compatible return type](./MethodReferenceDifferentReturnTypeExample.java)

### Method Reference is of three types
1. Reference to a static method
2. Reference to an instance method. (Reference to an instance method of a specific object)
3. Reference to an instance method of an arbitrary object of a particular type.
   (Reference to an instance method of a arbitrary object supplied later)

| Method Reference                                                            | Explanation                                                                          | Syntax                                                |
|-----------------------------------------------------------------------------|--------------------------------------------------------------------------------------|-------------------------------------------------------|
| Reference to a static method                                                | Reference to static method of a class                                                | `ClassName::methodName`                               |
| Reference to an instance method                                             | Reference to an instance method of a specific object                                 | `objRef::methodName`                                  |
| Reference to an instance method of an arbitrary object of a particular type | Reference to an instance method of a arbitrary object supplied later                 | `ClassName::methodName`                               |


- Functional Interface can refer Lambda Expressions and Functional Interface can also refer method reference.
- So, Lambda Expression can be replaced with method reference. Method reference is alternative syntax to lambda expression.

#### Reference to a static method

Lambda expression like:
```java
// If a lambda expression just call a static method of a class
(args) -> Class.staticMethod(args)
```
Can be replaced with following method reference: 
```java
// Shorthand if a lambda expression just call a static method of a class
Class::staticMethod
```

**Example: Lambda expression and Equivalent static method reference**
```java
import java.util.function.Predicate;

/*
 * Example demonstrating use of static method reference       
 */
public class App {
    public static void main(String[] args) {
        // Lambda expression
        Predicate<String> lambda = s -> s.isEmpty();
        System.out.println("Lambda Result: " + lambda.test("")); 

        // Equivalent static method reference
        Predicate<String> methodRef = String::isEmpty;
        System.out.println("Method Reference Result: " + methodRef.test("")); 
    }
}
```
Output:
```shell
Lambda Result: true
Method Reference Result: true
```

#### Reference to an instance method

Lambda expression is like:
```java
// If a lambda expression just call a default method of an object
(args) -> obj.instanceMethod(args)
```
Can be replaced with following method reference:
```java
//Shorthand if a lambda expression just call a default method of an object
obj::instanceMethod
```

**Example: Lambda expression and Equivalent instance method reference**
```java
import java.util.function.Predicate;

/*
 * Example demonstrating use of static method reference
 */
public class App {
    // instance method (can be mapped to SAM of Predicate)
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        // instance of current class
        App app = new App();

        // Lambda expression
        Predicate<Integer> lambda = n -> example.isEven(n);
        System.out.println("Lambda Result: " + lambda.test(6)); // Output: 

        // Equivalent instance method reference
        Predicate<Integer> methodRef = app::isEven;
        System.out.println("Method Reference Result: " + methodRef.test(6)); // Output: 
    }
}
```
Output:
```shell
Lambda Result: true
Method Reference Result: true
```

#### Reference to an instance method of an arbitrary object of a particular type

Lambda expression like:
```java
// If a lambda expression just call an instance method of a ObjectType
(obj, args) -> obj.instanceMethod(args)
```
Can be replaced with following method reference:
```java
// Shorthand if a lambda expression just call an instance method of a ObjectType
ObjectType::instanceMethod
```

```java
public class App {

    public static void main(String[] args) {
        // Lambda expression
        Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase();
        // Equivalent lambda expression
        Function<String,String> toUpperCaseMethodRefernce = String::toUpperCase;
        
        System.out.println("Lambda Result: "+ toUpperCaseLambda.apply("java8"));   // JAVA8

        System.out.println("Method Reference Result: "+toUpperCaseMethodRefernce.apply("java8"));   // JAVA8
    }
}
```
Output:
```shell
Lambda Result: JAVA8
Method Reference Result: JAVA8
```

**Explanation:**<br>
In this example, `toUpperCase()` is an instance method from String.<br>
The program knows that it can invoke this method on any instance of String, so it can take the reference
and any object of that type and be guaranteed the method exists.

This looks very similar to a reference to a static method, but a static reference passes the current object into the method, 
whereas an arbitrary method reference invokes a method onto the current object.

>The difference between the two types of instance method reference is interesting but a bit confusing.<br>
>Sometimes, you’ll need to pass something in, other times, the usage of the lambda will supply it for you.

>In this case you want to call a method that is an instance method of a parameter passed to the function.<br>
> With a lambda, there is no problem because you can reference the parameter variable, like this:<br>
>`(String someString) -> someString.toLowerCase();`<br>
>However, since there is no explicit parameter variable in a method reference, the syntax used instead is:<br>
>`String::toLowerCase;`<br>
>The compiler takes the "particular type" (String) to reference the functional method (toLowerCase)
> contained in an "arbitrary object" (the object passed in the parameter). <br>
> The term "arbitrary object" is used because the actual object passed in the parameter could be different
> each time the method reference is executed.<br>

```java
    String[] stringArray = { "Barbara", "James", "Mary", "John","Patricia", "Robert", "Michael", "Linda", "George" };
    Arrays.sort(stringArray, String::compareToIgnoreCase);
```

> Another Example:   for the lambda expression <br>
> `(String a, String b) -> a.compareToIgnoreCase(b)`<br>
>It can be replaced with method reference such as <br>
>`String::compareToIgnoreCase`<br>
> The compiler infers that the instance on which the method will be called is the first parameter of the 
> functional interface's method 

[Example: Method Reference](./MethodReferenceExample.java)<br>
[Example 2: Method Reference](./MethodReferenceExample2.java)<br>
[Example 3: Method Reference](./MethodReferenceExample3.java)

## Constructor Reference

:: (double colon) operator can also be used for Constructor reference.

### Syntax:
`ClassName::new`

Example:
```java
/*
 * Example domonstrating the use of constructor reference       
 */
class Sample{
    private String s;
    
    Sample(String s){
        System.out.println("In Constructor");
        this.s = s;
    }
    
    public String toString(){
        return this.s;
    }
}

@FunctionalInterface
interface Interf{
    public Sample get(String s);
}

public class App {
    public static void main(String[] args) {
        //using lambda expression
        Interf i1 = s -> new Sample(s);
        System.out.println(i1.get("From Lambda Expression"));
        System.out.println();
        //using constructor reference
       // maps the get() method of Interf to one-arg constructor of Sample
        Interf i2 = Sample::new;
        System.out.println(i2.get("From Constructor ref."));
    }
}

```

Output:
```shell
In Constructor
From Lambda Expression<br>
In Constructor
From Constructor ref.
```

[Example: Constructor Reference](./ConstructorReferenceExample.java)<br>
[Example: Constructor Reference](./ConstructorReferenceExample2.java)