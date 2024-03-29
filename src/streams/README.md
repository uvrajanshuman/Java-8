# Streams

Streams are the sequence of elements which can be created out of a collection such as List or Arrays or any kind of I/O resources.<br>
Streams got introduced in Java 8 and is included in `java.util.stream` package.

Parallel operations are also easy to perform with Stream API without having to spawn multiple threads.

Streams do not change the original data structure, they are created out of a collection of elements and provide the result 
as per the pipelined methods.<br>
Stream elements can be used only once, if an attempt is made to access it later `IllegalStateExeption` exception is thrown.

## Collections vs Streams

| Collection                                                                                                                                | Streams                                                                           |
|-------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|
| If there is need to represent a group of individual objects as single entity, Collection should be preferred.                             | If there is need to process a collection of objects, Streams should be preferred. |
| Can add or modify elements <br>Example: **List:** `list.add(element) `                                                                    | Cannot add or modify elements in a stream. It is a fixed data set.                |
| Elements in the collection can be accessed in any order. Use appropriate method based on collection <br/>Example: **List:** `list.get(4)` | Elements in the Stream can be accessed only in sequence, one by one.              |
| Collections are eagerly constructed                                                                                                       | Streams are lazily constructed.                                                   |
| Collections can be traversed "n" number of times.                                                                                         | Streams can be traversed only once.                                               |

- `default Stream stream()` is a default method added to **Collection** interface in Java 1.8.
- A Stream object can be created out of a  Collection using the `stream()` method of Collection interface. 
 <br>Example: `Stream s = list.stream();`

## Advantages of using Stream:

- Efficient and shorter, removes lots of boilerplate code.
- Provides a very easy way to do parallel computation without having to worry about the multi-threaded implementations.
- Provides a large set of operations (built-in operations) that covers the common data processing scenarios.
- Provides a more memory efficient way, as the stream is closed once it's consumed, and there are no extra objects and variables
created which lingers on, waiting to be garbage collected.
- With the use of lambda expression, a wide range of functionalities can be implemented.

### Example : Collecting even numbers from a list

**withous streams:**
```java
// source list
List<Integer> numbersList = Arrays.asList(10, 15, 20, 25);

//target list
List<Integers> evenNumbersList = new ArrayList<>();
for(int n: numbersList){
    if(n % 2 == 0){
        evenNumbersList.add(n);
    }
}
```

**with streams:**
```java
// source list
List<Integer> numbersList = Arrays.asList(10, 15, 20, 25);

// target list
List<Integer>evenNumbersList = numbersList.stream()
                                .filter(i -> i % 2 == 0)
                                .collect(Collectors.toList());
```

## Stream pipeline:

A stream pipeline consists of a stream source, zero or more intermediate operations and a terminal operation.

![Stream pipeline](../../resources/images/java-streams.png)

### Stream source

The stream can be generated from Array, Set, List, Map or any Collection or any kind of I/O resources.

Examples:
```java
String [] fruits = new String[]{"apple","orange","banana","pineapple","oranges","apple","mango"};
Stream<String> fruitsStream = Arrays.stream(fruits);
```

```java
ArrayList<String> fruits = new ArrayList<>();
fruits.add("apple");
...
Stream<String> fruitStream = fruits.stream()
```

```java
Stream<String> fruitStream = Stream.of("apple", "oranges", "banana","pineapple","guava","apple","mango");
```

### Intermediate operations

In a stream pipeline, there can be one or more intermediate operations. And each intermediate operation consumes a stream 
and produces another stream as per the implemented logic.

Intermediate operations can be of two types
1. Stateless:
    - Stateless operations do not maintain any state from one element to another while processing the stream. 
    - Each element is processed independently, and the operation does not rely on the order or previous elements in the stream.
    - Examples: `filter`, `map`, `flatMap`, `peek`, etc.
2. Stateful:
    - Stateful operations, on the other hand, may maintain state or accumulate information while processing the elements of the stream. 
    - The result of these operations depends on the order and values of previous elements in the stream.
    - Examples; `distinct`, `sorted`, `limit`, etc.

Intermediate operations:
- filter
- map
- flatMap
- peek
- distinct
- sorted
- limit 
- skip


### Terminal operations

The terminal operation consumes the stream, but does not produces a stream, instead produces some result.

In a stream pipeline, there can be only one terminal operation. Terminal operations starts the entire stream pipeline.

Terminal operations:
- min
- max
- sum
- count
- average
- reduce
- collect
- forEach
- anyMatch
- allMatch
- noneMatch
- findFirst
- findAny

>Note:<br>
> Streams are lazy, no intermediate operations will be invoked until the terminal operation is applied.<br>
> The terminal method starts the pipeline<br>
> Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations
> can be pipelined. Terminal operations mark the end of the stream and return the result.

