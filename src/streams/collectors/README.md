# Collectors class
- Implementations of Collector interface that implement various useful reduction operations,
  such as accumulating elements into collections, summarizing elements according to various criteria, etc.

##operations:

---
## toList
### `public static <T> Collector<T,?,List<T>> toList()`

- Returns a Collector that accumulates the input elements into a new List. 
- There are no guarantees on the type, mutability, serializability, or thread-safety of the List returned; 
- if more control over the returned List is required, use toCollection(Supplier).

---
## toSet
### `public static <T> Collector<T,?,Set<T>> toSet()`

- Returns a Collector that accumulates the input elements into a new Set. 
- There are no guarantees on the type, mutability, serializability, or thread-safety of the Set returned; 
- if more control over the returned Set is required, use toCollection(Supplier).
- This is an unordered Collector.

---
## toMap
### `public static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)`

- Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.
- If the mapped keys contains duplicates (according to Object.equals(Object)), an IllegalStateException is thrown when the collection operation is performed. 

---
## toCollection
### `public static <T,C extends Collection<T>> Collector<T,?,C> toCollection(Supplier<C> collectionFactory)`

- Returns a Collector that accumulates the input elements into a new Collection, in encounter order. 
- The Collection is created by the provided factory.
- Type Parameters:
  - T - the type of the input elements
  - C - the type of the resulting Collection
- Parameters:
  - collectionFactory - a Supplier which returns a new, empty Collection of the appropriate type
- Returns:
  - a Collector which collects all the input elements into a Collection, in encounter order

----

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

Ex:
```java
public class App{
    
  private static String joining(List<String> list){
    return list.stream()
            .collect(Collectors.joining());
  }
  
  private static String joiningWithDelimiter(List<String> list){
    return list.stream()
            .collect(Collectors.joining(","));
  }

  private static String joiningWithDelimiterAndPrefixSuffix(List<String> list){
    return list.stream()
            .collect(Collectors.joining("_","[","]"));
  }
  public static void main(String[] args) {
    List<String> fruits = Arrays.asList("Mango","Apple","Watermelon");
    System.out.println("Joining1: "+joining(fruits));
    System.out.println("Joining2: "+joiningWithDelimiter(fruits));
    System.out.println("Joining3: "+joiningWithDelimiterAndPrefixSuffix(fruits));
  }
}
```
>Output:<br>
> Joining1: MangoAppleWatermelon<br>
> Joining2: Mango,Apple,Watermelon<br>
> Joining3: [Mango,Apple,Watermelon]

----
## counting
### `public static <T> Collector<T,?,Long> counting()`
- Returns a Collector accepting elements of type T that counts the number of input elements. 
- If no elements are present, the result is 0.
- returns the total number elements as a result.

```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int greaterThan5 = integerList
            .stream()
            .filter(i->i>5)
            .collect(Collectors.counting());
    System.out.println("No. of elements greater tha 5 in the list: "+greaterThan5); //5
  }
}
```

---
## mapping
### `public static <T,U,A,R> Collector<T,?,R> mapping(Function<? super T,? extends U> mapper,Collector<? super U,A,R> downstream)` 

- Adapts a Collector accepting elements of type U to one accepting elements of type T by applying a mapping function
to each input element before accumulation.
- applies a transformation function first and then collects the data in a collection.

[MappingExample](MappingExample.java)

---
## maxBy
### `public static <T> Collector<T,?,Optional.OptionalExample<T>> maxBy(Comparator<? super T> comparator)`

- Returns a Collector that produces the maximal element according to a given Comparator, described as an `Optional.OptionalExample<T>`.

## minBy
### `public static <T> Collector<T,?,Optional.OptionalExample<T>> minBy(Comparator<? super T> comparator)`

-Returns a Collector that produces the minimal element according to a given Comparator, described as an `Optional.OptionalExample<T>`.

#### minBy and maxBy Example:

