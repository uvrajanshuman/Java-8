# Lambda Expressions

Lambda Expression is an anonymous function. i.e: a function that does not have any name.

## Writing Lambda Expression:

Syntax:
```java
    ( Arguments list ) -> { Body of Lambda Expression }
```

1) **Argument list** : There can be zero or more arguments.

2) **Arrow-token** : The arrow token separates the parameters from the body of the lambda expression.

3) **Body of Lambda Expression** : The body of the lambda expression contains the code to be executed.

Examples:

| Java Method                                                                                                          | Equivalent Lambda Expression                              |
|----------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------|
| <pre>public void greet() { <br/> &nbsp;&nbsp;&nbsp;&nbsp; System.out.println("Hello World"); <br/>} </pre>           | <pre>() -> { System.out.println("Hello World"); }</pre>   |
| <pre>public void sum(int a, int b) { <br/> &nbsp;&nbsp;&nbsp;&nbsp; System.out.println(a+b);<br>}</pre>              | <pre>(int a, int b) -> { System.out.println(a+b); }</pre> |
| <pre>public String convertToUpperCase(String s) { <br/> &nbsp;&nbsp;&nbsp;&nbsp; return s.toUpperCase();<br/>}</pre> | <pre>(String s) -> { return s.toUpperCase(); }</pre>      |

**Java Method to find length of the string :**

```java
   public int getLength(String s) {
       return s.length();
   }
```

**Equivalent Lambda Expression :**
```java
   (String s) -> { return s.length(); }
```

### Optimizing Lambda Expressions: 

1. If the lambda expression consists of only one statement, then the curly braces of the code-block are optional.<br>
   i.e:
   ```java
       (String s) -> return s.length();
   ```

2. The type of parameters/arguments can be automatically inferred by the compiler based on context (type inference) so,
   mentioning types of parameters is also optional.<br>
   i.e:
   ```java
       (s) -> return s.length();
   ```

3. The return type can also be inferred by compiler automatically (type inference) so, mentioning return type is also optional.<br>
   But for this the lambda expression must contain only one statement.<br>
   i.e:
   ```java
      (s) -> s.length(); 
   ```

4. If there is only one parameter in Lambda Expression the parameter brackets can also be removed.<br>
   i.e:
   ```java
       s -> s.length();
   ```

| Lambda Expressions                                        | Equivalent Optimized Versions                        |
|-----------------------------------------------------------|------------------------------------------------------|
| <pre>() -> { System.out.println("Hello World"); }</pre>   | <pre>() -> System.out.println("Hello World"); </pre> |
| <pre>(int a, int b) -> { System.out.println(a+b); }</pre> | <pre>(a, b) ->  System.out.println(a+b); </pre>      |
| <pre>(String s) -> { return s.toUpperCase(); }</pre>      | <pre>s -> s.toUpperCase()</pre>                      |

>**_Note:_**<br>
> _Once the lambda expression is written, we can call/invoke that expression just
like normal methods but for this [Functional interface](../functional_interfaces/README.md) instance is required._<br>
>
> _[Functional Interface](../functional_interfaces/README.md) reference is used to refer lambda expression.
> It acts as a type for Lambda Expression.<br>
> The lambda expression gets mapped to the **Single abstract method** of the Functional interface, and the parameter type
> and return type is inferred from its method signature. (type inference)<br>
> It can be invoked by invoking the SAM(Single Abstract Method) of Functional Interface._

---

## Concrete implementation vs Anonymous class implementation vs Lambda Expression implementation of Functional Interface.

**Concrete class implementation:**
```java
@FunctionalInterface
public interface Interf{
    void methodOne();
}

// Concrete implementation
public class Demo implements Interf{
    public void methodOne(){
        System.out.println("Method one execution using simple class implementation");
    }
}

public class App{
  public static void main(String[] args) {
    Interf i = new Demo();
    i.methodOne();
  }
}
```
Output:
```shell
Method one execution using simple class implementation
```