## Sample class and data for Stream method demonstration
<details>
  <summary>Student class and Data: click to expand/collapse</summary>

   ```java
   import java.util.ArrayList;
   import java.util.Arrays;
   import java.util.List;
   
   public class Student {
      private String name;
      private String gender;
      private String department;
      private int rollNo;
      private List<String> activities;
   
      public Student(String name, String gender, String department, int rollNo, List<String> activities) {
         this.name = name;
         this.gender = gender;
         this.department = department;
         this.rollNo = rollNo;
         this.activities = activities;
      }
   
      public String getName() {
         return name;
      }
   
      public void setName(String name) {
         this.name = name;
      }
   
      public String getGender() {
         return gender;
      }
   
      public void setGender(String gender) {
         this.gender = gender;
      }
   
      public String getDepartment() {
         return department;
      }
   
      public void setDepartment(String department) {
         this.department = department;
      }
   
      public int getRollNo() {
         return rollNo;
      }
   
      public void setRollNo(int rollNo) {
         this.rollNo = rollNo;
      }
   
      public List<String> getActivities() {
         return activities;
      }
   
      public void setActivities(List<String> activities) {
         this.activities = activities;
      }
   
      @Override
      public String toString() {
         return "Student{" +
                 "name='" + name + '\'' +
                 ", gender='" + gender + '\'' +
                 ", department='" + department + '\'' +
                 ", rollNo=" + rollNo +
                 ", activiteis=" + activities +
                 '}';
      }
   
      public static List<Student> getAllStudents(){
         List<Student> students = new ArrayList<>();
         // Computer Science students
         students.add(new Student("Aarav", "Male", "Computer Science", 101, Arrays.asList("Sports", "Coding Club")));
         students.add(new Student("Rohan", "Male", "Computer Science", 102, Arrays.asList("Music", "Coding Club")));
         students.add(new Student("Isha", "Female", "Computer Science", 103, Arrays.asList("Sports", "Coding Club")));
         students.add(new Student("Ishita", "Female", "Computer Science", 104, Arrays.asList("Photography", "Coding Club")));
         students.add(new Student("Sahil", "Male", "Computer Science", 105, Arrays.asList("Art", "Coding Club")));
   
         // Mechanical Engineering students
         students.add(new Student("Rohan", "Male", "Mechanical Engineering", 201, Arrays.asList("Dance", "Photography")));
         students.add(new Student("Sia", "Female", "Mechanical Engineering", 202, Arrays.asList("Photography", "Debate Club")));
         students.add(new Student("Rishi", "Male", "Mechanical Engineering", 203, Arrays.asList("Dance", "Robotics Club")));
         students.add(new Student("Aryan", "Male", "Mechanical Engineering", 203, Arrays.asList("Guitar Club", "Photography")));
   
         // Electrical Engineering Students
         students.add(new Student("Aryan", "Male", "Electrical Engineering", 301, Arrays.asList("Music", "Robotics Club")));
         students.add(new Student("Ved", "Male", "Electrical Engineering", 302, Arrays.asList("Music", "Robotics Club")));
         students.add(new Student("Varun", "Male", "Electrical Engineering", 303, Arrays.asList("Photography", "Debate Club")));
         students.add(new Student("Nisha", "Female", "Electrical Engineering", 304, Arrays.asList("Music", "Debate Club")));
   
         // Civil Engineering Students
         students.add(new Student("Arjun", "Male", "Civil Engineering", 401, Arrays.asList("Photography", "Guitar Club")));
         students.add(new Student("Kavya", "Female", "Civil Engineering", 402, Arrays.asList("Photography", "Photography")));
         students.add(new Student("Karan", "Male", "Civil Engineering", 403, Arrays.asList("Sports", "Robotics Club")));
         students.add(new Student("Anika", "Female", "Civil Engineering", 404, Arrays.asList("Sports", "Guitar Club")));
   
         // Information Technology Students
         students.add(new Student("Neha", "Female", "Information Technology", 501, Arrays.asList("Music", "Art")));
         students.add(new Student("Ravi", "Male", "Information Technology",502, Arrays.asList("Coding Club", "Guitar Club")));
         students.add(new Student("Tanvi", "Female", "Information Technology", 503, Arrays.asList("Dance", "Robotics Club")));
         students.add(new Student("Diya", "Female", "Mechanical Engineering", 504, Arrays.asList("Robotics Club", "Debate Club")));
   
   
         // Electronics and Communication Engineering students
         students.add(new Student("Raj", "Male", "Electronics and Communication Engineering", 601, Arrays.asList("Sports", "Guitar Club")));
         students.add(new Student("Rahul", "Male", "Electronics and Communication Engineering", 602, Arrays.asList("Sports", "Music")));
         students.add(new Student("Prachi", "Female", "Electronics and Communication Engineering", 603, Arrays.asList("Dance", "Debate Club")));
         students.add(new Student("Diya", "Female", "Electronics and Communication Engineering", 604, Arrays.asList("Robotics Club", "Debate Club")));
   
   
         return students;
      }
   }

   ```
