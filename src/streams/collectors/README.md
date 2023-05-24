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

## joining

- Returns a Collector that concatenates the input elements into a String, in encounter order.
- joining has three different overloaded versions.

### public static Collector<CharSequence,?,String> joining()`
- Returns a Collector that concatenates the input elements into a String, in encounter order.

### `public static Collector<CharSequence,?,String> joining(CharSequence delimiter)`
- Returns a Collector that concatenates the input elements into a string,
  separated by the specified delimiter, in encounter order.

### `public static Collector<CharSequence,?,String> joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix)`
- Returns a Collector that concatenates the input elements,
  separated by the specified delimiter, with the specified prefix and suffix, in encounter order.

[Example: joining methods](./JoiningExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
/*
 * Example demonstrating Collectors method: joining and its overloaded versions
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {

    // joining
    private static String joining(List<String> list) {
        return list.stream()
                .collect(Collectors.joining());
    }

    //joining(delimiter)
    private static String joiningWithDelimiter(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(","));
    }

    //joining(delimiter, prefix, suffix)
    private static String joiningWithDelimiterAndPrefixSuffix(List<String> list) {
        return list.stream()
                .collect(Collectors.joining("_", "[", "]"));
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango", "Apple", "Watermelon");
        System.out.println("Joining1: " + joining(fruits));
        System.out.println("Joining2: " + joiningWithDelimiter(fruits));
        System.out.println("Joining3: " + joiningWithDelimiterAndPrefixSuffix(fruits));
    }
}
```
Output:
```shell
Joining1: MangoAppleWatermelon
Joining2: Mango,Apple,Watermelon
Joining3: [Mango_Apple_Watermelon]
```
</details>

## counting

`public static <T> Collector<T,?,Long> counting()`
- Returns a Collector accepting elements of type T that counts the number of input elements.
- If no elements are present, the result is 0.
- returns the total number elements as a result.

[Example: counting](./CountingExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.stream.Collectors;

public class CountingExample {
  //to get count of Computer Science students
  private static long countCseStudents(){
    return Student.getAllStudents()
            .stream()
            .filter(student -> student.getDepartment().equals("Computer Science"))
            .collect(Collectors.counting());
    // can also be replaced with just .count
  }
  public static void main(String[] args) {
    System.out.println("No. of CSE students: "+countCseStudents());
  }
}
```
Output:
```shell
No. of CSE students: 5
```
</details>

### mapping

`public static <T,U,A,R> Collector<T,?,R> mapping(Function<? super T,? extends U> mapper,Collector<? super U,A,R> downstream)`

- used to transform the elements of a stream before collecting them into a collection or performing other operations. 
- It allows you to apply a mapping function to the stream elements and collect the results into a collection or perform additional operations on the mapped values
- The mapping function takes two parameters:
  - mapper: The first parameter is a function that maps the original elements of the stream to another type. This function is applied to each element of the stream.
  - downstream: The second parameter is a downstream collector that specifies how the mapped values should be collected or further processed.
    It is another collector that defines how the mapped values should be collected or processed further. It can be any valid collector from the **Collectors** class.

[Example: mapping](./MappingExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MappingExample {
    public static void main(String[] args) {

        Set<String> namesSet = Student.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toSet()));
        /*
         * Equivalent to:
         * Student.getAllStudents().stream()
         *  .map(Student::getName)
         *  .collect(Collectors.toSet());
         */

        List<String> namesList = Student.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toList()));
        /*
         * Equivalent to:
         * Student.getAllStudents().stream()
         *  .map(Student::getName)
         *  .collect(Collectors.toList());
         */

        System.out.println("Names Set: "+namesSet);
        System.out.println("Names List: "+namesList);
    }
}
```
Output:
```shell
Names Set: [Isha, Rahul, Sahil, Ravi, Aarav, Kavya, Karan, Rishi, Varun, Sia, Nisha, Diya, Rohan, Ishita, Prachi, Ved, Neha, Anika, Tanvi, Raj, Arjun, Aryan]
Names List: [Aarav, Rohan, Isha, Ishita, Sahil, Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
```
</details>

### minBy

`public static <T> Collector<T,?,Optional<T>> minBy(Comparator<? super T> comparator)`

- Returns a Collector that produces the minimal element according to a given Comparator, described as an `Optional<T>`.

The minBy collector takes a comparator as a parameter and returns an Optional object containing the minimum element according to the provided comparator. I
If the stream is empty, the Optional will be empty as well.

### maxBy

`public static <T> Collector<T,?,Optional<T>> maxBy(Comparator<? super T> comparator)`

- Returns a Collector that produces the maximal element according to a given Comparator, described as an `Optional<T>`.

The maxBy collector also takes a comparator as a parameter and returns an Optional object containing the maximum element based on the comparator.
If the stream is empty, the Optional will be empty.

>The minBy and maxBy collectors in the Collectors class are used to find the minimum and maximum elements of a stream
based on a specific comparator or natural order.

[Example: minBy maxBy](./MinByMaxByExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinByMaxByExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> maxElement = integerList
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        /*
         * Equivalent to:
         * Optional<Integer> maxElement = integerList
         *       .stream().max(Comparator.naturalOrder());
         */

        Optional<Integer> minElement = integerList
                .stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        /*
         * Equivalent to:
         * Optional<Integer> minElement = integerList
         *       .stream().min(Comparator.naturalOrder());
         */

        maxElement.ifPresent(integer -> System.out.println("Max element in list: " + integer)); // 10
        minElement.ifPresent(integer -> System.out.println("Min element in list: " + integer)); // 1
    }
}
```
Output:
```shell
Max element in list: 10
Min element in list: 1
```
</details>

### summingInt, summingLong, summingDouble

- The summingInt, summingLong, and summingDouble methods in the Collectors class are used to calculate the sum of numeric values in a stream.
- Returns a Collector that produces the sum of values obtained from the mapper function applied to the input elements.
- The collector takes a mapping function that extracts an int/long/double primitive value from each element of the stream, 
and returns the sum of those extracted values.
- If no elements are present, the result is 0.

`public static <T> Collector<T,?,Integer> summingInt(ToIntFunction<? super T> mapper)`

`public static <T> Collector<T,?,Long> summingLong(ToLongFunction<? super T> mapper)`

`public static <T> Collector<T,?,Double> summingDouble(ToDoubleFunction<? super T> mapper)`

[Example: summingInt](./SummingIntExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
package streams.collectors;

/*
 * Example demonstrating Collectors method: summingInt
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SummingIntExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum: " + sum);
    }
}
```
Output:
```shell
Sum: 15
```
summingLong and summingDouble collectors can be used in a similar way to calculate the sum of long and double values, respectively.
</details>

### averagingInt, averagingLong, averagingDouble

- The averagingInt, averagingLong and averagingDouble methods in the Collectors class are used to calculate the average of numeric values in a stream.
- The collector takes a mapping function that extracts an int/long/double primitive value from each element of the stream,
    and returns the average (double value) of those extracted values.
- Returns a Collector that produces the arithmetic mean of a values obtained from the function applied to the input elements.
- If no elements are present, the result is 0.

### `public static <T> Collector<T,?,Double> averagingInt(ToIntFunction<? super T> mapper)`

### `public static <T> Collector<T,?,Double> averagingLong(ToLongFunction<? super T> mapper)`

### `public static <T> Collector<T,?,Double> averagingDouble(ToDoubleFunction<? super T> mapper)`

[Example](./AveragingIntExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
package streams.collectors;

/*
 * Example demonstrating Collectors method: averagingInt
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AveragingIntExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Double average = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("Average: " + average);
    }
}
```
Output:
```shell
Average: 3.0
```
averagingLong and averagingDouble collectors can be used in a similar way to calculate the average of long and double values, respectively.
</details>

## groupingBy

The groupingBy method in the Collectors class is used to group elements of a stream based on a specific criterion.<br>
It creates a Map where the keys are the distinct values of the grouping criterion, and the values are the elements that belong to each group.

- Used to group the elements based on a property.
- This method has a similar functionality to the **GROUP BY** statement in SQL.
- groupingBy has three overloaded versions to provide flexibility in defining the grouping criterion and downstream collectors.
- The output of the groupingBy() is going to be a Map<K,V>

### Collectors.groupingBy() with single attribute (classification function)

`public static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)`

This version takes a classifier function that extracts a key from each element of the stream. The elements are then grouped based on the extracted keys.

- This method returns a Collector that groups the input elements of type T according to the classification function,
  and returns the result in a Map.
- The classification function maps elements to a key of type K.
- The collector makes a Map<K, List<T>>, whose keys are the values resulting from applying the
  classification function on the input elements.
- The classifier function defines the keys for the resulting map.<br>
The values of those keys are Lists containing the input elements which map to the associated key.

[Example: groupingBy(classfierFn)](./GroupingByExample1.java)
<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {
  //group by gender
  private static Map<String, List<Student>> groupingByGender() {
    return Student.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(Student::getGender));
  }

  //group by department
  private static Map<String, List<Student>> groupingByDepartment() {
    return Student.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(Student::getDepartment));
  }

  private static void printStudents(Map<String, List<Student>> groupedMap){
    // Printing the groups
    groupedMap.forEach((k,v)->{
      List<String> studentNames = v.stream().map(Student::getName).collect(Collectors.toList());
      System.out.println(k+" : "+studentNames);});
  }
  public static void main(String[] args) {
    System.out.println("Grouped by gender: ");
    Map<String, List<Student>> genderGrouped = groupingByGender();
    printStudents(genderGrouped);

    System.out.println();
    System.out.println("Grouped by department: ");
    Map<String,List<Student>> deptGrouped = groupingByDepartment();
    printStudents(deptGrouped);
  }
}
```
Output:
```shell
Grouped by gender: 
Female : [Isha, Ishita, Sia, Nisha, Kavya, Anika, Neha, Tanvi, Diya, Prachi, Diya]
Male : [Aarav, Rohan, Sahil, Rohan, Rishi, Aryan, Aryan, Ved, Varun, Arjun, Karan, Ravi, Raj, Rahul]

Grouped by department: 
Civil Engineering : [Arjun, Kavya, Karan, Anika]
Computer Science : [Aarav, Rohan, Isha, Ishita, Sahil]
Electronics and Communication Engineering : [Raj, Rahul, Prachi, Diya]
Mechanical Engineering : [Rohan, Sia, Rishi, Aryan, Diya]
Information Technology : [Neha, Ravi, Tanvi]
Electrical Engineering : [Aryan, Ved, Varun, Nisha]
```
</details>

### Collectors.groupingBy() with two attributes (classification function and downstream collector)

`public static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier,Collector<? super T,A,D> downstream)`

In addition to the classifier function, this version takes a downstream collector that defines how the elements within each group should be collected or processed further.

- When just grouping isn't quite enough - you can also supply a downstream collector to the groupingBy() method
- This method returns a Collector that groups the input elements of type T according to the classification function,
  afterwards applying a reduction operation on the values associated with a given key using the specified downstream Collector.
- It takes two parameters
  - A mapper - a function to be applied to the input elements and map them // It also defines the keys for the resulting map.
  - A downstream collector – a collector which will accept mapped values and accumulate it // second argument can be of any type of collector

[Example: groupingBy(classificationFn, downstreamCollector)](./GroupingByExample2.java)
<details>
  <summary>click to expand/collapse</summary>
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByExample2 {
  //group by gender and then accumulate student in Set
  //1st arg of collect() : defines key to map
  //2nd arg of collect(): defines how values will be accumulated
  private static Map<String, Set<Student>> groupingByGender() {
    return Student.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(Student::getGender,Collectors.toSet()));
  }

  //group by department then accumulate data in map in form of name:gender (key,value) pair
  private static Map<String, Map<Integer,String>> deptRollNameMap() {
    return Student.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(Student::getDepartment,Collectors.toMap(Student::getRollNo,Student::getName)));
  }

  //group by gender then perform count on accumulation of grouped data
  private static Map<String,Long> genderCountMap() {
    return Student.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
  }
  public static void main(String[] args) {
    System.out.println("Set of Students grouped by gender: ");
    groupingByGender().forEach(
            (key, value) -> {
              Set studentNames = value.stream().map(Student::getName).collect(Collectors.toSet());
              System.out.println(key + " : " + studentNames);
            }
    );
    System.out.println();
    System.out.println("{Department : {Roll : Name}} Map \n"+deptRollNameMap());
    System.out.println();
    System.out.println("Gender Count Map: \n"+genderCountMap());

  }
}
```
Output:
```shell
Set of Students grouped by gender: 
Female : [Isha, Prachi, Neha, Anika, Kavya, Tanvi, Sia, Diya, Nisha, Ishita]
Male : [Rahul, Sahil, Ved, Ravi, Aarav, Karan, Varun, Rishi, Raj, Arjun, Aryan, Rohan]

{Department : {Roll : Name}} Map 
{Civil Engineering={401=Arjun, 402=Kavya, 403=Karan, 404=Anika}, Computer Science={101=Aarav, 102=Rohan, 103=Isha, 104=Ishita, 105=Sahil}, Electronics and Communication Engineering={601=Raj, 602=Rahul, 603=Prachi, 604=Diya}, Mechanical Engineering={504=Diya, 201=Rohan, 202=Sia, 203=Rishi, 204=Aryan}, Information Technology={501=Neha, 502=Ravi, 503=Tanvi}, Electrical Engineering={304=Nisha, 301=Aryan, 302=Ved, 303=Varun}}

Gender Count Map: 
{Female=11, Male=14}
```
</details>

### Collectors.groupingBy() with a Classification Function, Downstream Collector and Supplier
```java
    public static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M>
               groupingBy(Function<? super T,? extends K> classifier,
               Supplier<M> mapFactory,
               Collector<? super T,A,D> downstream)
```

- The third and final overloaded groupingBy() method variant takes the same two parameters as before,
  but with the addition of one more - a supplier mapFactory.

- This method provides the specific Map implementation we want to use to contain our end result. The default one other two
overloaded versions was HashMap.
- This implementation differs from the previous one only slightly.
- It returns a Collector that groups the input elements of type T according to the classification function,
  afterwards applying a reduction operation on the values associated with a given key using the specified downstream Collector.
  Meanwhile, the Map is implemented using the supplied mapFactory supplier.
- This differs from previous in just one sense, in the previous method HashMap was being supplied by default to contain end result
  but, here in the custom Map implementation will be provided.

[Example: groupingBy(classifierFn, mapFactory, downstreamCollector)](./GroupingByExample3.java)
<details>
  <summary>lick to expand/collapse</summary>

```java
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingByExample {
  private static LinkedHashMap<String, List<String>> genderStudentNameMap(){
    return Student.getAllStudents()
            .stream()
            .collect(Collectors.groupingBy(
                    Student::getGender,
                    LinkedHashMap::new,
                    Collectors.mapping(Student::getName,Collectors.toList()
                    )));
  }
  public static void main(String[] args) {
    System.out.println("Gender Name Map: "+genderStudentNameMap());
  }
}
```
Output:
```shell
Gender Name Map: {Male=[Aarav, Rohan, Sahil, Rohan, Rishi, Aryan, Aryan, Ved, Varun, Arjun, Karan, Ravi, Raj, Rahul], Female=[Isha, Ishita, Sia, Nisha, Kavya, Anika, Neha, Tanvi, Diya, Prachi, Diya]}
```
</details>

## partitioningBy

- similar to groupingBy
- Return type of the collector is going to be Map<K,V>
- paritioningBy() accepts a predicate as an input.
- The key of the return type is going to be a Boolean.
- partitioningBy has two overloaded versions.

### Collectors.partitioningBy() using a Predicate
### `public static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T> predicate)`

- Returns a Collector which partitions the input elements according to a Predicate,
  and organizes them into a Map<Boolean, List<T>>
- Each of the elements from the Stream are tested against the predicate, and based on the resulting boolean value,
  this Collector groups the elements into two sets and returns the result as Map<Boolean, List<T>>.
- The key of the return type is going to be a Boolean.

### Collectors.partitioningBy() using a Predicate and a Downstream Collector

`public static <T,D,A> Collector<T,?,Map<Boolean,D>> partitioningBy(Predicate<? super T> predicate,Collector<? super T,A,D> downstream)`

- Returns a Collector which partitions the input elements according to a Predicate, reduces the values in
  each partition according to another Collector, and organizes them into a Map<Boolean, D>
  whose values are the result of the downstream reduction.
- downstream : could be of any collector

[Example: partitionBy](./PartitionByExample.java)

<details>
  <summary>click to expand/collapse</summary>

```java
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitionByExample {

    private static Predicate<Student> csePredicate = student -> student.getDepartment().equals("Computer Science");

    private static Map<Boolean, List<Student>> oneArgPartitioningBy() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(csePredicate));
    }

    private static Map<Boolean, List<String>> twoArgPartitioningBy() {
        return Student.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(
                        csePredicate,
                        Collectors.mapping(Student::getName, Collectors.toList()
                        )));
    }

    public static void main(String[] args) {
        System.out.println("PartitionByGrade: ");
        oneArgPartitioningBy().forEach(
                (key, value) -> {
                    List<String> studentNames = value.stream().map(Student::getName).collect(Collectors.toList());
                    System.out.println(key + " : " + studentNames);
                }
        );
        System.out.println();
        System.out.println("PartitionByGrade StudentName Map:");
        twoArgPartitioningBy().forEach((key, value) -> {System.out.println(key+" : "+value);});
    }
}
```
Output:
```shell
PartitionByGrade: 
false : [Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
true : [Aarav, Rohan, Isha, Ishita, Sahil]

PartitionByGrade StudentName Map:
false : [Rohan, Sia, Rishi, Aryan, Aryan, Ved, Varun, Nisha, Arjun, Kavya, Karan, Anika, Neha, Ravi, Tanvi, Diya, Raj, Rahul, Prachi, Diya]
true : [Aarav, Rohan, Isha, Ishita, Sahil]
```
</details>
