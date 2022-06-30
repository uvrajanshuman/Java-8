# Streams
- Stream is a sequence of elements which can be created out of a collection such as List or Arrays or any kind of I/O 
resources.
- Introduced in Java8; included in java.util.stream package.

- Parallel operations are easy to perform with Streams API without having to spawn multiple threads.
- Streams API can also be used with arrays or any kind of I/O.

- Streams don’t change the original data structure, they are created out of a collection and provides the result as per
the pipelined methods.
- Stream elements can be used only once its life; if an attempt is made to access it later 
an IllegalStateException is thrown.

## Collections and Streams

| Collection                                                                                                                      | Streams                                                                            |
|---------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|
| If there is need to represent a group of individual objects as single entity, go for collections.                               | If there is need to process a group of objects from the collection go for Streams. |
| Can add or modify elements at any point in time <br>Ex:List:- list.add(element)                                                 | Cannot add or modify elements in a stream. It is a fixed data set.                 |
| Elements in the collection can be accessed in any order. Use appropriate method based on collection <br/>Ex: List:- list.get(4) | Elements in the Stream can be accessed only in sequence                            |
| Collections are eagerly constructed                                                                                             | Streams are lazily constructed.                                                    |
| Collections can be traversed "n" numner of times.                                                                               | Streams can be traversed only once.                                                |

- A Stream object can be created out of a Collection using the stream() method of collection interface.
- `default Stream stream()` is a default method added to Collection in Java 1.8.
- Ex: `Stream s = list.stream();`

## Advantages of using Stream:
- Efficient and shortcode.
- Streams provide a very easy way to do parallel computation without having 
to worry about the multi-threading implementations.
- Streams provide a large set of operations that can be utilized in many scenarios.
- It provides a more memory efficient way as the stream is closed, once it’s consumed and 
there are no extra objects and variables created which lingers on, waiting to be garbage collected.
- With the use of lambda expressions, a wide range of functionalities can be implemented.

Ex: collecting even number from a list
- without streams:
  ```java
    List<Integer> numbersList = Arrays.asList(10, 15, 20, 25);
    List<Integers> evenNumbersList = new ArrayList<>();
    for(int n: numbersList){
        if(n % 2 == 0){
            evenNumbersList.add(n);
          }
    }
  ```
- with streams:
```java
  List<Integer> numbersList = Arrays.asList(10, 15, 20, 25);

  List<Integer>evenNumbersList = numbersList.stream()
                                  .filter(i -> i % 2 == 0)
                                  .collect(Collectors.toList());
```

## Stream pipeline:
- A Stream pipeline consists of a stream source, zero or more intermediate operations and a terminal operation.
  ![Stream Pipeline](../../resources/images/java-streams.png)

### Source
- The Stream can be generated from array, Set, List, Map or any Collection or any kind of I/O resources.
- Ex:
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
- In a stream pipeline, there can be one or more intermediate operations.
- Each intermediate operation consumes a stream and produces another stream as per the implemented logic.
- Intermediate operation can be of two types:
    1. Stateless: 
       - Operation's which does not require to maintain the state of the stream and has nothing to do with
               the other elements of the stream. ex: map(), peek() etc.
       - does not needs the state of the previously processed elements.
    2. Stateful: 
       - Operation's in which elements can't be processed individually and they are required to do some
            comparision with other elements. ex: distinct(), sorted(), limit() etc.
       - needs the state of the previously processed elements.
       
- Intermediate operations:
    - filter
    - map
    - flatMap
    - peek
    - distinct 
    - sorted
    - limit
    - skip


### Terminal operations
- In a stream pipeline, there can be only one terminal operation that produce some result.
- It consumes a stream but doesn't produce a stream.
- Terminal operations starts the whole stream pipeline.
- Terminal operations:
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
> Streams are lazy, no intermediate operations will be invoked until the terminal operation is invoked.<br>
> The terminal method starts the pipeline<br>
> Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations 
> can be pipelined. Terminal operations mark the end of the stream and return the result.

