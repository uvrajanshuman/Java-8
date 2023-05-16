# Consumer

A functional interface that represents a function accepting a single input and performing some actions on that input.

It is a functional interface present in `java.util.function` package and has a single abstract method `accept()`.<br>
The method takes an input of a specified type processes it and does not return any result.
```java
void accept(T t);
```
Here, **T** represents the type of the input parameter. The `accept()` method implementation should define the action or operation 
that needs to be performed on the input value.

**`Consumer<T>`**
```java
@FunctionalInterface
public interface Consumer<T> {
  // SAM(Single Abstract Method)
  void accept(T t);
  
  // Consumer chaining
  default Consumer<T> andThen(Consumer<? super T> after) {
        ...
  }
}
```

### Example: Program to accept a string and print it to console

```java
import java.util.function.Consumer;

class App {
  public static void main(String[] args) {
    Consumer<String> c = s -> System.out.println(s);
    c.accept("Hello");
    c.accept("world");
  }
}
```
Output:
```shell
Hello
world
```

## Consumer Chaining

Multiple consumers can be combined to form more complex consumer.
For this a default methods is provided.
- andThen()
    - `joinedConsumer = consumer1.andThen(consumer2).andThen(consumer3)`
    - `joinedConsumer.accept(s)`
    - First **consumer1** wil be applied on supplied parameter followed by **consumer2** and **consumer3**.

Example:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 *  Example demonstrating Consumer chaining
 */
public class ConsumerChainingExample {
  //Consumer(s) for printing student name, marks and grade
  static Consumer<Student> printName = s -> System.out.printf("Name: \"%s\" ", s.getName());
  static Consumer<Student> printMarks = s -> System.out.printf("Total Marks: \"%s\" ", s.getMarks());
  static Consumer<Student> printGrade = s -> System.out.printf("Grade: \"%s\" \n", s.getGrade());

  //consumer chaining: andThen()
  static Consumer<Student> printNameMarksGrade = printName.andThen(printMarks).andThen(printGrade);

  public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
            new Student(1, "Anshuman", 98, "A+"),
            new Student(2, "Yuvraj", 84, "B"),
            new Student(3, "Ram", 78, "C"));

    for (Student s : studentList) {
      printNameMarksGrade.accept(s);
    }
  }
}

class Student {
  int roll;
  String name;
  double marks;
  String grade;
  /*
   *  getters, setters and constructor
   */
}
```

```shell
Output:
  Name: "Anshuman" Total Marks: "98.0" Grade: "A+" 
  Name: "Yuvraj" Total Marks: "84.0" Grade: "B" 
  Name: "Ram" Total Marks: "78.0" Grade: "C" 
```

[Example: Consumer and Consumer chaining](./ConsumerAndConsumerChainingExample.java)