</details>

[Student class and Sample data](./data/Student.java)

### Stream pipeline Demonstration:
```java
/*
 * Example demonstrating the Stream pipeline
 */

import streams.data.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StreamPipelineExample {
   public static void main(String[] args) {

      List<String> computerScienceStudents = Student.getAllStudents().stream() //Stream<Student>
              .filter(student -> student.getDepartment().equals("Computer Science")) //Stream<Student>
              .map(Student::getName) //Stream<String>
              .collect(Collectors.toList());

      System.out.println("Computer Science students: " + computerScienceStudents);
   }
}
```


<details>
  <summary>Output: Click to expand/collapse</summary>

  ```shell
    Computer Science students: [Aarav, Rohan, Isha, Ishita, Sahil]
  ```
</details>

![Stream Pipeline](../../resources/images/stream-pipeline.png)

[Example: Stream Pipeline](./StreamPipelineExample.java)

> Note: <br>
> In stream pipeline each element is passed one by one through the pipeline operation.<br>
> i.e: all the pipeline operation are performed for 1st element before going for the 2nd element

----

## Steam API factory methods

### **of**

`static Stream of(T... values)`

- Returns a sequential ordered stream whose elements are the specified values.
- creates a stream of values passed to this method. There can be one or more values. <br>

```java
Stream<String> fruitStream = Stream.of("apple", "oranges", "banana", "pineapple", "guava", "apple", "mango");
```

### iterate

`static Stream iterate(T seed, UnaryOperator<T> f)`

- Returns an infinite sequential ordered Stream produced by iterative application of a function **f** to an initial element
  **seed**, producing a Stream consisting of **seed, f(seed), f(f(seed)), ...., etc.**
- The first element (index 0) in the Stream will be provided seed.
- For **n > 0**, the element at position **n**, will be the result of applying the function **f** to the element at position **n-1**.
- Note: `limit(maxSize)` can be used to limit this infinite stream. <br>

```java
Stream<Integer> stream = Stream.iterate(1, x -> x*2);
```

### generate

`static Stream generate(Supplier s)`

- Returns an infinite sequential unordered Stream where each element is generated by the provided supplier.
- This is suitable for generating constant streams, stream of random elements, etc.
- Note: `limit(maxSize)` can be used to limit this infinite stream.

```java
Supplier<Integer> intSupplier = new Random()::nextInt;
Stream<Integer> randomIntStream = Stream.generate(intSupplier);
```

[Example: Stream Factory Methods](./StreamFactoryMethodsExample.java)

---

## Stream Operations:

### peek

`Stream<T> peek(Consumer<? super T> action)`

- This is an intermediate operation.
- Returns a stream consisting of the elements of the provided stream, additionally performing the provided action on each
  element as elements are consumed from the resulting stream.
- It accepts a consumer and is basically used to apply a operation on the stream.
- It is mostly used for printing, logging, or debugging without changing the elements or the order of the stream.<br>
 but can also be used to perform operations instead.

Example:
- to get view of what is being passed from one operation to another in previous [example](#stream-pipeline-demonstration)
```java
List<String> computerScienceStudents = Student.getAllStudents().stream()
        .peek(System.out::println) // prints the stream at this position
        .filter(student -> student.getDepartment().equals("Computer Science"))
        .peek(System.out::println) // prints the stream at this position (after filter operation)
        .map(Student::getName)
        .peek(System.out::println) // prints the stream at this position (after map operation)
        .collect(Collectors.toList());
```
[Example: debugging using peek](./PeekExample.java)<br>
[Example: performing operation on stream using peek](./PeekExample2.java)

### filter

`Stream<T> filter(Predicate<? super T> predicate)`

- This is an intermediate operation.
- Returns a new stream consisting of the elements of the given stream that match the supplied predicate.
- It is used to selectively include or exclude elements from a stream based on a specified condition or predicate. 
It allows to process only those elements that satisfy the given condition, while discarding the rest.

[Example: To filter out even numbers from a list](./FilterExample1.java)

```java
import java.util.Arrays;
import java.util.stream.Collectors;
  
public class App {
  public static void main(String[] args) {
    List<Integer> numbersList = Arrays.asList(10, 15, 20, 25);
    
    List<Integer>evenNumbersList = numbersList.stream()
                                    .filter(i -> i % 2 == 0)
                                    .collect(Collectors.toList());
    System.out.println("Even numbers in the list: "+evenNumbersList);
  }
} 
```
Output:
```shell
Even numbers in the list: [10, 20]
```

[Example: Filter student data based on different conditions](./FilterExample2.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.stream.Collectors;

public class App {
    //filter all male students
    public static List<Student> getAllMaleStudents() {
        List<Student> maleStudents = Student.getAllStudents().stream()
                .filter(student -> student.getGender().equals("Male"))
                .collect(Collectors.toList());
        return maleStudents;
    }

    //filter all female students
    public static List<Student> getAllFemaleStudents() {
        List<Student> femaleStudents = Student.getAllStudents().stream()
                .filter(student -> student.getGender().equals("Female"))
                .collect(Collectors.toList());

        return femaleStudents;
    }

    //filter all student who participate in coding club or photography club
    public static List<Student> getAllCodingOrPhotographyClubStudents() {
        List<Student> codingOrPhotographyStudents = Student.getAllStudents().stream()
                .filter(student ->
                        student.getActivities().contains("Coding Club")
                                || student.getActivities().contains("Photography")).collect(Collectors.toList());
        return codingOrPhotographyStudents;
    }

    public static String getStudentNames(List<Student> students) {
        String names = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "[", "]"));
        return names;
    }
    public static void main(String[] args) {
        List<Student> maleStudents = getAllMaleStudents();
        List<Student> femaleStudents = getAllFemaleStudents();
        List<Student> codingOrPhotographyStudents = getAllCodingOrPhotographyClubStudents();

        System.out.println("Male Students: "+getStudentNames(maleStudents));
        System.out.println("Female Students: "+getStudentNames(femaleStudents));
        System.out.println("Coding or Photography Students: "+getStudentNames(codingOrPhotographyStudents));
    }
}