### Stream pipeline Demonstration:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }
    
    public int getMarks(){
        return marks;
    }
}

public class App {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Anshuman",90),
                new Student("Yuvraj",98),
                new Student("Amay",85),
                new Student("Saurabh",55),
                new Student("Ankit",29),
                new Student("Archit",20),
                new Student("Aditya",30)
        );

        List<String> passStudents = students.stream()  //Stream<Student>
                .filter(student -> student.getMarks() >= 30) //Stream<Student>
                .map(Student::getName) // Stream<String>
                .collect(Collectors.toList()); // List<String>

        System.out.println("Pass Students: "+passStudents);
    }
}
```
![Stream Pipeline](../../resources/images/stream-pipeline.png)

> Note: <br>
> In stream pipeline each element is passed one by one through the pipeline operation.<br>
> i.e: all the pipeline operation are performed for 1st element before going for the 2nd element

----
## Stream API factory methods:

### of <br> static <T> Stream<T> of(T... values) 

- Returns a sequential ordered stream whose elements are the specified values.
- creates a stream of certain values passed to this method.
Ex:
```java
Stream<String> fruitStream = Stream.of("apple", "oranges", "banana","pineapple","guava","apple","mango");
```

### iterate <br> static <T> Stream<T> iterate(T seed,
                             UnaryOperator<T> f)

- Returns an infinite sequential ordered Stream produced by iterative application of a function f to an initial element seed, 
producing a Stream consisting of seed, f(seed), f(f(seed)), etc.
- The first element (position 0) in the Stream will be the provided seed. 
- For n > 0, the element at position n, will be the result of applying the function f to the element at position n - 1.
- Note: `limit(maxSize)` is used to limit this infinite Stream.
Ex:
```java
Stream<Integer> stream = Stream.iterate(1, x->x*2);
```

### generate <br> static <T> Stream<T> generate(Supplier<T> s)

- Returns an infinite sequential unordered stream where each element is generated by the provided Supplier. 
- This is suitable for generating constant streams, streams of random elements, etc.
- Note: `limit(maxSize)` is used to limit this infinite Stream.
Ex:
```java
Supplier<Integer> intSupplier = new Random()::nextInt;
Stream<Integer> randomIntStream = Stream.generate(intSupplier)
```

----
## Stream Operations:

### peek: <br> `Stream<T> peek(Consumer<? super T> action)`
- This is an intermediate operation.
-Returns a stream consisting of the elements of the provided stream, additionally performing the provided action on 
each element as elements are consumed from the resulting stream.
- It accepts a consumer and is basically used to apply a operation on the stream.
- It can also used to debug stream and get a view of what gets between the stream operations.
(some operations can be applied as well)

Ex: from prev. example 
- to get the view of what is being passed from one operation to the other operation.
```java
List<String> passStudents = students.stream()  
        .peek(student -> System.out.println(student)}) // prints the stream at this position
        .filter(student -> student.getMarks() >= 30) 
        .peek(System.out::println) // prints the stream at this position (after filter operation)
        .map(Student::getName) 
        .peek(System.out::println) // prints the stream at this position (after map operation)
        .collect(Collectors.toList());
```

### filter: <br> `Stream<T> filter(Predicate<? super T> predicate)`
- This is an intermediate operation.
- Returns a new stream consisting of the elements of the given stream that match the supplied predicate.
- Ex: To filter out even numbers from a list

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

### map <br> `<R> Stream<R> map(Function<? super T,? extends R> mapper)`
- This is an intermediate operation.
- Returns a new stream consisting of the results of applying the supplied Function to the elements of the given stream.
- It performs operation on every element of stream and converts/transforms them from one type to another.
- Ex: To transform strings of a list in uppercase and print it to console.

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

### flatMap <br> `Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)`

- This is an intermediate operation.
- Returns a stream consisting of the results of replacing each element of this stream with the contents of
a mapped stream produced by applying the provided mapping function to each element. 
- Each mapped stream is closed after its contents have been placed into this stream. 
(If a mapped stream is null an empty stream is used, instead.)
- converts/transforms one type to another like map()
- used in context of Stream where each element in the stream represents multiple elements.
- Each Stream elements represent multiple elements.
- Ex: Stream<List>, Stream<Arrays>
- It is generally used when the stream is complex (contains multiple collections)

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    List<Integer> subList1 = Arrays.asList(1, 2);
    List<Integer> subList2 = Arrays.asList(3, 4);
    List<Integer> subList3 = Arrays.asList(5, 6);
    
    List<List<Integer>> list = Arrays.asList(subList1, subList2, subList3);

    List<Integer> collectedList = list.stream() // Stream<List<Integer>>
            .flatMap(list -> list.stream()) // Stream<Integer>
            .collect(Collectors.toList()); // List<Integer>
  }
}
```

