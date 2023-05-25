package comparator_enhancements;

/*
 * Example demonstrating the enhancements in Comparator interface.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

/*
Output:
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
 */