```
Output:
```shell
Male Students: [Aarav,Rohan,Sahil,Rohan,Rishi,Aryan,Aryan,Ved,Varun,Arjun,Karan,Ravi,Raj,Rahul]
Female Students: [Isha,Ishita,Sia,Nisha,Kavya,Anika,Neha,Tanvi,Diya,Prachi,Diya]
Coding or Photography Students: [Aarav,Rohan,Isha,Ishita,Sahil,Rohan,Sia,Aryan,Varun,Arjun,Kavya,Ravi]
```
</details>

### map 

`<R> Stream<R> map(Function<? super T,? extends R> mapper)`

- This is an intermediate operation.
- Returns a new stream consisting of the results of applying the supplied Function to the elements of the given stream.
- It performs operation on every element of stream and converts/transforms them from one type to another.

[Example: To transform the list of string to uppercase](./MapExample1.java)

```java
import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    List<String> transportationModes = Arrays.asList("bus","car","bi-cycle","train","flights");
    transportationModes.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);
  }
} 
```
Output:
```shell
BUS
CAR
BI-CYCLE
TRAIN
FLIGHTS
```

[Example: To get all Student names](./MapExample2.java)

<details>
  Abc
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.stream.Collectors;

public class App {
    //get student names
    private static List<String> getStudentNames() {
        List<String> names = Student.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        return names;
    }

    public static void main(String[] args) {
        System.out.println("Student Names: " + getStudentNames());
    }
}

```
Output:
```shell
 Student Names: [Aarav, Rohan, Isha, Ishita, Sahil, Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
```
</details>

### flatMap 

`Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)`

- This is an intermediate operation.
- It is used to flatten a stream of collections or arrays into a single stream of elements. 
It applies a function to each element in the stream and flattens the resulting collections or arrays into a single stream.
- converts/transforms one type to another like map(), but
used in context of Stream where each element in the stream represents multiple elements.
Ex: Stream\<List>, Stream\<Arrays>

The flatMap method is typically used when you have a stream of nested collections or arrays and want to work with the individual elements within them, rather than the nested structures themselves.

[Example: Flattening a list containing multiple sub-lists](./FlatMapExample1.java)
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
      List<Integer> subList1 = Arrays.asList(1, 2);
      List<Integer> subList2 = Arrays.asList(3, 4);
      List<Integer> subList3 = Arrays.asList(5, 6);

      // List containing multiple sublists
      List<List<Integer>> list = Arrays.asList(subList1, subList2, subList3);

      //Flattening the sublists into a single list
      List<Integer> collectedList = list.stream() // Stream<List<Integer>>
              .flatMap(l -> l.stream()) // Stream<Integer>
              .collect(Collectors.toList()); // List<Integer>

      System.out.println("Flattened List: "+collectedList);
  }
}
```
Output:
```shell
Flattened List: [1, 2, 3, 4, 5, 6]
```

[Example: To get all the activities performed by students](./FilterExample2.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    // to collect all the activities of all the students
    private static Set<String> getAllActivities() {
        return Student.getAllStudents() // List<Student>
                .stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println("Student Activities: "+getAllActivities());
    }
}
```
Output:
```shell
Student Activities: [Photography, Coding Club, Art, Music, Dance, Debate Club, Guitar Club, Robotics Club, Sports]
```
</details>

### distinct 