```java
import Optional.OptionalExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional.OptionalExample;
import java.util.stream.Collectors;

public class MinByMaxByExample {
  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Optional.OptionalExample<Integer> maxElement = integerList
            .stream()
            .collect(Collectors.maxBy(Comparator.naturalOrder()));

    Optional.OptionalExample<Integer> minElement = integerList
            .stream()
            .collect(Collectors.minBy(Comparator.naturalOrder()));

    maxElement.ifPresent(integer -> System.out.println("Max element in list: " + integer)); // 10
    minElement.ifPresent(integer -> System.out.println("Min element in list: " + integer)); // 1
  }
}

```

---
## summing

- Returns a Collector that produces the sum of values obtained from the function applied to the input elements.
- If no elements are present, the result is 0.

### `public static <T> Collector<T,?,Integer> summingInt(ToIntFunction<? super T> mapper)`

### `public static <T> Collector<T,?,Long> summingLong(ToLongFunction<? super T> mapper)`

### `public static <T> Collector<T,?,Double> summingDouble(ToDoubleFunction<? super T> mapper)`

[Example](SummingIntExample.java);

---
## averaging

- Returns a Collector that produces the arithmetic mean of a values obtained from the function applied to the input elements. 
- If no elements are present, the result is 0.

### `public static <T> Collector<T,?,Double> averagingInt(ToIntFunction<? super T> mapper)`

### `public static <T> Collector<T,?,Double> averagingLong(ToLongFunction<? super T> mapper)`

### `public static <T> Collector<T,?,Double> averagingDouble(ToDoubleFunction<? super T> mapper)`

[Example](AveragingDoubleExample.java)

---
## groupingBy

- Used to group the elements based on a property.
- This method has a similar functionality to the "GROUP BY" statement in SQL.
- groupingBy has three overloaded versions.
- The output of the groupingBy() is going to be a Map<K,V>

### Collectors.groupingBy() with a Classification Function 
###`public static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)`

- This method returns a Collector that groups the input elements of type T according to the classification function, 
and returns the result in a Map.
- The classification function maps elements to a key of type K. 
- The collector makes a Map<K, List<T>>, whose keys are the values resulting from applying the 
classification function on the input elements.
- The classifier function also defined the keys for the resulting map.
- The values of those keys are Lists containing the input elements which map to the associated key.

### Collectors.groupingBy() with a Classification Function and Downstream Collector
### `public static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier,Collector<? super T,A,D> downstream)`
- When just grouping isn't quite enough - you can also supply a downstream collector to the groupingBy() method
- This method returns a Collector that groups the input elements of type T according to the classification function, 
afterwards applying a reduction operation on the values associated with a given key using the specified downstream Collector.
- It takes two parameters
  - A mapper - a function to be applied to the input elements and map them // It also defines the keys for the resulting map.
  - A downstream collector – a collector which will accept mapped values // second argument can be of any type of collector

[Example](GroupingByExample2.java)

### Collectors.groupingBy() with a Classification Function, Downstream Collector and Supplier
```java
    public static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M>
               groupingBy(Function<? super T,? extends K> classifier,
               Supplier<M> mapFactory,
               Collector<? super T,A,D> downstream)
```

- The third and final overloaded groupingBy() method variant takes the same two parameters as before, 
but with the addition of one more - a supplier method.

- This method provides the specific Map implementation we want to use to contain our end result
- This implementation differs from the previous one only slightly.
- It returns a Collector that groups the input elements of type T according to the classification function,
afterwards applying a reduction operation on the values associated with a given key using the specified downstream Collector. 
Meanwhile, the Map is implemented using the supplied mapFactory supplier.
- This differs from previous in just one sense, in the previous method HashMap was being supplied by default to contain end result
but, here in the custom Map implementation will be provided.

[Example](GroupingByExample3.java)
---
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
### `public static <T,D,A> Collector<T,?,Map<Boolean,D>> partitioningBy(Predicate<? super T> predicate,Collector<? super T,A,D> downstream)`

- Returns a Collector which partitions the input elements according to a Predicate, reduces the values in 
each partition according to another Collector, and organizes them into a Map<Boolean, D>
whose values are the result of the downstream reduction.
- downstream : could be of any collector

[partitionBy Example](PartitioningByExample.java)