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