# Functional Interfaces

An interface containing a single abstract method (SAM).

Ex:
- `Runnable` : contains only `run()` method.
- `Comparable` : contains only `compareTo()` method

The interface in addition to a single abstract method can have any number of default and static methods. <br> 
The restriction is only for a single abstract method.

**Functional Interface**
```java
interface Interf{
    //SAM(Single Abstract Method)
    public abstract void m1();
    
    //can have one or more default methods
    default void m2(){
        System.out.println("Hello");
    }
    
    //can have one or more static methods
    static void m3(){
        System.out.println("World");
    }
}
 ```

**Not a Functional Interface**
```java
interface Interf{
    //more than one abstract method
    public abstract void m1();
    public abstract void m2();
}
```

```java
interface Interf{
    //no abstract method
}
```

## `@FunctionalInterface`

In Java 8, `@FunctionalInterface` annotation was introduced to specify functional interfaces.

Used to explicitly indicate an interface is Functional interface. 

This helps to enforce compile time checking on presence of exactly one abstract method and prevents accidental addition of additional abstract methods in a declared Functional Interface.
<br>
Ex:
```java
@FunctionalInterface
interface Interf{
    //Single Abstract Method
    void m1();
}
```

- Inside a `@FunctionalInterface` annotated interface, there can be only one abstract method, if more than one abstract method is defined then
  compiler throws compilation error:
  > unexpected @FunctionalInterface annotation.<br>Multiple non-overriding abstract methods present in interface InterfaceName

- Inside a `@FunctionalInterface` annotated interface, it is mandatory to declare one abstract method. If not
  declared compiler throws compilation error:
  > unexpected @FunctionalInterface annotation.<br> no abstract method found in interface InterfaceName.

So, `@FunctionalInterface` enables compile time checking for Functional interfaces and makes the code more robust.<br>
It basically acts as a contract for an interface to follow the Single Abstract Method Rule.

## Functional Interface with respect to Inheritance:

In case an interface extends a Functional Interface. And the child interface doesn't contain any abstract method then the
child interface is also a Functional interface. (As it will inherit the Single Abstract Method)
  <br>
  Ex:
  ```java
  @FunctionalInterface
  interface A{
      public void m1();
  }
  
  @FunctionalInterface
  interface B extends A{
      
  }
  ```

The child interface can contain exactly same abstract method as parent, and it would still remain Functional Interface (override parent's declaration).
<br>
Ex:
  ```java
  @FunctionalInterface
  interface A{
      public void m1();
  }
  
  @FunctionalInterface
  interface B extends A{
      public void m1();
  }
  ```

In the child interface we can't define any new abstract method if `@FunctionalInterface`
is applied to it else it will throw compilation error.
  <br>
  Ex:
  ```java
  @FunctionalInterface
  interface A{
    public void m1();
  }
  
  @FunctionalInterface
  interface B extends A{
      //compilation error
      public void m2();
  }
  ```
  >compilation error: <br> Unexpected @FunctionalInterface annotation. <br>
  > multiple non-overriding abstract methods found in interface B

- But if **_`@FunctionalInterface`_** is dropped, new abstract methods can be defined in
  the child interface; but the child interface won't be Functional Interface anymore.
  <br>
  Ex:
  ```java
    @FunctionalInterface
    interface A{
      public void m1();
    }
  
    //normal interface not Functional Interface.
    interface B extends A{
        //no compilation error
        //new abstract method
        public void m2();
    }
    ```

<br>

> **_Note:_** <br>
> _Functional Interfaces can be used to invoke Lambda Expressions.
> It acts as a type for Lambda Expression, thus can refer a Lambda Expression. And the Single Abstract Method is used for the invokation._
