# Enhancement of the Comparator Interface in Java 8

The Comparator interface is meant for comparing and sorting objects in collections.

- Prior to Java8, Comparator had only two methods `compare()` and `equals()`. But, The enhanced comparator after Java8 now 
contains 19 methods.
- Java8 also declared the Comparator interface as a FunctionalInterface (annotating with `@FunctionalInterface`), thus lambdas
and method references can also be used now as implementation of the `compare()` method.


## Methods and Usage:
Apart from the SAM (single abstract method) `compare()` and `equals()` method, Comparator now contains several default and static methods:

[Example: Comparator enhancements in Java8](./ComparatorEnhancementsExample.java)
<details>
  <summary>click to expand/collapse</summary>

```java
/*
 * Example demonstrating the enhancements in Comparator interface.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorEnhancementsExample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);
    // naturalOrder()
    numbers.sort(Comparator.naturalOrder());
    System.out.println("Soring numbers in natural order: ");
    System.out.println(numbers);
    System.out.println();

    // reverseOrder()
    numbers.sort(Comparator.reverseOrder());
    System.out.println("Soring numbers in reverse natural order: ");
    System.out.println(numbers);
    System.out.println();

    // comparing()
    List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
    fruits.sort(Comparator.comparing(String::length));
    System.out.println("Sorting fruits by their name length:");
    System.out.println(fruits);
    System.out.println();

    List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Alice",30),
            new Person("Bob", 30),
            new Person("Charlie", 18),
            new Person("Charlie", 20)
    );
    // comparingInt() method
    people.sort(Comparator.comparingInt(Person::getAge));
    System.out.println("Sorting people by age:");
    System.out.println(people);
    System.out.println();

    // reversed()
    Comparator<Person> reversedComparator = Comparator.comparingInt(Person::getAge).reversed();
    people.sort(reversedComparator);
    System.out.println("Sorting people by age in reverse order:");
    System.out.println(people);
    System.out.println();

    // thenComparing() method
    Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
    Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
    Comparator<Person> combinedComparator = ageComparator.thenComparing(nameComparator);
    people.sort(combinedComparator);
    System.out.println("Sorting people by age, then by name:");
    System.out.println(people);
    System.out.println();

    // thenComparing() method with key extractor
    Comparator<Person> combinedComparatorWithKeyExtractor = Comparator.comparing(Person::getName)
            .thenComparing(Person::getAge);
    people.sort(combinedComparatorWithKeyExtractor);
    System.out.println("Sorting people by name, then by age:");
    System.out.println(people);
    System.out.println();

    List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null);
    // nullsFirst() method
    names.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
    System.out.println("Sorting names with null values first:");
    System.out.println(names);
    System.out.println();

    // nullsLast() method
    names.sort(Comparator.nullsLast(Comparator.naturalOrder()));
    System.out.println("Sorting names with null values last:");
    System.out.println(names);
    System.out.println();
  }
}

class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
```
Output:
<details>
  <summary>click to expand/collapse</summary>

```shell
Soring numbers in natural order:
[1, 2, 3, 4, 5]

Soring numbers in reverse natural order:
[5, 4, 3, 2, 1]

Sorting fruits by their name length:
[Apple, Banana, Orange]

Sorting people by age:
[{name='Charlie', age=18}, {name='Charlie', age=20}, {name='Alice', age=25}, {name='Alice', age=30}, {name='Bob', age=30}]

Sorting people by age in reverse order:
[{name='Alice', age=30}, {name='Bob', age=30}, {name='Alice', age=25}, {name='Charlie', age=20}, {name='Charlie', age=18}]

Sorting people by age, then by name:
[{name='Charlie', age=18}, {name='Charlie', age=20}, {name='Alice', age=25}, {name='Alice', age=30}, {name='Bob', age=30}]

Sorting people by name, then by age:
[{name='Alice', age=25}, {name='Alice', age=30}, {name='Bob', age=30}, {name='Charlie', age=18}, {name='Charlie', age=20}]

Sorting names with null values first:
[null, null, Alice, Bob, Charlie]

Sorting names with null values last:
[Alice, Bob, Charlie, null, null]
```
</details>

</details>

### naturalOrder

`static <T extends Comparable<? super T>> Comparator<T> naturalOrder()`
- Returns a comparator that sorts the elements in their natural order
Example:
```java
List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);

//naturalOrder()
numbers.sort(Comparator.naturalOrder()); // Sort in ascending order
System.out.println("Soring numbers in natural order: ");
System.out.println(numbers);
```
Output:
```shell
Soring numbers in natural order: 
[1, 2, 3, 4, 5]
```

### reverseOrder()

`static <T extends Comparable<? super T>> Comparator<T> reverseOrder()`
- Returns a comparator that sorts the elements in their reverse natural order.
Example:
```java
List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);

//reverseOrder()
numbers.sort(Comparator.reverseOrder()); // Sort in descending order
System.out.println("Soring numbers in reverse natural order: ");
System.out.println(numbers); 
```
Output:
```shell
Soring numbers in reverse natural order: 
[5, 4, 3, 2, 1]
```

### comparing()

