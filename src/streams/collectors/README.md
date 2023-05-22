# Collectors class

Implementation of **Collector** interface that implements various useful reduction operations,
such as accumulation of elements into collections, summarizing elements according to various criteria, etc.

It provides a set of predefined collectors that are commonly used to perform various aggregation 
and reduction operations on streams. <br>
These collectors are used in conjunction with the [collect](../README.md#collect) method of the Stream interface to accumulate elements 
from a stream into a mutable result container or perform various other operations.

## Some important collectors provided by the Collectors class:

###  toList

`public static <T> Collector<T,?,List<T>> toList()`

- Returns a Collector that accumulates the input elements into a new List.
- There are no guarantees on the type, mutability, serializability, or thread-safety of the List returned;
- if more control over the returned List is required, use toCollection(Supplier).

[Example: toList](./ToListExample.java)

<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.stream.Collectors;

public class ToListExample {
    //list of Computer Science students
    private static List<Student> getAllComputerScienceStudents() {
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Student> computerScienceStudents = getAllComputerScienceStudents();
        System.out.println("Computer Science students: ");
        computerScienceStudents.forEach(student -> System.out.println(student.getName()));
    }
}
```
Output:
```shell
Computer Science students: 
Aarav
Rohan
Isha
Ishita
Sahil
```
</details>

### toSet

`public static <T> Collector<T,?,Set<T>> toSet()`

- Returns a Collector that accumulates the input elements into a new Set.
- There are no guarantees on the type, mutability, serializability, or thread-safety of the Set returned;
- if more control over the returned Set is required, use toCollection(Supplier).
- This is an unordered Collector.

[Example: toSet](./ToSetExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
package streams.collectors;

/*
 * Example demonstrating Collectors method: toList
 */

import streams.data.Student;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToSetExample {

    //to retrieve all the available activities among students
    private static Set<String> getAllActivities() {
        return Student.getAllStudents() //List<Student>
                .stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .collect(Collectors.toSet());
    }
    public static void main(String[] args) {
        System.out.println("All available activities: "+getAllActivities());
    }
}
```
Output:
```shell
All available activities: [Photography, Coding Club, Art, Music, Dance, Debate Club, Guitar Club, Robotics Club, Sports]
```
</details>

### toMap

`public static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)`

- Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.
- If the mapped keys contains duplicates (according to Object.equals(Object)), an **IllegalStateException** is thrown when the collection operation is performed. 

[Example: toMap](./ToMapExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapExample {

    //get student roll and name map
    private static Map<Integer, String> getStudentRollNamesMap() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.toMap(Student::getRollNo,Student::getName));
    }
    public static void main(String[] args) {
        System.out.println("Student Roll and Name: "+getStudentRollNamesMap());
    }
}
```
Output:
```shell
 Student Roll and Name: {201=Rohan, 202=Sia, 203=Rishi, 204=Aryan, 401=Arjun, 402=Kavya, 403=Karan, 404=Anika, 601=Raj, 602=Rahul, 603=Prachi, 604=Diya, 101=Aarav, 102=Rohan, 103=Isha, 104=Ishita, 105=Sahil, 301=Aryan, 302=Ved, 303=Varun, 304=Nisha, 501=Neha, 502=Ravi, 503=Tanvi, 504=Diya}
```
</details>

### toCollection

`public static <T,C extends Collection<T>> Collector<T,?,C> toCollection(Supplier<C> collectionFactory)`

- Returns a Collector that accumulates the input elements into a new Collection, in encounter order.
- The Collection is created by the provided factory.
- Type Parameters:
    - T - the type of the input elements
    - C - the type of the resulting Collection
- Parameters:
    - collectionFactory - a Supplier which returns a new, empty Collection of the appropriate type
- Returns:
    - a Collector which collects all the input elements into a Collection, in encounter order

[Example: toCollection](./ToCollectionExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToCollectionExample {
    //list of Computer Science students
    private static List<Student> getAllComputerScienceStudents() {
        return Student.getAllStudents()
                .stream()
                .filter(student -> student.getDepartment().equals("Computer Science"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        List<Student> computerScienceStudents = getAllComputerScienceStudents();
        System.out.println("Computer Science students: ");
        computerScienceStudents.forEach(student -> System.out.println(student.getName()));
    }
}
```
Output:
```shell
Computer Science students:
Aarav
Rohan
Isha
Ishita
Sahil

```
</details>