# Method Reference and Constructor Reference

## Method Reference

- Refer a method of a class
- Functional Interface Single Abstract Method can be mapped to specific methods using :: (double colon) operator.
This is called Method Reference
- The method being mapped to Functional Interface SAM can be either static or instance method.
- Functional Interface SAM and the mapped method must have same argument number and types
except this, remaining things like return type, modifiers etc. need not to match.

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

Ex:<br>
using lambda expression:
```java
class App{
    public static void main(String[] args) {
        Runnable r = () -> {
            for(int i =0;i<=10;i++)
                System.out.println("Child Thread");
        }
        Thread t = new Thread(r);
        t.start();
        for (int i=0; i<=10; i++){
            System.out.println("Main Thread");
        }
    }
}
```
using Method references:
```java
public class App {

    static void staticMethod(){
        for(int i=1;i<=10;i++){
            System.out.println("static method ref: "+i);
        }
    }

    void instanceMethod(){
        for(int i= 1; i<=10; i++){
            System.out.println("instance method ref: "+i);
        }
    }

    public static void main(String[] args) {

        // Thread creation using static method ref.
        // ClassName::staticMethodName
        Thread t1 = new Thread(App::staticMethod);

        App ob = new App();
        // Thread creation using instance method ref.
        // objRef::instanceMethodName
        Thread t2 = new Thread(ob::instanceMethod);

        t1.start();
        t2.start();
    }
}
```
>In the above example Runnable interface run() method is being referred by staticMethod() and instanceMethod() of App class

### Special case of instance method Reference:
#### Reference to an instance method of an arbitrary object of a particular type.
- Reference to an instance method of a arbitrary object supplied later.
- In the following example, `toUpperCase()` is a method from String. 
- The program knows that it can invoke this method on any instance of String, so it can take the reference 
and any object of that type and be guaranteed the method exists.
- This looks very similar to a reference to a static method, 
but a static reference passes the current object into the method, whereas an arbitrary method
 reference invokes a method onto the current object.
- In such cases the instance method of an object that will be provided later can be referred as.
 `ClassName::instanceMethodName`

```java
public class App {

    //using lambda expression
    static Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase();

    //using methodReference
    static Function<String,String> toUpperCaseMethodRefernce = String::toUpperCase;

    public static void main(String[] args) {

        System.out.println(toUpperCaseLambda.apply("java8"));   // JAVA8

        System.out.println(toUpperCaseMethodRefernce.apply("java8"));   // JAVA8
        
    }
}
```
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


## Constructor Reference

- :: (double colon) operator can also be used for Constructor reference.

### Syntax:
`ClassName::new`

Ex:
```java
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
        Interf i2 = Sample::new;
        System.out.println(i2.get("From Constructor ref."));
    }
}

```

>Output: <br>In Constructor
><br>From Lambda Expression<br>
><br>In Constructor
><br>From Constructor ref.

>Note:<br>
> In method and constructor reference compulsorily the argument must match.