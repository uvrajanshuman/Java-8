# Lambda Expression:
- Lambda Expression is an anonymous function. i.e- the function which does not 
have any name, return type and access modifiers.

Java Method to find length of a string:
```java
    public int length(String s){
        return s.length();
    }
```

Equivalent Lambda Expression
```java
    (String s) -> { return s.length(); }
```

### Optimizing Lambda Expressions

1. If the lambda expression consists of only one line then curly braces are optional.

i.e-
```java
    (String s) -> return s.length();;
```

2. If the type of parameters can be decided by the compiler automatically based on
context (type inference), then mentioning types of parameters is also optional

i.e-
```java
    (s) -> return s.length();;
```

3. If the return type can also be inferred by compiler automatically, then mentioning return type is
also optional. But for this the lambda expression must contain only one statement.

i.e-
```java
    (s) -> s.length();
```

4. If there is only one parameter in Lambda Expression the parameter brackets
can also be removed.

i.e.-
```java
    s -> s.length()
```

### Note:
> Once the lambda expression is written, we can call that expression just
like normal methods but for this Functional interfaces are required.

> Functional Interface reference is used to refer lambda expression. It provides type for lambda expression.
> And lambda expression can be invoked by invoking the SAM(Single Abstract Method) of Functional Interface.

---

Example: 
- Without Lambda Expression and Anonymous class:

```java
@FunctionalInterface
public interface Interf{
    void methodOne();
}

// implementation of interface
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

- With Anonymous Class:

```java

@FunctionalInterface
public interface Interf {
    void methodOne();
}

public class App {
    public static void main(String[] args) {
        Interf i = new Interf() {
            @Override
            public void methodOne() {
                System.out.println("Method one execution using anonymous class implementation");
            }
        }
    }
}
```

- With Lambda Expression: 

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

> Functional Interface reference is used to refer lambda expression.<br>
> And the lambda expression is invoked using the single abstract method of the interface.<br>
> The lambda expression is mapped to the single abstract method of functional interface and 
> the parameter types and return types is inferred from its signature.

---
# Anonymous inner classes vs Lambda Expressions:

- Anonymous inner class can exted concrete class
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
  
- Anonymous inner class can extend abstract class
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

- Anonymous inner class can implement an interface containing single abstract method. <br>
Lambda Expression can also be used for this case only.

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

| Anonymous Inner Class                                                                                          | Lambda Expression                                                                                                                                  |
|----------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| It's a class without name                                                                                      | It's a method without name (anonymous function)                                                                                                    |
| Anonymous inner class can extend abstract as well as concrete classes                                          | Lambda Expression can't extend abstract and concrete classes                                                                                       |
| Anonymous inner class can implement an interface that contains any number of abstract methods.                 | Lambda Expression can implement an interface which contains single abstract method (Functional Interface                                           |
| Inside anonymous inner class we can declare instance variables                                                 | Inside Lambda expression we can't declare instance variables, whatever the variables are declared simply acts as local variables.                  |
| Anonymous inner classes can be instantiated.                                                                   | Lambda expressions can't be instantiated.                                                                                                          |
| Inside Anonymous inner class "this" always refers to current inner class object not outer class object         | Inside Lambda expressions "this" always refers to current outer class object; i.e.- enclosing class object.                                        |
| At the time of compilation a seperate .class file is generated for Anonymous inner class. (OuterClass$1.class) | At the time of compilation no extra .class file will be generated for lambda expression. It is simply converted into private method of outer class |

>Conclusion:<br>
> Lambda Expressions and Annonymous inner classes are not same.

- Inside Lambda expression instance variables can't be declared 
- whatever variables are declared in Lambda expression are simply local variables.
- within Lambda expression "this" keyword refers to outer class object reference (i.e.- the enclosing class reference where lambda expression is declared.)

```java
@FunctionalInterface
interface Interf{
    void m1();
}

class Test{
    int x = 777;
    public void m2(){
        
        Interf i = () -> {
            int x = 888;
            System.out.println(x); // 888
            System.out.println(this.x); // 777
        };
        
        i.m1();
    }

  public static void main(String[] args) {
    Test t = new Test();
    t.m2();
  }
}
```
> output: <br>
> 888<br> 777

- From Lambda expression the enclosing class variables and enclosing method variables can be accessed directly.
- The local variables (enclosing method variables) referenced from Lambda expression are implicitly final, hence can't be re-assigned.

```java
interface Interf{
    void m1();
}

class Test{
    // instance variable
    int x = 10;
    public void m2(){
        // local variable
      final int y = 20;
      Interf i = () -> {
        System.out.println(x); //10
        System.out.println(y); //20
        x = 30;
        //y = 40; //Compilation error
      };
      i.m1();
//      y = 40;
    }
    
    public static void main(String[] args) {
        Test t = new Test();
        t.m2();
    }
}
```