### distinct <br> `Stream<T> distinct()`

- This is a stateful intermediate operation.
- Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
- Returns a stream with unique elements

### count <br> `long count()`

- This is a terminal operation.
- Returns the count of elements in this stream.

### sorted <br> `Stream<T> sorted()`

- This is a stateful intermediate operation.
- Returns a stream consisting of the elements of this stream, sorted according to **natural order**. 
- If the elements of this stream are not Comparable, 
a java.lang.ClassCastException may be thrown when the terminal operation is executed.

### sorted <br> `Stream<T> sorted(Comparator<? super T> comparator)`
  
- This is a stateful intermediate operation.
- Returns a stream consisting of the elements of this stream, sorted according to the provided **Comparator**.
- If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown 
when the terminal operation is executed.
- Sort the elements in the stream


### reduce <br> `T reduce(T identity,BinaryOperator<T> accumulator)`

- This is a terminal operation.
- **Used to reduce the contents of a stream to a single value.**
- Performs a reduction on the elements of this stream, using the provided identity value 
and an associative accumulation function, and returns the reduced value. 
- This is equivalent to:
  ```java
    T result = identity;
    for (T element : this stream)
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

### reduce <br> `Optional<T> reduce(BinaryOperator<T> accumulator)`

- This is a terminal operation.
- **Used to reduce the contents of a stream to a single value.**
- Performs a reduction on the elements of this stream, using an associative accumulation function, 
and returns an Optional describing the reduced value, if any. 
- This is equivalent to:
  ```java
    boolean foundAny = false;
    T result = null;
    for (T element : this stream) {
    if (!foundAny) {
    foundAny = true;
    result = element;
    }
    else
    result = accumulator.apply(result, element);
    }
    return foundAny ? Optional.of(result) : Optional.empty();
  ```

- The accumulator function must be an associative function.

Ex:

```java
import java.util.Optional;

public class App {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 3, 5, 7);

    Optional<Integer> totalSum = integerList.stream()
            .reduce((a, b) -> a + b);

    if(totalSum.isPresent())
     System.out.println(totalSum.get());
  }
}
```
> In the above ex. in first cycle 1 will be assigned to a and first cycle will end here ony; as there is not initial vale provided explicitly<br>
> In second cycle a will be holding previous sum (1) and b will be assigned 3; the sum will be calculated and assigned back to a <br>
> The cycle will continue so on. The accumulation will be done and final result will be returned.

### max <br> `Optional<T> max(Comparator<? super T> comparator)`

- This is a terminal operation.
- Returns the maximum element of this stream according to the provided Comparator. 
- This is a special case of a reduction.

### min <br> `Optional<T> min(Comparator<? super T> comparator)`

- This is a terminal operation.
- Returns the minimum element of this stream according to the provided Comparator. 
- This is a special case of a reduction.

> min and max Ex:

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class App {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
    Optional<Integer> minElement = integerList.stream()
            .min(Comparator.naturalOrder());
    Optional<Integer> maxElement = integerList.stream()
            .max(Comparator.naturalOrder());
    
    minElement.ifPresent(integer -> System.out.println("Minimum element in the list: " + integer)); // 1
    maxElement.ifPresent(integer -> System.out.println("Maximum element in teh list:"+integer)); // 6
  }
}
```

### limit <br> `Stream<T> limit(long maxSize)`