**Anonymous Class implementation:**

```java
@FunctionalInterface
public interface Interf {
    void methodOne();
}

public class App {
    public static void main(String[] args) {
        //Anonymous class
        Interf i = new Interf() {
            @Override
            public void methodOne() {
                System.out.println("Method one execution using anonymous class implementation");
            }
        };
        i.methodOne();
    }
}
```
Output:
```shell
Method one execution using anonymous class implementation
```

**Lambda Expression implementation:**

```java
public interface Interf{
    void methodOne();
}

public class App{
    public static void main(String[] args) {
        // Functional Interface
        Interf i = () -> System.out.println("Method one execution using Lambda expression");
        i.methodOne();
    }
}
```
Output:
```shell
Method one execution using Lambda expression
```

[Example: Different Implementations of an Interface](./Example1.java)

[Example: Different Implementations of Thread](./Example2.java)

## Anonymous inner classes vs Lambda Expressions:

Lambda Expressions can be easily mistaken as replacement for Anonymous class implementation, but it's not true.

- Anonymous inner class can extend a concrete class.
    ```java
    class Test{
        ...
    }
  
    class App{
        public static void main(String[] args) {
            Test t = new Test(){
                ...
            };
        }
    }
    ```

- Anonymous inner class can extend an abstract class.
    ```java
    abstract class Test{
        ...
    } 
    
    class App{
        public static void main(String[] args) {
            Test t = new Test(){
                ...
            };
        }
    }
    ```

- Anonymous inner class can implement an interface containing multiple abstract methods.
    ```java
    interface Test{
        void m1();
        void m2();
        void m3();
    }
    
    class App{
        public static void main(String[] args) {
            Test t = new Test(){
                public void m1(){
                    ...
                }
                public void m2(){
                    ...
                }
                public void m3(){
                    ...
                }
            };
        }
    }
    ```

- Anonymous inner class can implement an interface containing a single abstract method (Functional Interfaces). <br>
  **_Lambda Expression can be used for this case only._**

  ```java
  interface Test{
      void m1();
  }
  
  class App{
      public static void main(String[] args) {
          //using anonymous inner class
          Test t1 = new Test(){
              public void m1(){
                  ...
              }
          };
          //using lambda expression
          Test t2 = () -> {
              ...
          };
      }
  }
  ```

## `this` keyword in Anonymous inner class and Lambda expression 

A lambda expression can be treated as a simple code block while considering the variable scoping. So, all the rules for code blocks 
also apply to the lambda expressions. <br> 
Thus, the scope of a variable declared inside the lambda expression is restricted to the lambda expression only, it can't be accessed outside the lambda expression.
But, the enclosing class variables can be accessed by the lambda expression. 

Inside Lambda expression instance variables can't be declared, whatever variables are declared are simply local variables.

For the Anonymous class `this` keyword refers to the anonymous class object, while for lambda expression `this` keyword 
refers to the enclosing class object;

```java

@FunctionalInterface
interface ValuesWrapper{
    void printValues();
}

public class App {
    String value = "enclosing class instance value";

    public ValuesWrapper getLambdaImpl(){
        ValuesWrapper lambdaImpl = () -> {
            String value = "lambda local value";
            System.out.println("Lambda implementation: ");
            System.out.println("value: "+value);
            System.out.println("this.value: "+this.value);
        };
        return lambdaImpl;
    }

    public ValuesWrapper getAnonymousImpl(){
        ValuesWrapper anonymousImpl = new ValuesWrapper(){
            String value = "anonymous class instance value";
            @Override
            public void printValues() {
                String value = "anonymous class local value";
                System.out.println("Anonymous calss implementation: ");
                System.out.println("value: "+value);
                System.out.println("this.value: "+this.value);
            }
        };
        return anonymousImpl;
    }

    public static void main(String[] args) {
        App app = new App();

        ValuesWrapper lambdaImpl = app.getLambdaImpl();
        lambdaImpl.printValues();

        System.out.println("==============================");

        ValuesWrapper anonymousImpl = app.getAnonymousImpl();
        anonymousImpl.printValues();
    }
}
```
Output: 
```shell
Lambda implementation: 
value: lambda local value
this.value: enclosing class instance value
==============================
Anonymous calss implementation: 
value: anonymous class local value
this.value: anonymous class instance value
```