`Stream<T> distinct()`

- This is a stateful intermediate operation.
- Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
- Returns a stream with unique elements

[Example: To get all distinct activities performed by students](./DistinctExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {

    //get a list all the unique/distinct activities
    private static List<String> getAllDistinctActivities() {
        return Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Student activities: "+getAllDistinctActivities());
    }
}
```
Output:
```shell
Student activities: [Sports, Coding Club, Music, Photography, Art, Dance, Debate Club, Robotics Club, Guitar Club]
```
</details>

### count

`long count()`

- This is a terminal operation.
- Returns the count of elements in this stream.

[Example: count](./CountExample.java)
<details>
  <summary>Stream API demo: Click to expand/collapse</summary>

```java
import java.util.List;

public class CountExample {
    //get activities count
    private static long getActivitiesCount() {
        return Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .count();
    }

    //get computer science students count
    private static long getCseStudentsCount(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .count();
    }

    public static void main(String[] args) {
        System.out.println("Total activities count: "+getActivitiesCount());
        System.out.println("CSE students count: "+getCseStudentsCount());
    }
}
```
Output:
```shell
Total activities count: 50
CSE students count: 5
```
</details>

### sorted 

`Stream<T> sorted()`

- This is a stateful intermediate operation.
- Returns a stream consisting of the elements of this stream, sorted according to **natural order**.
- If the elements of this stream are not Comparable,
  a `java.lang.ClassCastException` will be thrown when the terminal operation is executed.

[Example: sort a list of string (natural-order sorting)](./SortedExample2.java)
```java
import java.util.Arrays;
import java.util.List;

public class SortedExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Mango", "Pineapple");

        System.out.println("Original List: " + fruits);

        List<String> sortedFruits = fruits.stream()
                .sorted()
                .toList();

        System.out.println("Sorted Fruits: " + sortedFruits);
    }
}
```
Output:
```shell
Original List: [Apple, Orange, Banana, Mango, Pineapple]
 * Sorted Fruits: [Apple, Banana, Mango, Orange, Pineapple]
```

### sorted 

`Stream<T> sorted(Comparator<? super T> comparator)`

- This is a stateful intermediate operation.
- Returns a stream consisting of the elements of this stream, sorted according to the provided **Comparator**.
- If the elements of this stream are not Comparable, a `java.lang.ClassCastException` will be thrown
  when the terminal operation is executed.

[Exampe: sorting students based on their names (custom-sorting)](./SortedExample.java)
<details>
  Abc
  <summary>click to expand/collapse</summary>

```java
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    //sort all students by name
    private static List<Student> sortStudentsByName() {
        return Student.getAllStudents()
                .stream()
//                .sorted((student1, student2) -> student1.getName().compareTo(student2.getName()))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    private static String getStudentNames(List<Student> students){
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",","[","]"));
    }

    public static void main(String[] args) {
        List<Student> studentsSortedByName = sortStudentsByName();
        System.out.println("Students sorted by name: "+getStudentNames(studentsSortedByName));
    }
}

```
Output:
```shell
Students sorted by name: [Aarav,Anika,Arjun,Aryan,Aryan,Diya,Diya,Isha,Ishita,Karan,Kavya,Neha,Nisha,Prachi,Rahul,Raj,Ravi,Rishi,Rohan,Rohan,Sahil,Sia,Tanvi,Varun,Ved]
```
</details>


### reduce 

`T reduce(T identity,BinaryOperator<T> accumulator)`

- This is a terminal operation.
- **Used to reduce the contents of a stream to a single value.**
- Performs a reduction on the elements of this stream, using the provided identity value
  and an associative accumulation function, and returns the reduced value.
- This is equivalent to:
  ```java
    T result = identity;
    for (T element : this.stream)
        result = accumulator.apply(result, element)
    return result;
  ```
- The identity will be used as the initial value.
- The accumulator function must be an associative function.
  Ex:
```java
public class App{
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1,3,5,7);
    
    int totalSum = integerList.stream()
            .reduce(0,(a,b)->a+b);
    
    System.out.println(totalSum);
  }
}
```
> In the above ex. in first cycle 0 (initial/identity vlue) will be assigned to a, 1 to b; their sum would be calculated and assigned back to a<br>
> In second cycle a will be holding previous sum (1) and b will be assigned 3; the sum will be calculated and assigned back to a <br>
> The cycle will continue so on. The accumulation will be done and final result will be returned.

### reduce 

`Optional.OptionalExample<T> reduce(BinaryOperator<T> accumulator)`

- This is a terminal operation.
- **Used to reduce the contents of a stream to a single value.**
- Performs a reduction on the elements of this stream, using an associative accumulation function,
  and returns an Optional.OptionalExample describing the reduced value, if any.
- This is equivalent to:
  ```java
    boolean foundAny = false;
    T result = null;
    for (T element : this.stream) {
        if (!foundAny) {
            foundAny = true;
            result = element;
        }else{
            result = accumulator.apply(result, element);
        }
    }
    return foundAny ? Optional.of(result) : Optional.empty();
  ```

- The accumulator function must be an associative function.

Ex:

```java
import Optional.OptionalExample;