`static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? superT, ? extends U> keyExtractor)`
- Accepts a keyExtractor Function (functional interface), that specifies the sort keys and returns a Comparator that sorts based
on the natural ordering of specified key.
- The sorting will be done on keys returned by teh keyExtractor function.

```java
List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");

//comparing()
fruits.sort(Comparator.comparing(String::length));
System.out.println("Sorting fruits by their name length:");
System.out.println(fruits);
```
Output:
```shell
Sorting fruits by their name length:
[Apple, Banana, Orange]
```

### comparingInt(), comparingLong(), comparingDouble()

`static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)` <br>
`static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor)` <br>
`static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor)`

- Similar to comparing() method
- Specialized comparing() method for comparing objects based on natural ordering of int,long and double keys (returned by the keyExtractor function) respectively.

```java
List<Person> people=Arrays.asList(
        new Person("Alice",25),
        new Person("Alice",30),
        new Person("Bob",30),
        new Person("Charlie",18),
        new Person("Charlie",20));

//comparingInt()
people.sort(Comparator.comparingInt(Person::getAge));
System.out.println("Sorting people by age:");
System.out.println(people);
```
Output:
```shell
Sorting people by age:
[{name='Charlie', age=18}, {name='Charlie', age=20}, {name='Alice', age=25}, {name='Alice', age=30}, {name='Bob', age=30}]
```

### thenComparing()

`default Comparator<T> thenComparing(Comparator<? super T> other)`
- Many times there is need to sort with multiple sort orders. i.e.:  on more than one attributes of an object. 
- The second level sort order gets used if the first level sort criteria is indecisive.
- Chains multiple comparators to establish the secondary sort criteria.

```java
List<Person> people=Arrays.asList(
        new Person("Alice",25),
        new Person("Alice",30),
        new Person("Bob",30),
        new Person("Charlie",18),
        new Person("Charlie",20));

Comparator<Person> ageComparator=Comparator.comparingInt(Person::getAge);
Comparator<Person> nameComparator=Comparator.comparing(Person::getName);
// thenComparing()
Comparator<Person> combinedComparator=ageComparator.thenComparing(nameComparator);
people.sort(combinedComparator);
System.out.println("Sorting people by age, then by name:");
System.out.println(people);
```
Output:
```shell
Sorting people by age, then by name:
[{name='Charlie', age=18}, {name='Charlie', age=20}, {name='Alice', age=25}, {name='Alice', age=30}, {name='Bob', age=30}]
```

### thenComparing() keyExtractor

`default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor)`

- Similar to thenComparing()
- Performs a secondary sort based on the extracted key's natural order.

```java
List<Person> people=Arrays.asList(
        new Person("Alice",25),
        new Person("Alice",30),
        new Person("Bob",30),
        new Person("Charlie",18),
        new Person("Charlie",20));

// thenComparing() method with key extractor
Comparator<Person> combinedComparatorWithKeyExtractor = Comparator.comparing(Person::getName)
        .thenComparing(Person::getAge);
people.sort(combinedComparatorWithKeyExtractor);
System.out.println("Sorting people by name, then by age:");
System.out.println(people);
```
Output:
```shell
Sorting people by name, then by age:
[{name='Alice', age=25}, {name='Alice', age=30}, {name='Bob', age=30}, {name='Charlie', age=18}, {name='Charlie', age=20}]
```

> thenComparing methods also have overloaded versions for int, long, double as thenComparingInt(), thenComparingLong(), thenComparingDouble()
### nullsFirst()

`default Comparator<T> nullsFirst()`

- used to handle **_null_** values while sorting.
- Returns a comparator that considers **_null_** values lower than non-null values (as per the compare method).
- so, the **_null_** values will come before the non-null values

```java
List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null);
        
// nullsFirst() method
names.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
System.out.println("Sorting names with null values first:");
System.out.println(names);
```
Output:
```shell
Sorting names with null values first:
[null, null, Alice, Bob, Charlie]
```

### nullsLast

`default Comparator<T> nullsLast()`

- used to handle **_null_** values while sorting.
- Returns a comparator that considers **_null_** values higher than non-null values (as per the compare method).
- so, the **_null_** values will come after the non-null values

```java
List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null);

// nullsLast() method
names.sort(Comparator.nullsLast(Comparator.naturalOrder()));
System.out.println("Sorting names with null values last:");
System.out.println(names);
System.out.println();
```
Output:
```shell
Sorting names with null values last:
[Alice, Bob, Charlie, null, null]
```

### reversed()

`default Comparator<T> reversed()`
- Returns a comparator that sorts the elements in the reverse order of the comparator on which it was invoked.
  Example:
```java
List<Person> people=Arrays.asList(
        new Person("Alice",25),
        new Person("Alice",30),
        new Person("Bob",30),
        new Person("Charlie",18),
        new Person("Charlie",20));

// reversed()
Comparator<Person> reversedComparator = Comparator.comparingInt(Person::getAge).reversed();
people.sort(reversedComparator);
System.out.println("Sorting people by age in reverse order:");
System.out.println(people);
```
Output:
```shell
Sorting people by age in reverse order:
[{name='Alice', age=30}, {name='Bob', age=30}, {name='Alice', age=25}, {name='Charlie', age=20}, {name='Charlie', age=18}]
```