During compilation the lambda expression gets converted into a private method of the enclosing class. Thats why `this`
keyword refers to the enclosing clas object.

[Example: this reference in Lambda expression and Anonymous class](./Example3.java)

| Anonymous Inner Class                                                                                          | Lambda Expression                                                                                                                                   |
|----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| It's a class without name                                                                                      | It's a method without name (Anonymous function)                                                                                                     |
| Anonymous inner class can extend abstract class as well as concrete class.                                     | Lambda Expression can't extend abstract class or concrete class.                                                                                    |
| Anonymous inner class can implement an interface that contains any number of abstract methods.                 | Lambda Expression can be used only for an interface which contains single abstract method (Functional Interface).                                   |
| Inside anonymous inner class we can declare instance variables.                                                | Inside Lambda expression we can't declare instance variables, whatever the variables are declared simply acts as local variables.                   |
| Anonymous inner classes can be instantiated.                                                                   | Lambda expressions can't be instantiated.                                                                                                           |
| Inside Anonymous inner class "this" always refers to current inner class object not outer class object.        | Inside Lambda expressions "this" always refers to current outer class object; i.e.- enclosing class object.                                         |
| At the time of compilation a separate .class file is generated for Anonymous inner class. (OuterClass$1.class) | At the time of compilation no extra .class file will be generated for lambda expression. It is simply converted into private method of outer class. |

A lambda expression can't define any new scope as an anonymous inner class does, so we can't declare a local
variable with the same name which is already declared in the enclosing scope of a lambda expression.

>Conclusion:<br>
> Lambda Expressions and Annonymous inner classes are not same.

## Lambdas and Local Variables (Closure)

The effectively final variables refer to local variables that are not declared final explicitly but can't be changed once initialized. <br>
A lambda expression can use a local variable in outer scopes only if they are effectively final. such lambdas are referred as capturing lambdas. <br>
They can capture **static variables**, **instance variables**, and **local variables**, but only **local variables** must be final or effectively final.

```java
public class ClosureExample {
    public static void main(String[] args) {
        int x = 10; // Local variable

        // Lambda expression
        Runnable lambda = () -> {
            // Attempting to modify the local variable will result in a compilation error
            // x = 20; // Uncommenting this line will cause a compile-time error
            System.out.println("Value of x: " + x);
        };

        // Executing the lambda
        lambda.run();
    }
}
```

[Example: Closure](./Example4.java)

**Reason of prohibited modification :**
When a lambda expression is created, it makes a copy of any variables from the surrounding scope that it refers to. 
If these variables were allowed to be modified, the lambda expression would hold outdated values from the copy, leading to inconsistencies. 
Conversely, if the copy within the lambda expression is modified, the value in the enclosing scope would remain unchanged, resulting in an inconsistency as well. 

Another consideration is that when you pass around a lambda expression and it escapes to be executed by a different thread 
while the current thread is updating the same local variable, concurrency issues can arise.

To prevent such situations, the modification of local variables refereed by lambda expressions prohibited.

**Customized sorting using lambdas**:<br>
[Example: Custom sorting of List using Lambda expression](./custom_sorting/ListCustomSortingExample.java) <br>
[Example: Custom sorting of Set using Lambda expression](./custom_sorting/SetCustomSortingExample.java) <br>
[Example: Custom sorting of Map using Lambda expression](./custom_sorting/MapCustomSortingExample.java) <br>
[Example: Custom sorting of a class objects using Lambda expression](./custom_sorting/CustomObjectCustomizedSortingExample.java)