import java.util.Optional.Optional;

public class App {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 3, 5, 7);

    Optional.OptionalExample<Integer> totalSum = integerList.stream()
            .reduce((a, b) -> a + b);

    if (totalSum.isPresent())
      System.out.println(totalSum.get());
  }
}
```
> In the above ex. in first cycle 1 will be assigned to a and first cycle will end here ony; as there is not initial vale provided explicitly<br>
> In second cycle a will be holding previous sum (1) and b will be assigned 3; the sum will be calculated and assigned back to a <br>
> The cycle will continue so on. The accumulation will be done and final result will be returned.

[Example: reduction with and without identity](./ReduceExample.java)
<details>

  <summary>click to expand/collapse</summary>

```java
/*
 * Example demonstrating Stream method: reduce(T identity,BinaryOperator<T> accumulator)
 * and reduce(BinaryOperator<T> accumulator)
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

    private static int performSumWithInitialValue(List<Integer> list) {
        return list.stream()
//                .reduce(0,(a,b) -> a+b);
                .reduce(0, Integer::sum);
    }

    private static Optional<Integer> performSumWithNoInitialValue(List<Integer> list) {
        return list.stream()
//                .reduce((a,b) -> a+b);
                .reduce(Integer::sum);
    }

    private static int performMultiplicationWithInitialValue(List<Integer> list) {
        return list.stream()
                .reduce(1, (a,b) -> a*b);
    }

    private static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> list) {
        return list.stream()
                .reduce((a,b) -> a*b);
    }

    private static void printSumAndProduct(List<Integer> integerList) {
        System.out.println("Multiplication with identity: "+performMultiplicationWithInitialValue(integerList));

        Optional<Integer> multiplicationWithoutIdentity = performMultiplicationWithNoInitialValue(integerList);
        if(multiplicationWithoutIdentity.isPresent()) {
            System.out.println("Multiplication without identity: "+multiplicationWithoutIdentity.get());
        }else {
            System.out.println("Multiplication without identity: Empty list, not able to perform multiplication");
        }

        System.out.println("Sum with identity: "+performSumWithInitialValue(integerList));

        Optional<Integer> sumWithoutIdentity = performSumWithNoInitialValue(integerList);
        if(sumWithoutIdentity.isPresent()) {
            System.out.println("Sum without identity: "+sumWithoutIdentity.get());
        }else {
            System.out.println("Sum without identity: Empty list, not able to perform sum");
        }
    }

    public static void main(String[] args) {

        System.out.println("Non-empty list");
        List<Integer> integerList = Arrays.asList(1,3,5,7);
        printSumAndProduct(integerList);

        System.out.println("\nEmpty list");
        List<Integer> integerList2 = Arrays.asList();
        printSumAndProduct(integerList2);
    }
}
```
Output:
```shell
Non-empty list
Multiplication with identity: 105
Multiplication without identity: 105
Sum with identity: 16
Sum without identity: 16

Empty list
Multiplication with identity: 1
Multiplication without identity: Empty list, not able to perform multiplication
Sum with identity: 0
Sum without identity: Empty list, not able to perform sum
```
</details>

### max 

`Optional.OptionalExample<T> max(Comparator<? super T> comparator)`

- This is a terminal operation.
- Returns the maximum element of this stream according to the provided Comparator.
- This is a special case of a reduction.

### min 

`Optional.OptionalExample<T> min(Comparator<? super T> comparator)`

- This is a terminal operation.
- Returns the minimum element of this stream according to the provided Comparator.
- This is a special case of a reduction.

[Example: To find minimum and maximum elements from the list](./MinMaxExample.java)

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> minElement = integerList.stream()
                .min(Comparator.naturalOrder());
        Optional<Integer> maxElement = integerList.stream()
                .max(Comparator.naturalOrder());
        minElement.ifPresent(integer -> System.out.println("Minimum element in the list: " + integer));
        maxElement.ifPresent(integer -> System.out.println("Maximum element in the list: " + integer));
    }
}
```
Output:
```shell
Minimum element in the list: 1
Maximum element in the list: 6
```

### limit 

`Stream<T> limit(long maxSize)`

- This is a short-circuiting stateful intermediate operation.
- Helps to create a sub-stream.
- Returns a stream consisting of the elements of this stream, truncated to be no longer than **maxSize** in length.
- **maxSize** - the number of elements the returned stream should be limited to.
- **limit(n)** : limits the **n** no. of elements to be processed in the stream.

[Example: sum of first three numbers of an integer list](./LimitAndSkipExample.java)

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
    Optional<Integer> firstThreeSum = integerList
            .stream() // Stream<Integer> // all integers of integerList.
            .limit(3) // Stream<Integer> // limited to first three integers of integerList.
            .reduce(Integer::sum);

      firstThreeSum.ifPresent(integer -> System.out.println("Sum: " + integer));
  }
}
```
Output:
```shell
Sum: 6
```

[Example: limit stream factory method `generate` and `iterate`](./StreamFactoryMethodsExample.java)

### skip 

`Stream<T> skip(long n)`

- This is a stateful intermediate operation.
- Helps to create a sub-stream
- Returns a stream consisting of the remaining elements of this stream after discarding the first **n** elements of the stream.
- If this stream contains fewer than n elements then an empty stream will be returned.
- **n** - the number of leading elements to skip
- **skip(n)** : skips the "n" no of elements from the stream.

[Example: skip first three numbers of a integer list and find sum of remaining](./LimitAndSkipExample.java)

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
    Optional<Integer> skipThreeSum = integerList
            .stream() // Stream<Integer> // all integers of integerList.
            .skip(3) // Stream<Integer> // first three integers of integerList will be skipped..
            .reduce(Integer::sum);

      skipThreeSum.ifPresent(integer -> System.out.println("Sum: " + integer));
  }
}
```
Output:
```shell
Sum: 15
```


### anyMatch

`boolean anyMatch(Predicate<? super T> predicate)`

- This is a short-circuiting terminal operation.
- Takes a predicate as an input and returns a boolean result.
- Checks whether any elements of this stream match the provided predicate.
- Returns true if any one of the element matches the predicate, otherwise false
- May not evaluate the predicate on all elements if not necessary for determining the result.
  (ex: if an element satisfies the predicate condition, the next elements won't be evaluated for the predicate; directly true will be returned)<br>
That's why this is a short-circuiting operation.
- If the stream is empty then false is returned and the predicate is not evaluated.

### allMatch 

`boolean allMatch(Predicate<? super T> predicate)`

- This is a short-circuiting terminal operation.
- Takes a predicate as an input and returns a boolean result.
- Checks whether all elements of this stream match the provided predicate.
- Returns true if all the element matches the predicate, otherwise false
- May not evaluate the predicate on all elements if not necessary for determining the result.
  (ex: if an element does not satisfy the predicate, the next elements won't be evaluated for the predicate; directly false will be returned)<br>
  That's why this is a short-circuiting operation.
- If the stream is empty then true is returned and the predicate is not evaluated.

### noneMatch 

`boolean noneMatch(Predicate<? super T> predicate)`

- This is a short-circuiting terminal operation.
- Takes a predicate as an input and returns a boolean result.
- Returns true if none of the element matches the predicate, otherwise false
- Returns whether no elements of this stream match the provided predicate.
- May not evaluate the predicate on all elements if not necessary for determining the result.
  (ex: if an element satisfies the predicate condition, the next elements won't be evaluated for the predicate; directly false will be returned)<br>
  That's why this is a short-circuiting operation.
- If the stream is empty then true is returned and the predicate is not evaluated.
- Just opposite of allMatch()


[Example: anyMatch(), allMatch(), noneMatch()](./AnyMatchAllMatchNoneMatchExample1.java)
```java
/*
 * Example demonstrating Stream methods: anyMatch(), allMatch() and noneMatch()
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnyMatchAllMatchNoneMatchExample {
    private static final Predicate<Integer> isEven = integer -> integer % 2 == 0;

    //allMatch() demo
    private static boolean checkIfAllEven(List<Integer> list){
        return list.stream()
                .allMatch(isEven);
    }

    //anyMatch() demo
    private static boolean checkIfAnyEven(List<Integer> list){
        return list.stream()
                .anyMatch(isEven);
    }

    //noneMatch() demo
    private static boolean checkIfNoneEven(List<Integer> list){
        return list.stream()
                .noneMatch(isEven);
    }

    public static void main(String[] args) {
        List<Integer> mixedList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenList = Arrays.asList(2,4,6,8,10);
        List<Integer> oddList = Arrays.asList(1,3,5,7,9);

        System.out.println("All match demo for mixedList: "+checkIfAllEven(mixedList)); // false
        System.out.println("All match demo for evenList: "+checkIfAllEven(evenList)); // true
        System.out.println("All match demo for oddList: "+checkIfAllEven(oddList)); // false
        System.out.println();
        System.out.println("Any match demo for mixedList: "+checkIfAnyEven(mixedList)); // true
        System.out.println("Any match demo for evenList: "+checkIfAnyEven(evenList)); // true
        System.out.println("Any match demo for oddList: "+checkIfAnyEven(oddList)); // false
        System.out.println();
        System.out.println("None match demo for mixedList: "+checkIfNoneEven(mixedList)); // false
        System.out.println("None match demo for evenList: "+checkIfNoneEven(evenList)); // false
        System.out.println("None match demo for oddList: "+checkIfNoneEven(oddList)); // true

    }
}
```
Output:
```shell
All match demo for mixedList: false
All match demo for evenList: true
All match demo for oddList: false

Any match demo for mixedList: true
Any match demo for evenList: true
Any match demo for oddList: false

None match demo for mixedList: false
None match demo for evenList: false
None match demo for oddList: true
```
[Example: anyMatch, allMatch and noneMatch on Student data](./AnyMatchAllMatchNoneMatchExample2.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnyMatchAllMatchNoneMatchExample {

    // anyMatch
    private static boolean anyMatch(List<Student> students, Predicate<Student> predicate){
        return students.stream()
                .anyMatch(predicate);
    }

    // allMatch
    private static boolean allMatch(List<Student> students, Predicate<Student> predicate){
        return students.stream()
                .allMatch(predicate);
    }

    // noneMatch
    private static boolean noneMatch(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .noneMatch(predicate);
    }

    public static void main(String[] args) {
        List<Student> itStudents = Student.getAllStudents().stream()
                .filter(student -> student.getDepartment().equals("Information Technology"))
                .collect(Collectors.toList());

        List<Student> cseStudents = Student.getAllStudents().stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .collect(Collectors.toList());

        List<Student> civilStudents = Student.getAllStudents().stream()
                .filter(student -> student.getDepartment().equals("Civil Engineering"))
                .collect(Collectors.toList());

        Predicate<Student> codingClub = student -> student.getActivities().contains("Coding Club");

        //to check if any Information Technology student participates in coding club
        System.out.println("Any Information Technology student participates in coding club: "+anyMatch(itStudents,codingClub));
        //to check whether all the computer science student participate in coding club
        System.out.println("All Computer Science students participate in coding club: "+allMatch(cseStudents,codingClub));
        //to check if none of the Civil Engineering student participate in coding club
        System.out.println("None of the Civil Engineering students participate in coding club: "+noneMatch(civilStudents,codingClub));
    }
}

```
Output:
```shell
Any Information Technology student participates in coding club: true
All Computer Science students participate in coding club: true
None of the Civil Engineering students participate in coding club: true
```
</details>

### findFirst 

Optional.OptionalExample<T> findFirst()

- This is a short-circuiting terminal operation.
- Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.
- Returns the first element in the stream.

### findAny 

Optional.OptionalExample<T> findAny()
- This is a short-circuiting terminal operation.
- Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
- Returns the first encountered element in the stream.


> The difference b/w findFirst(), findAny() and allMatch(), anyMatch(), noneMatch() is that they returned a boolean
>result while these return the actual object enclosed in Optional.OptionalExample.

> findFirst() and findAny() do not make much difference in normal stream but makes a lot of difference in parallel stream.

[Example: findFirst, findAny](./FindFirstFindAnyExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.Optional;

public class FindFirstFindAnyExample {
    // will return first encountered Student with activity as Robotics Club
    private static Optional<Student> findAny(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getActivities().contains("Robotics Club"))
                .findAny();
    }

    // will return first encountered Student with activity as Robotics Club
    private static Optional<Student> findFirst(){
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getActivities().contains("Robotics Club"))
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> findFirstResult = findFirst();
        findFirstResult.ifPresent(student -> System.out.println("Find First: "+student.getName()));

        Optional<Student> findAnyResult = findAny();
        findAnyResult.ifPresent(student -> System.out.println("Find Any: "+student.getName()));
    }
}
```
Output:
```shell
Find First: Rishi
Find Any: Rishi
```
</details>


### collect
- The collect() method takes in an input of type **Collector**.
- produces the result as per the input passed to the collect() method.
- It works like an accumulator that is going to accumulate the result until the stream is exhausted. 

[Collectors](./collectors/README.md) is the implementation of **Collector** interface that provides various useful 
reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.

[Collectors](./collectors/README.md)

## Numeric Streams

[Numeric streams](numeric_streams/README.md) (IntStream, LongStream, DoubleStream) are specialized stream designed specifically for
working with primitive numeric types (int, long, double).

They provide a set of operations and methods optimized for numerical computations, offering improved performance and
convenience when dealing with numeric data.

[Numeric streams](numeric_streams/README.md)

## Parallel Streams

One of the enhancements that came with streams was the ability to execute operations in parallel, known as Parallel Streams.

[Parallel Streams](./parallel_streams/README.md) allows to perform stream operations concurrently on multiple threads, harnessing the full potential of multi-core processors. <br>
While normal streams execute operations sequentially on a single thread, parallel streams divide the workload into smaller tasks and distribute them across multiple threads,
leading to potentially significant performance improvements.

[Parallel Streams](./parallel_streams/README.md)