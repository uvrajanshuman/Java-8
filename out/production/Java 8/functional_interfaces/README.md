# Functional Interfaces

- An interface containing single abstract method (SAM).

    - Ex:

        - Runnable  -> contains only run() method
        - Comparable -> contains only compareTo() method


- The interface in addition to single abstract method can have any number of
  default and static methods.
- Restriction is only for single abstract method.
    - Ex:

    ```java
    interface Interf{
        //SAM(Single Abstract Method)
        public abstract void m1();
        default void m2(){
            System.out.println("Hello");
        }
    }
    ```


- In Java8, `@Functional Interface` annotation was introduced to specify functional
  interfaces.
    - Ex:
    ```java
    @FunctionalInterface
    interface Interf{
        void m1();
    }
    ```
    - Inside Fucntional Interface there can be only one abstract method, if more than
      one abstract method is defined then compiler throws compilation error:
      
      > unexpected @FunctionalInterface annotation.<br>
        Multiple non-overriding abstract methods present in interface InterfaceName

    - Inside Functinal Interface it is mandatory to declare one abstract method. If not
      declared compiler throws Comilation error:
        >unexpected @FunctionalInterface annotation.<br> no abstract method found in interface InterfaceName.
    - so, `@FunctionalInterface` enable compile time checking for Functional interfaces
          and makes the code more robust.
    - It basically acts as a contract for an Interface to follow Single Abstract Method Rule.

## Functional Interface with respect to Inheritance:

- If an interface extends Functional Interface and child interface doesn't
  contain any abstract method then the child interface is also a Functional interface.
    - Ex:
  ```java
  @FunctionalInterface
  interface A{
      public void m1();
  }
  
  @FunctionalInterface
  interface B extends A{
      
  }
  ```

- The child interface can contain exactly same abstract method as parent and it would remain Functional Interface.

    - Ex:
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

- In the child interface we can't define any new abstract method if `@FunctionalInterface`
  is applied to it else it will throw compilation error.

    - Ex:
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
  >compilatin error: <br> Unexpected @FunctionalInterface annotation. <br>
  > multiple non-overriding abstract methods found in interface B

- But if `@FunctionalInterface` is not applied to child interface, new abstract methods can be
  defined in child interface then; but the child interface won't be Functional Interface anymore.

    - Ex:

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

> Note: <br>
> Functional Interfaces can be used to invoke Lambda Expressions.
> It acts as a type of Lambda Expression.
