- This is a short-circuiting stateful intermediate operation.
- Helps to create a sub-stream.
- Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
- maxSize - the number of elements the returned stream should be limited to.
- limit(n) : limits the "n" no. of elements to be processed in the stream.

Ex: sum of first three numbers of a integer list

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
    
    if(firstThreeSum.isPresent())
        System.out.println("Sum: "+firstThreeSum.get()); // 6
  }
}
```

### skip <br> `Stream<T> skip(long n)`

- This is a stateful intermediate operation.
- Helps to create a sub-stream
- Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. 
- If this stream contains fewer than n elements then an empty stream will be returned.
- n - the number of leading elements to skip
- skip(n) : skips the "n" no of elements from the stream.

Ex: skip first three numbers of a integer list and find sum of remaining.

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
    
    if(skiThreeSum.isPresent())
        System.out.println("Sum: "+skipThreeSum.get()); // 15
  }
}
```

### anyMatch <br> `boolean anyMatch(Predicate<? super T> predicate)`

- This is a short-circuiting terminal operation.
- Takes a predicate as an input and returns a Boolean result.
- Returns whether any elements of this stream match the provided predicate. 
- Returns true if any one of the element matches the predicate, otherwise false
- May not evaluate the predicate on all elements if not necessary for determining the result. 
- If the stream is empty then false is returned and the predicate is not evaluated.

### allMatch <br> `boolean allMatch(Predicate<? super T> predicate)`

- This is a short-circuiting terminal operation.
- Takes a predicate as an input and returns a Boolean result.
- Returns whether all elements of this stream match the provided predicate.
- Returns true if all the element matches the predicate, otherwise false
- May not evaluate the predicate on all elements if not necessary for determining the result. 
- If the stream is empty then true is returned and the predicate is not evaluated.

### noneMatch <br> `boolean noneMatch(Predicate<? super T> predicate)`

- This is a short-circuiting terminal operation.
- Takes a predicate as an input and returns a Boolean result.
- Returns true if none of the element matches the predicate, otherwise false
- Returns whether no elements of this stream match the provided predicate. 
- May not evaluate the predicate on all elements if not necessary for determining the result. 
- If the stream is empty then true is returned and the predicate is not evaluated.
- Just opposite of allMatch()


Ex: anyMatch(), allMatch(), noneMatch()
```java
import java.util.Arrays;
import java.util.List;

public class App {
  
    //Predicate to check if a number is even or not.
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

        System.out.println("Any match demo for mixedList: "+checkIfAnyEven(mixedList)); // true
        System.out.println("Any match demo for evenList: "+checkIfAnyEven(evenList)); // true
        System.out.println("Any match demo for oddList: "+checkIfAnyEven(oddList)); // false

        System.out.println("None match demo for mixedList: "+checkIfNoneEven(mixedList)); // false
        System.out.println("None match demo for evenList: "+checkIfNoneEven(evenList)); // false
        System.out.println("None match demo for oddList: "+checkIfNoneEven(oddList)); // true
    }
}

```

### findFirst <br> Optional<T> findFirst()

- This is a short-circuiting terminal operation.
- Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty. 
- Returns the first element in the stream.

### findAny <br> Optional<T> findAny()
- This is a short-circuiting terminal operation.
- Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
-Returns the first encountered element in the stream.


> The difference b/w findFirst(), findAny() and allMatch(), anyMatch(), noneMatch() is that they returned a boolean
>result while these return the actual object enclosed in Optional.

> findFirst() and findAny() do not make much difference in normal stream but makes a lot of difference in parallel stream.


### collect
- The collect() method takes in an input of type collector
- produces the result as per the inpur passed to the collect() mehtod.
- It works like an accumulator that is going to accumulate the result until the stream is exhausted. 
---
### Numeric Streams


---
## Collectors class
- Implementations of Collector interface that implement various useful reduction operations, 
such as accumulating elements into collections, summarizing elements according to various criteria, etc.

//TODO: mapToInt,mapToLong, mapToDouble,toArray,empty,builder